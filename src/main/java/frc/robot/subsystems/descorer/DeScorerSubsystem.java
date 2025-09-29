package frc.robot.subsystems.descorer;

import static edu.wpi.first.units.Units.Degrees;
import static edu.wpi.first.units.Units.RadiansPerSecond;
import static edu.wpi.first.units.Units.Rotations;
import static edu.wpi.first.units.Units.RotationsPerSecond;
import static edu.wpi.first.units.Units.Volts;
import static edu.wpi.first.units.Units.VoltsPerRadianPerSecond;
import static edu.wpi.first.units.Units.VoltsPerRadianPerSecondSquared;

import coppercore.parameter_tools.LoggedTunableNumber;
import coppercore.wpilib_interface.UnitUtils;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.MutAngle;
import frc.robot.TestModeManager;
import frc.robot.constants.JsonConstants;
import org.littletonrobotics.junction.Logger;

public class DeScorerSubsystem {
  PivotIO pivotio;
  PivotIOInputsAutoLogged pivotInputs = new PivotIOInputsAutoLogged();
  PivotIOInputsAutoLogged pivotOutputs = new PivotIOInputsAutoLogged();

  enum Height {
    L2,
    L3
  }

  MutAngle goalAngle = Rotations.mutable(0.0);
  MutAngle clampedGoalAngle = Rotations.mutable(0.0);

  MutAngle minAngle = JsonConstants.pivotConstants.pivotMinAngle.mutableCopy();
  MutAngle maxAngle = JsonConstants.pivotConstants.pivotMaxAngle.mutableCopy();

  LoggedTunableNumber pivotkP;
  LoggedTunableNumber pivotkI;
  LoggedTunableNumber pivotkD;

  LoggedTunableNumber pivotkS;
  LoggedTunableNumber pivotkV;
  LoggedTunableNumber pivotkA;
  LoggedTunableNumber pivotkG;

  LoggedTunableNumber pivotCruiseVelocity;
  LoggedTunableNumber pivotExpokV;
  LoggedTunableNumber pivotExpokA;

  LoggedTunableNumber pivotTuningSetpointRotations;
  LoggedTunableNumber pivotTuningOverrideAmps;

  WheelIO wheelio;
  WheelIOInputsAutoLogged wheelInputs = new WheelIOInputsAutoLogged();
  WheelIOInputsAutoLogged wheelOutputs = new WheelIOInputsAutoLogged();

  LoggedTunableNumber wheelkP;
  LoggedTunableNumber wheelkI;
  LoggedTunableNumber wheelkD;

  LoggedTunableNumber wheelkS;
  LoggedTunableNumber wheelkV;
  LoggedTunableNumber wheelkA;
  LoggedTunableNumber wheelkG;

  LoggedTunableNumber wheelCruiseVelocity;
  LoggedTunableNumber wheelExpokV;
  LoggedTunableNumber wheelExpokA;

  LoggedTunableNumber wheelTuningSetpointRotations;
  LoggedTunableNumber wheelTuningOverrideAmps;

  public DeScorerSubsystem(PivotIO pivotio, WheelIO wheelio) {
    pivotkP =
        new LoggedTunableNumber("PivotTunables/pivotkP", JsonConstants.pivotConstants.pivotKP);
    pivotkI =
        new LoggedTunableNumber("PivotTunables/pivotkI", JsonConstants.pivotConstants.pivotKI);
    pivotkD =
        new LoggedTunableNumber("PivotTunables/pivotkD", JsonConstants.pivotConstants.pivotKD);

    pivotkS =
        new LoggedTunableNumber("PivotTunables/pivotkS", JsonConstants.pivotConstants.pivotKS);
    pivotkV =
        new LoggedTunableNumber("PivotTunables/pivotkV", JsonConstants.pivotConstants.pivotKV);
    pivotkA =
        new LoggedTunableNumber("PivotTunables/pivotkA", JsonConstants.pivotConstants.pivotKA);
    pivotkG =
        new LoggedTunableNumber("PivotTunables/pivotkG", JsonConstants.pivotConstants.pivotKG);

    pivotCruiseVelocity =
        new LoggedTunableNumber(
            "PivotTunables/pivotCruiseVelocity",
            JsonConstants.pivotConstants.pivotMotionMagicCruiseVelocity.in(RotationsPerSecond));
    pivotExpokV =
        new LoggedTunableNumber(
            "PivotTunables/pivotExpokV", JsonConstants.pivotConstants.pivotMotionMagicExpo_kV);
    pivotExpokA =
        new LoggedTunableNumber(
            "PivotTunables/pivotExpokA", JsonConstants.pivotConstants.pivotMotionMagicExpo_kA);

    pivotTuningSetpointRotations =
        new LoggedTunableNumber("PivotTunables/pivotTuningSetpointRotations", 0.0);
    pivotTuningOverrideAmps = new LoggedTunableNumber("PivotTunables/pivotTuningOverrideAmps", 0.0);

    this.pivotio = pivotio;

    wheelkP =
        new LoggedTunableNumber("WheelTunables/wheelkP", JsonConstants.wheelConstants.wheelKP);
    wheelkI =
        new LoggedTunableNumber("WheelTunables/wheelkI", JsonConstants.wheelConstants.wheelKI);
    wheelkD =
        new LoggedTunableNumber("WheelTunables/wheelkD", JsonConstants.wheelConstants.wheelKD);

    wheelkS =
        new LoggedTunableNumber("WheelTunables/wheelkS", JsonConstants.wheelConstants.wheelKS);
    wheelkV =
        new LoggedTunableNumber("WheelTunables/wheelkV", JsonConstants.wheelConstants.wheelKV);
    wheelkA =
        new LoggedTunableNumber("WheelTunables/wheelkA", JsonConstants.wheelConstants.wheelKA);
    wheelkG =
        new LoggedTunableNumber("WheelTunables/wheelkG", JsonConstants.wheelConstants.wheelKG);

    wheelCruiseVelocity =
        new LoggedTunableNumber(
            "WheelTunables/wheelCruiseVelocity",
            JsonConstants.wheelConstants.wheelMotionMagicCruiseVelocity.in(RotationsPerSecond));
    wheelExpokV =
        new LoggedTunableNumber(
            "WheelTunables/wheelExpokV", JsonConstants.wheelConstants.wheelMotionMagicExpo_kV);
    wheelExpokA =
        new LoggedTunableNumber(
            "WheelTunables/wheelExpokA", JsonConstants.wheelConstants.wheelMotionMagicExpo_kA);

    wheelTuningSetpointRotations =
        new LoggedTunableNumber("WheelTunables/wheelTuningSetpointRotations", 0.0);
    wheelTuningOverrideAmps = new LoggedTunableNumber("WheelTunables/wheelTuningOverrideAmps", 0.0);

    this.wheelio = wheelio;
  }

