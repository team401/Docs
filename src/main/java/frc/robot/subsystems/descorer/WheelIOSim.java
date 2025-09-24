package frc.robot.subsystems.descorer;

import com.ctre.phoenix6.configs.CurrentLimitsConfigs;

import edu.wpi.first.units.AngularAccelerationUnit;
import edu.wpi.first.units.AngularVelocityUnit;
import edu.wpi.first.units.VoltageUnit;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.Current;
import edu.wpi.first.units.measure.MutAngle;
import edu.wpi.first.units.measure.MutAngularVelocity;
import edu.wpi.first.units.measure.MutCurrent;
import edu.wpi.first.units.measure.Per;

public class WheelIOSim implements WheelIO{
    private Angle goalPos;
    private double kP = 0.0;
    private double kI = 0.0;
    private double kD = 0.0;
    private AngularVelocity maxVelocity;
    private Per<VoltageUnit, AngularAccelerationUnit> expo_kA;
    private Per<VoltageUnit, AngularVelocityUnit> expo_kV;
    private boolean brakeMode = true;
    private boolean disabled = false;
    private boolean overrideMode = false;
    private VoltageUnit voltage;
    private WheelIOInputs inputs = null;
    public void updateInputs(WheelIOInputs inputs) {
        this.inputs = inputs;
    }
    public void setWheelGoalPos(Angle goalPos) {
        this.goalPos = goalPos;
    }
    public void setPID(double kP, double kI, double kD) {
        this.kP = kP;
        this.kI = kI;
        this.kD = kD;
    }
    public void setMaxProfile(AngularVelocity maxVelocity, Per<VoltageUnit, AngularAccelerationUnit> expo_kA, Per<VoltageUnit, AngularVelocityUnit> expo_kV) {
        this.maxVelocity = maxVelocity;
        this.expo_kA = expo_kA;
        this.expo_kV = expo_kV;
    }
    public void setFF(double kS, double kV, double kA, double kG) {}
    //no real world physics in SIM
    public void setBrakeMode(boolean brakeMode) {
        this.brakeMode = brakeMode;
    }
    public void setCurrentLimits(CurrentLimitsConfigs limits) {
    //no limits in SIM
    }
    public void setMotorsDisabled(boolean disabled) {
        this.disabled = disabled;
    }
    public void setOverrideMode(boolean override) {
        this.overrideMode = override;
    }
    public void setOverrideVoltage(VoltageUnit voltage) {
        this.voltage = voltage;
    }
    
}
