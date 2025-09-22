package frc.robot.constants;


import static edu.wpi.first.units.Units.Amps;
import static edu.wpi.first.units.Units.Degrees;
import static edu.wpi.first.units.Units.KilogramSquareMeters;
import static edu.wpi.first.units.Units.Meters;
import static edu.wpi.first.units.Units.Rotations;
import static edu.wpi.first.units.Units.RotationsPerSecond;

import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.ctre.phoenix6.signals.SensorDirectionValue;

import coppercore.parameter_tools.json.JSONExclude;
import coppercore.parameter_tools.json.JSONSync;
import coppercore.parameter_tools.json.JSONSyncConfigBuilder;
import coppercore.parameter_tools.path_provider.EnvironmentHandler;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.Current;
import edu.wpi.first.units.measure.Distance;
import edu.wpi.first.units.measure.MomentOfInertia;
import edu.wpi.first.wpilibj.Filesystem;

public class PivotConstants {
  @JSONExclude
  public static final JSONSync<PivotConstants> synced =
      new JSONSync<PivotConstants>(
          new PivotConstants(),
          "PivotConstants.json",
          EnvironmentHandler.getEnvironmentHandler().getEnvironmentPathProvider(),
          new JSONSyncConfigBuilder().build());

  public final Integer pivotMotorId = 1; //placeholder 
  public final Integer pivotRotorSensorId = 1; //placeholder

  /**
   * FusedCANcoder sensor to mechanism ratio
   *
   * <p>see talonFX docs:
   * https://api.ctr-electronics.com/phoenix6/latest/java/com/ctre/phoenix6/configs/FeedbackConfigs.html#SensorToMechanismRatio
   */
  public final Double sensorToMechanismRatio = 1.0; // TODO: Actual value

  public final Double pivotReduction = 20.0; //placeholder

  @JSONExclude public final Double rotorToSensorRatio = pivotReduction;

  public final InvertedValue pivotMotorInvertedValue = InvertedValue.Clockwise_Positive;

  public final NeutralModeValue pivotNeutralModeValue = NeutralModeValue.Brake;

  public final Current pivotSupplyCurrentLimit = Amps.of(40.0);
  public final Current pivotStatorCurrentLimit = Amps.of(40.0);

  /** Peak forward and reverse current for FieldOriented */
  public final Current peakFOCCurrent = Amps.of(40.0);

  public final Double pivotKG = 0.0; // TODO: Automatic feedforward characterization
  public final Double pivotKS = 0.0;
  public final Double pivotKV = 0.0;
  public final Double pivotKA = 0.0;

  public final Double pivotKP = 0.0; // TODO: Tune these
  public final Double pivotKI = 0.0;
  public final Double pivotKD = 0.0;

  // This value is a a Double because RotationsPerSecond doesn't serialize properly with JSONSync
  public final Double pivotMotionMagicCruiseVelocityRotationsPerSecond = 0.1; //maybe look for real value

  @JSONExclude
  public final AngularVelocity pivotMotionMagicCruiseVelocity =
      RotationsPerSecond.of(pivotMotionMagicCruiseVelocityRotationsPerSecond); // TODO: Tune this!

  public final Double pivotMotionMagicExpo_kA = 6.0; //
  public final Double pivotMotionMagicExpo_kV = 6.0; //

  //public final Angle pivotCANcoderAbsoluteSensorDiscontinuityPoint =
    //  Rotations.of(0.3); // TODO: Confirm this
  //public final Angle wristCANcoderMagnetOffset = Rotations.of(0.0); // TODO: Tune this value
  //public final SensorDirectionValue wristCANcoderSensorDirection =
    //  SensorDirectionValue.CounterClockwise_Positive;

  // These clamps are the default clamps for the pivot, as well as limiting the moving clamps of the
  // pivot themselves.
  public final Angle pivotMinMinAngle = Rotations.of(-0.8); // find real value for this
  public final Angle pivotMaxMaxAngle = Rotations.of(0.25); // find real value for this

  /** The maximum angle the pivot can be at while passing by the crossbar without hitting it. */
  public final Angle maxCrossBarSafeAngle = Rotations.of(0.0); // TODO: Actual value

  /** The pivot can be this far away from the goal and considered "at the setpoint" */
  public final Angle pivotSetpointEpsilon = Degrees.of(1.0); //find real value

  public static final class Sim {
    @JSONExclude
    public static final JSONSync<PivotConstants.Sim> synced =
        new JSONSync<PivotConstants.Sim>(
            new PivotConstants.Sim(),
            Filesystem.getDeployDirectory() // Don't use environment handler for sim constants
                .toPath()
                .resolve("constants/PivotConstants.Sim.json")
                .toString(),
            new JSONSyncConfigBuilder().build());

    // This value is a Double because MomentOfInertia units don't serialize properly with JSONSync
    public final Double pivotMomentOfInertiaKgM2 = 0.0672304487; //find real value

    @JSONExclude
    public final MomentOfInertia pivotMomentOfInertia =
        KilogramSquareMeters.of(pivotMomentOfInertiaKgM2);

    public final Distance pivotArmLength = Meters.of(0.5); // find real value

    public final Angle pivotMinAngle = Rotations.of(-0.80); // find real value
    public final Angle pivotMaxAngle = Rotations.of(0.30); // find real value

    public final Angle pivotStartingAngle = Rotations.of(0.0);
  }
}