  /**
   * Runs periodically when the robot is enabled
   *
   * <p>Does NOT run automatically! Must be called by the subsystem
   */
  public void periodic() {
    sendGoalAngleToIO();

    pivotio.updateInputs(pivotInputs);
    pivotio.applyOutputs(pivotOutputs);
    wheelio.updateInputs(wheelInputs);
    wheelio.applyOutputs(wheelOutputs);

    Logger.processInputs("pivot/inputs", pivotInputs);
    Logger.processInputs("pivot/outputs", pivotOutputs);
    Logger.processInputs("wheel/inputs", wheelInputs);
    Logger.processInputs("wheel/outputs", wheelOutputs);
  }

  /** This method must be called from the subsystem's test periodic! */
  public void testPeriodic() {
    switch (TestModeManager.getTestMode()) {
      case PivotClosedLoopTuning:
        pivotio.setOverrideMode(false);
        LoggedTunableNumber.ifChanged(
            hashCode(),
            (pid) -> {
              pivotio.setPID(pid[0], pid[1], pid[2]);
            },
            pivotkP,
            pivotkI,
            pivotkD);

        LoggedTunableNumber.ifChanged(
            hashCode(),
            (ff) -> {
              pivotio.setFF(ff[0], ff[1], ff[2], ff[3]);
            },
            pivotkS,
            pivotkV,
            pivotkA,
            pivotkG);

        LoggedTunableNumber.ifChanged(
            hashCode(),
            (maxProfile) -> {
              pivotio.setMaxProfile(
                  RadiansPerSecond.of(0.0),
                  VoltsPerRadianPerSecondSquared.ofNative(maxProfile[0]),
                  VoltsPerRadianPerSecond.ofNative(maxProfile[1]));
            },
            pivotExpokA,
            pivotExpokV);

        LoggedTunableNumber.ifChanged(
            hashCode(),
            (setpoint) -> {
              setGoalAngle(Rotations.of(setpoint[0]));
            },
            pivotTuningSetpointRotations);
        break;
      case PivotVoltageTuning:
        LoggedTunableNumber.ifChanged(
            hashCode(),
            (setpoint) -> {
              pivotio.setOverrideVoltage(Volts.of(setpoint[0]));
            },
            pivotTuningOverrideAmps);
        pivotio.setOverrideMode(true);
        break;
      case WheelClosedLoopTuning:
        wheelio.setOverrideMode(false);
        LoggedTunableNumber.ifChanged(
            hashCode(),
            (pid) -> {
              wheelio.setPID(pid[0], pid[1], pid[2]);
            },
            wheelkP,
            wheelkI,
            wheelkD);

        LoggedTunableNumber.ifChanged(
            hashCode(),
            (ff) -> {
              wheelio.setFF(ff[0], ff[1], ff[2], ff[3]);
            },
            wheelkS,
            wheelkV,
            wheelkA,
            wheelkG);

        LoggedTunableNumber.ifChanged(
            hashCode(),
            (maxProfile) -> {
              wheelio.setMaxProfile(
                  RadiansPerSecond.of(0.0),
                  VoltsPerRadianPerSecondSquared.ofNative(maxProfile[0]),
                  VoltsPerRadianPerSecond.ofNative(maxProfile[1]));
            },
            wheelExpokA,
            wheelExpokV);

        LoggedTunableNumber.ifChanged(
            hashCode(),
            (setpoint) -> {
              setGoalAngle(Rotations.of(setpoint[0]));
            },
            wheelTuningSetpointRotations);
        break;
      case WheelVoltageTuning:
        LoggedTunableNumber.ifChanged(
            hashCode(),
            (setpoint) -> {
              wheelio.setOverrideVoltage(Volts.of(setpoint[0]));
            },
            wheelTuningOverrideAmps);
        wheelio.setOverrideMode(true);
        break;
      default:
        break;
    }
  }

