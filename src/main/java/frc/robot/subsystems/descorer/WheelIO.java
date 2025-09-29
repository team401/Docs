package frc.robot.subsystems.descorer;

import static edu.wpi.first.units.Units.Amps;
import static edu.wpi.first.units.Units.Rotations;
import static edu.wpi.first.units.Units.RotationsPerSecond;

import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import edu.wpi.first.units.AngularAccelerationUnit;
import edu.wpi.first.units.AngularVelocityUnit;
import edu.wpi.first.units.VoltageUnit;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.MutAngle;
import edu.wpi.first.units.measure.MutAngularVelocity;
import edu.wpi.first.units.measure.MutCurrent;
import edu.wpi.first.units.measure.Per;
import edu.wpi.first.units.measure.Voltage;
import org.littletonrobotics.junction.AutoLog;

public interface WheelIO {

  @AutoLog
  public static class WheelIOInputs {
    public boolean connected = false;
    public MutAngle wheelPosition = Rotations.mutable(0.0);
    public MutAngularVelocity wheelVelocity = RotationsPerSecond.mutable(0.0);
    public MutAngle wheelGoalPosition = Rotations.mutable(0.0);
    public MutAngle wheelSetpointPosition = Rotations.mutable(0.0);
    public MutAngularVelocity wheelTargetVelocity = RotationsPerSecond.mutable(0.0);
    public MutCurrent wheelSupplyCurrent = Amps.mutable(0.0);
    public MutCurrent wheelStatorCurrent = Amps.mutable(0.0);
    public double wheelClosedLoopOutput = 0.0;
  }

  public default void updateInputs(WheelIOInputs inputs) {}

  public default void applyOutputs(WheelIOInputs outputs) {}

  public default void setWheelGoalPos(Angle goalPos) {}

  public default void setPID(double kP, double kI, double kD) {}

  public default void setMaxProfile(
      AngularVelocity maxVelocity,
      Per<VoltageUnit, AngularAccelerationUnit> expo_kA,
      Per<VoltageUnit, AngularVelocityUnit> expo_kV) {}

  public default void setFF(double kS, double kV, double kA, double kG) {}

  public default void setBrakeMode(boolean brakeMode) {}

  public default void setCurrentLimits(CurrentLimitsConfigs limits) {}

  public default void setMotorsDisabled(boolean disabled) {}

  public default void setOverrideMode(boolean override) {}

  public default void setOverrideVoltage(Voltage voltage) {}
}
