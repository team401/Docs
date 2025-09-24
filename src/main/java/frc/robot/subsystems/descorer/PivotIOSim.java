package frc.robot.subsystems.descorer;

import static edu.wpi.first.units.Units.KilogramSquareMeters;
import static edu.wpi.first.units.Units.Meters;
import static edu.wpi.first.units.Units.Radians;
import static edu.wpi.first.units.Units.RadiansPerSecond;
import static edu.wpi.first.units.Units.Rotations;
import static edu.wpi.first.units.Units.Seconds;

import org.littletonrobotics.junction.Logger;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.sim.TalonFXSimState;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.MutAngle;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.simulation.SingleJointedArmSim;
import frc.robot.constants.JsonConstants;
import frc.robot.constants.SimConstants;

public class PivotIOSim extends PivotIOTalonFX{

  var pivotMotorSimCollection = pivotMotor.getSimCollection();

  TalonFXSimState pivotMotorSimState = pivotMotor.getSimState();

  private final SingleJointedArmSim pivotSim =
      new SingleJointedArmSim(
          DCMotor.getKrakenX60Foc(1),
          JsonConstants.pivotConstants.pivotReduction,
          JsonConstants.pivotConstants.pivotMomentOfInertia.in(KilogramSquareMeters),
          JsonConstants.pivotConstants.pivotArmLength.in(Meters),
          JsonConstants.pivotConstants.pivotMinAngle.in(Radians),
          JsonConstants.pivotConstants.pivotMaxAngle.in(Radians),
          true,
          JsonConstants.pivotConstants.pivotStartingAngle.in(Radians));

  public void pivotIOSim() {
    super();

    // Initialize sim state so that the first periodic runs with accurate data
    updateSimState();
  }

  MutAngle lastPivotAngle = Radians.mutable(0.0);

  private void updateSimState() {
    Angle pivotAngle = Radians.of(pivotSim.getAngleRads());
    AngularVelocity pivotVelocity = RadiansPerSecond.of(pivotSim.getVelocityRadPerSec());

    Angle diffAngle = pivotAngle.minus(lastPivotAngle);
    lastPivotAngle.mut_replace(pivotAngle);

    pivotRotorSensor.addPosition(diffAngle); //idk if this math is still easy
    pivotRotorSensor.setVelocity(pivotVelocity); //idk if this math is still easy

    Angle rotorDiffAngle = diffAngle.times(JsonConstants.pivotConstants.pivotReduction);
    AngularVelocity rotorVelocity =
        pivotVelocity.times(JsonConstants.pivotConstants.pivotReduction);

        pivotMotorSimState.addRotorPosition(rotorDiffAngle);
        pivotMotorSimState.setRotorVelocity(rotorVelocity);
        pivotMotorSimState.setSupplyVoltage(RobotController.getBatteryVoltage());

        pivotSim.setInputVoltage(pivotMotorSimState.getMotorVoltage());

    Logger.recordOutput("pivotSim/position", pivotAngle.in(Rotations));
  }

  @Override
  public void updateInputs(PivotIOInputs inputs) {
    updateSimState();

    pivotSim.update(SimConstants.simDeltaTime.in(Seconds));

    super.updateInputs(inputs);
  }
}
}
