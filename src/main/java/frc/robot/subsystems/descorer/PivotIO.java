package frc.robot.subsystems.descorer;

import static edu.wpi.first.units.Units.Amps;
import static edu.wpi.first.units.Units.Rotations;
import static edu.wpi.first.units.Units.RotationsPerSecond;

import org.littletonrobotics.junction.AutoLog;

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

public interface PivotIO {
    @AutoLog
    public static class PivotIOInputs {
        /**A boolean that is initialized to be false as the controller is not connected.*/
        public boolean connected = false;
        /**Current pivot position as reported by the internal sensor. */
        public MutAngle pivotPosition = Rotations.mutable(0.0);
        /**Current pivot velocity as reported by the internal sensor. */
        public MutAngularVelocity pivotVelocity = RotationsPerSecond.mutable(0.0);
        /**Goal angle of the pivot, as determined by the turning amount*/
        public MutAngle pivotGoalPosition = Rotations.mutable(0.0);
        /**The setpoint target position from Motion Magic Expo */
        public MutAngle pivotSetpointPosition = Rotations.mutable(0.0);
        /**The target angular velocity of the pivot */
        public MutAngularVelocity pivotTargetVelocity = RotationsPerSecond.mutable(0.0);
        /**Supply current of the pivot motor */
        public MutCurrent pivotSupplyCurrent = Amps.mutable(0.0);
        /**Stator current of the pivot motor */
        public MutCurrent pivotStatorCurrent = Amps.mutable(0.0);
        /**
         * The closed-loop output of the pivot controller. This value isn't a unit because phoenix 6
         * doesn't use a unit for this value(as it can be a Voltage or a Current depending on whether
         * or not FOC is used).
         */
        public double pivotClosedLoopOutput = 0.0;
    }
    /**
     * Updates a PivotIOInputs with the current information from sensors and motors.
     * <p>Should be called by the PivotMechanism periodically
     * @param inputs The PivotIOInupts with the latest information
     */
    public default void updateInputs(PivotIOInputs inputs) {}
    /**
     * Set the pivot's goal position.
     * <p>Should be called by the 
     * @param goalPos Goal position of the pivot, as seen by the pivot motor's internal sensor
     */
    public default void setPivotGoalPos(Angle goalPos) {}
    /**Update PID gains for pivot.*/
    public default void setPID(double kP, double kI, double kD) {}
    /**
     * Sets the pivot profile constraints to be sent to Motion Magic Expo
     * @param maxVelocity The maximum angular velocity that the pivot can run to
     * @param expo_kA Output per Voltage unit of target acceleration
     * @param expo_kV Output per Voltage unit of target velocity 
     */
    public default void setMaxProfile(AngularVelocity maxVelocity, Per<VoltageUnit, AngularAccelerationUnit> expo_kA, Per<VoltageUnit, AngularVelocityUnit> expo_kV) {}
    /**
     * Set feedforward gains for closed-loop control
     * @param kS The feedforward gain for static friction
     * @param kV The feedforward gain of velocity
     * @param kA The feedforward gain of acceleration
     * @param kG The feedforward gain of gravity
     */
    public default void setFF(double kS, double kV, double kA, double kG) {}
    /**
     * Set whether or not the motors should brake while idle
     * @param brakeMode A boolean for whether the motors should brake while idle
     */
    public default void setBrakeMode(boolean brakeMode) {}
    /**
     * Set the current limits for the pivot motor
     * @param limits The limits for the pivot motor
     */
    public default void setCurrentLimits(CurrentLimitsConfigs limits) {}
    /**
     * Set whether or not the pivot motor should be disabled
     * @param disabled A boolean for whether the pivot motor should be disabled or not
     */
    public default void setMotorsDisabled(boolean disabled) {}
    /**
     * Set whether or not the pivot is in 'override' mode
     * @param override True if override, false if normal. This value defaults/is initialized to false until changed
     */
    public default void setOverrideMode(boolean override) {}
    /**
     * Set the current to apply in override mode.
     * <p>This is a current because the pivot uses TorqueCurrentFOC for control instead of voltage
     * @param current The current to apply. This will only be applied ofter setOverrideMode(true) is called.
     */
    public default void setOverrideCurrent(Current current) {}
}