  public void sendGoalAngleToIO() {
    updateClampedGoalAngle();

    pivotio.setPivotGoalPos(clampedGoalAngle);
  }

  /**
   * Based on the bounds previously set, clamp the last set goal height to be between the bounds.
   *
   * <p>If the goal height is outside of the bounds and the bounds are expanded, this function will
   * still behave as expected, as the mechanism remembers its unclamped goal height and will attempt
   * to get there once it is allowed.
   */
  private void updateClampedGoalAngle() {
    clampedGoalAngle.mut_replace(UnitUtils.clampMeasure(goalAngle, minAngle, maxAngle));

    Logger.recordOutput("pivot/clampedGoalAngle", clampedGoalAngle);
  }

  /**
   * Set the goal angle the pivot will to control about.
   *
   * <p>This goal angle will be clamped by the allowed range of motion
   *
   * @param goalAngle The new goal angle
   */
  public void setGoalAngle(Angle goalAngle) {
    this.goalAngle.mut_replace(goalAngle);

    Logger.recordOutput("pivot/goalAngle", goalAngle);
  }

  /**
   * Sets the minimum and maximum allowed angles that the pivot may target.
   *
   * <p>When not in override mode, the goal angle of the pivot will be clamped to be between these
   * values before it is sent to the IO. When these clamps change, the original goal angle is
   * clamped to be within the new bounds.
   *
   * @param minAngle The minimum angle, which will be clamped between pivotMinAngle and
   *     pivotMaxAngle before being applied
   * @param maxAngle The maximum angle, which will be clamped between pivotMinAngle and
   *     pivotMaxAngle before being applied
   */
  public void setAllowedRangeOfMotion(Angle minAngle, Angle maxAngle) {
    setMinAngle(minAngle);
    setMaxAngle(maxAngle);
  }

  /**
   * Sets the minimum allowed angle that the pivot may target.
   *
   * <p>When not in override mode, the goal angle of the pivot will be clamped to be between these
   * values before it is sent to the IO. When these clamps change, the original goal angle is
   * clamped to be within the new bounds.
   *
   * @param minAngle The minimum angle, which will be clamped between pivotMinAngle and
   *     pivotMaxAngle before being applied
   */
  public void setMinAngle(Angle minAngle) {
    this.minAngle.mut_replace(
        UnitUtils.clampMeasure(
            minAngle,
            JsonConstants.pivotConstants.pivotMinAngle,
            JsonConstants.pivotConstants.pivotMaxAngle));

    Logger.recordOutput("pivot/minAngle", minAngle);
  }

  /**
   * Sets the maximum allowed angle that the pivot may target.
   *
   * <p>When not in override mode, the goal angle of the pivot will be clamped to be between these
   * values before it is sent to the IO. When these clamps change, the original goal angle is
   * clamped to be within the new bounds.
   *
   * @param maxAngle The maximum angle, which will be clamped between pivotMinAngle and
   *     pivotMaxAngle before being applied
   */
  public void setMaxAngle(Angle maxAngle) {
    this.maxAngle.mut_replace(
        UnitUtils.clampMeasure(
            maxAngle,
            JsonConstants.pivotConstants.pivotMaxAngle,
            JsonConstants.pivotConstants.pivotMaxAngle));

    Logger.recordOutput("pivot/maxAngle", maxAngle);
  }

  /**
   * Get the current angle of the pivot
   *
   * @return
   */
  public Angle getPivotAngle() {
    return pivotInputs.pivotPosition;
  }

  public Angle getWheelAngle() {
    return wheelInputs.wheelPosition;
  }

  /**
   * Get a reference to the pivot's IO. This should be used to update PID, motion profile, and feed
   * forward gains, and to set brake mode/disable motors. This method exists to avoid the need to
   * duplicate all of these functions between the mechanism and the IO.
   *
   * @return the pivot mechanism's IO
   */
  public PivotIO getPivotIO() {
    return pivotio;
  }

  public WheelIO getWheelIO() {
    return wheelio;
  }

  /** Set whether or not the motor on the pivot should be disabled */
  public void setMotorsDisabled(boolean disabled) {
    pivotio.setMotorsDisabled(disabled);
    wheelio.setMotorsDisabled(disabled);
  }

  public void descoreAt(Height height) {
    if (height == height.L2) {
      setGoalAngle(Degrees.of(0.0)); // find real value
    } else if (height == height.L3) {
      setGoalAngle(Degrees.of(0.0)); // find real value
    }
    sendGoalAngleToIO();
  }

  public void stopDescoring() {
    setGoalAngle(Degrees.of(0.0));
    sendGoalAngleToIO();
    setMotorsDisabled(true);
  }
}
