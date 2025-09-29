package frc.robot.constants;

import coppercore.parameter_tools.path_provider.EnvironmentHandler;
import edu.wpi.first.wpilibj.Filesystem;

public class JsonConstants {
  public static void loadConstants() {
    EnvironmentHandler.getEnvironmentHandler(
        Filesystem.getDeployDirectory().toPath().resolve("constants/config.json").toString());

    FeatureFlags.synced.loadData();
    PivotConstants.synced.loadData();
    PivotConstants.Sim.synced.loadData();
    WheelConstants.synced.loadData();
    WheelConstants.Sim.synced.loadData();

    featureFlags = FeatureFlags.synced.getObject();
    pivotConstants = PivotConstants.synced.getObject();
    pivotConstantsSim = PivotConstants.Sim.synced.getObject();
    wheelConstants = WheelConstants.synced.getObject();
    wheelConstantsSim = WheelConstants.Sim.synced.getObject();
  }

  public static FeatureFlags featureFlags;
  public static PivotConstants pivotConstants;
  public static PivotConstants.Sim pivotConstantsSim;
  public static WheelConstants wheelConstants;
  public static WheelConstants.Sim wheelConstantsSim;
}
