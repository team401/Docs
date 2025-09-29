package frc.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/** Object to handle switching between test modes. */
public class TestModeManager {
  public enum TestMode {
    PivotCurrentTuning,
    PivotClosedLoopTuning,
    None, // Default test mode that does nothing until a new one is selected.
  }

  private static SendableChooser<TestMode> testModeChooser;

  /**
   * Initialize test modes by publishing the test mode chooser. This method should be called by the
   * Robot, as it doesn't run automatically
   */
  public static void init() {
    testModeChooser = new SendableChooser<TestMode>();

    testModeChooser.setDefaultOption("None", TestMode.None);

    testModeChooser.addOption("Pivot Current Tuning", TestMode.PivotCurrentTuning);
    testModeChooser.addOption("Pivot Closed-Loop Tuning", TestMode.PivotClosedLoopTuning);

    SmartDashboard.putData("Test Mode Selector", testModeChooser);
  }

  public static TestMode getTestMode() {
    if (DriverStation.isTest()) {
      return testModeChooser.getSelected();
    } else {
      return TestMode.None;
    }
  }
}
