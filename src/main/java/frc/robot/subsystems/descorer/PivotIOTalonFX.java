package frc.robot.subsystems.descorer;

import static edu.wpi.first.units.Units.Amps;
import static edu.wpi.first.units.Units.Rotations;

import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.configs.FeedbackConfigs;
import com.ctre.phoenix6.configs.MotionMagicConfigs;
import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.configs.TorqueCurrentConfigs;
import com.ctre.phoenix6.controls.MotionMagicExpoVoltage;
import com.ctre.phoenix6.controls.TorqueCurrentFOC;
import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.FeedbackSensorSourceValue;
import com.ctre.phoenix6.signals.GravityTypeValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.units.AngularAccelerationUnit;
import edu.wpi.first.units.AngularVelocityUnit;
import edu.wpi.first.units.VoltageUnit;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.Current;
import edu.wpi.first.units.measure.MutAngle;
import edu.wpi.first.units.measure.MutCurrent;
import edu.wpi.first.units.measure.Per;
import frc.robot.constants.JsonConstants;

public class PivotIOTalonFX implements PivotIO {
    TalonFX pivotMotor = new TalonFX(JsonConstants.pivotConstants.pivotMotorId);
    CANcoder pivotRotorSensor = new CANcoder(JsonConstants.pivotConstants.pivotRoborSensorId);
    
    private TalonFXConfiguration talonFXConfigs;

    private MutAngle pivotGoalPosition = Rotations.mutable(0.0);//placeholder

    private MotionMagicExpoVoltage request = new MotionMagicExpoVoltage(pivotGoalPosition);

    private boolean motorsDisabled = false;

    private boolean isOverriding = false;

    private MutCurrent overrideCurrent = Amps.mutable(0.0);

    public PivotIOTalonFX() {
        talonFXConfigs = new TalonFXConfiguration();
        .withFeedback(new FeedbackConfigs(pivotRotorSensor.Id)
        .withFeedbackSensorSource(FeedbackSensorSourceValue.FusedCancoder)
        .withSensorToMechanismRatio(
            JsonConstants.pivotConstants.sensorToMechanismRatio))
        .withMotorOutput(
            new MotorOutputConfigs()
                .withNeutralMode(JsonConstants.pivotConstants.pivotNeutralModeValue))
        .withCurrentLimits(
            new CurrentLimitsConfigs()
            .withSupplyCurrentLimitEnable(true)
            .withSupplyCurrentLimit(JsonConstants.pivotConstants.pivotSupplyCurrentLimit)
            .withStatorCurrentLimitEnable(true)
            .withStatorCurrentLimit(JsonConstants.pivotConstants.pivotStatorCurrentLimit))
        .withTorqueCurrent(
            new TorqueCurrentConfigs()
                .withPeakForwardTorqueCurrent(JsonConstants.pivotConstants.peakFOCCurrent)
                .withPeakReverseTorqueCurrent(JsonConstants.pivotConstants.peakFOCCurrent))
        .withSlot0(
            new Slot0Configs()
            .withKG(JsonConstants.pivotConstants.pivotKG)
            .withKS(JsonConstants.pivotConstants.pivotKS)
            .withKV(JsonConstants.pivotConstants.pivotKV)
            .withKA(JsonConstants.pivotConstants.pivotKA)
            .withKP(JsonConstants.pivotConstants.pivotKP)
            .withKI(JsonConstants.pivotConstants.pivotKI)
            .withKD(JsonConstants.pivotConstants.pivotKD)
            .withGravityType(GravityTypeValue.Arm_Cosine))
        .withMotionMagic(
            new MotionMagicConfigs()
                .withMotionMagicCruiseVelocity(
                    JsonConstants.pivotConstants.pivotMotionMagicCruiseVelocity)
                .withMotionMagicExpo_kA(JsonConstants.pivotConstants.pivotMotionMagicExpo_kA)
                .withMotionMagicExpo_kV(JsonConstants.pivotConstants.pivotMotionMagicExpo_kV));
        pivotMotor.getConfigurator().apply(talonFXConfigs);

    }
    public void updateInputs(PivotIOInputs inputs) {
        inputs.pivotGoalPosition.mut_replace(pivotGoalPosition);
        inputs.pivotSetpointPosition.mut_replace(
            Rotations.of(pivotMotor.getClosedLoopReference().getValue()));

        inputs.pivotPosition.mut_replace(pivotRotorSensor.getPosition().getValue());
        inputs.pivotVelocity.mut_replace(pivotRotorSensor.getVelocity().getValue());

        inputs.pivotTargetVelocity.mut_setMagnitude(
            pivotMotor.getClosedLoopReferenceSlope().getValue());
        
            inputs.pivotSupplyCurrent.mut_replace(pivotMotor.getSupplyCurrent().getValue());
            inputs.pivotStatorCurrent.mut_replace(pivotMotor.getStatorCurrent().getValue());
    }
    public void applyOutputs(PivotIOInputs outputs){
        if (motorsDisabled) {
            pivotMotor.setControl(new VoltageOut(0.0));
            outputs.pivotClosedLoopOutput = 0.0;
            return;

        }
        else if (isOverriding) {
            pivotMotor.setControl(new TorqueCurrentFOC(overrideCurrent));
            outputs.pivotClosedLoopOutput = overrideCurrent.in(Amps);
            
            return;
        }
        pivotMotor.setControl(request.withPosition(pivotGoalPosition));
        outputs.pivotClosedLoopOutput = pivotMotor.getClosedLoopOutput().getValue();
    }

