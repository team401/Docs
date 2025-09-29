package frc.robot.constants;

import static edu.wpi.first.units.Units.Amps;
import static edu.wpi.first.units.Units.Degrees;
import static edu.wpi.first.units.Units.KilogramSquareMeters;
import static edu.wpi.first.units.Units.Rotations;
import static edu.wpi.first.units.Units.RotationsPerSecond;

import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import coppercore.parameter_tools.json.JSONExclude;
import coppercore.parameter_tools.json.JSONSync;
import coppercore.parameter_tools.json.JSONSyncConfigBuilder;
import coppercore.parameter_tools.path_provider.EnvironmentHandler;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.Current;
import edu.wpi.first.units.measure.MomentOfInertia;
import edu.wpi.first.wpilibj.Filesystem;

public class WheelConstants {
  @JSONExclude
  public static final JSONSync<WheelConstants> synced =
      new JSONSync<WheelConstants>(
          new WheelConstants(),
          "WheelConstants.json",
          EnvironmentHandler.getEnvironmentHandler().getEnvironmentPathProvider(),
          new JSONSyncConfigBuilder().build());

  public final Integer wheelMotorId = 1; // placeholder
  public final Integer wheelRotorSensorId = 1; // placeholder

  /**
   * FusedCANcoder sensor to mechanism ratio
   *
   * <p>see talonFX docs:
   * https://api.ctr-electronics.com/phoenix6/latest/java/com/ctre/phoenix6/configs/FeedbackConfigs.html#SensorToMechanismRatio
   */
  public final Double sensorToMechanismRatio = 1.0; // TODO: Actual value

  public final Double wheelReduction = 20.0; // placeholder

  @JSONExclude public final Double rotorToSensorRatio = wheelReduction;

  public final InvertedValue wheelMotorInvertedValue = InvertedValue.Clockwise_Positive;

  public final NeutralModeValue wheelNeutralModeValue = NeutralModeValue.Brake;

  public final Current wheelSupplyCurrentLimit = Amps.of(40.0);
  public final Current wheelStatorCurrentLimit = Amps.of(40.0);

  /** Peak forward and reverse current for FieldOriented */
  public final Current peakFOCCurrent = Amps.of(40.0);

  public final Double wheelKG = 0.0; // TODO: Automatic feedforward characterization
  public final Double wheelKS = 0.0;
  public final Double wheelKV = 0.0;
  public final Double wheelKA = 0.0;

  public final Double wheelKP = 0.0; // TODO: Tune these
  public final Double wheelKI = 0.0;
  public final Double wheelKD = 0.0;

  // This value is a a Double because RotationsPerSecond doesn't serialize properly with JSONSync
  public final Double wheelMotionMagicCruiseVelocityRotationsPerSecond =
      0.1; // maybe look for real value

  @JSONExclude
  public final AngularVelocity wheelMotionMagicCruiseVelocity =
      RotationsPerSecond.of(wheelMotionMagicCruiseVelocityRotationsPerSecond); // TODO: Tune this!

  public final Double wheelMotionMagicExpo_kA = 6.0; // IDK if these are the real values
  public final Double wheelMotionMagicExpo_kV = 6.0; //

  /** The wheel can be this far away from the goal and considered "at the setpoint" */
  public final Angle wheelSetpointEpsilon = Degrees.of(1.0); // find real value

  public final Angle wheelSpinAmount = Degrees.of(1.0); // find real value

  public static final class Sim {
    @JSONExclude
    public static final JSONSync<WheelConstants.Sim> synced =
        new JSONSync<WheelConstants.Sim>(
            new WheelConstants.Sim(),
            Filesystem.getDeployDirectory() // Don't use environment handler for sim constants
                .toPath()
                .resolve("constants/PivotConstants.Sim.json")
                .toString(),
            new JSONSyncConfigBuilder().build());

    // This value is a Double because MomentOfInertia units don't serialize properly with JSONSync
    public final Double wheelMomentOfInertiaKgM2 = 0.0672304487; // find real value

    @JSONExclude
    public final MomentOfInertia wheelMomentOfInertia =
        KilogramSquareMeters.of(wheelMomentOfInertiaKgM2);

    public final Angle wheelStartingAngle = Rotations.of(0.0);
  }
}