    public void setPivotGoalPos(Angle goalPos) {
        pivotGoalPosition.mut_replace(goalPos);
    }

    public void setPID(double kP, double kI, double kD) {
        talonFXConfigs.Slot0.kP = kP;//check if im slot zero
        talonFXConfigs.Slot0.kI = kI;
        talonFXConfigs.Slot0.kD = kD;
        
        pivotMotor.getConfigurator().apply(talonFXConfigs);
    }

    public void setMaxProfile(
        AngularVelocity makVelocity,
        Per<VoltageUnit, AngularAccelerationUnit> expo_kA,
        Per<VoltageUnit, AngularVelocityUnit> expo_kV) {
            talonFXConfigs.withMotionMagic(
                new MotionMagicConfigs()
                .withMotionMagicCruiseVelocity(makVelocity)
                .withMotionMagicExpo_kA(expo_kA)
                .withMotionMagicExpo_kV(expo_kV));
        pivotMotor.getConfigurator().apply(talonFXConfigs);
    }
        
    
    public void setFF(double kS, double kV, double kA, double kG) {
        talonFXConfigs.Slot0.kS = kS;
        talonFXConfigs.Slot0.kV = kV;
        talonFXConfigs.Slot0.kA = kA;
        talonFXConfigs.Slot0.kG = kG;

        pivotMotor.getConfigurator().apply(talonFXConfigs);
    }

    public void setBrakeMode(boolean brakeMode) {
        if (brakeMode) {
          talonFXConfigs.MotorOutput.NeutralMode = NeutralModeValue.Brake;
        } else {
          talonFXConfigs.MotorOutput.NeutralMode = NeutralModeValue.Coast;
        }
    
        pivotMotor.getConfigurator().apply(talonFXConfigs);
      }
    
      public void setCurrentLimits(CurrentLimitsConfigs limits) {
        talonFXConfigs.withCurrentLimits(limits);
    
        pivotMotor.getConfigurator().apply(talonFXConfigs);
      }
    
      public void setMotorsDisabled(boolean disabled) {
        motorsDisabled = disabled;
      }
    
      public void setOverrideMode(boolean override) {
        isOverriding = override;
      }
    
      public void setOverrideCurrent(Current current) {
        overrideCurrent.mut_replace(current);
      }  

} 