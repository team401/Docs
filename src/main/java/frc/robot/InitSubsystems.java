package frc.robot;

import frc.robot.constants.ModeConstants;
import frc.robot.generated.TunerConstants;
import frc.robot.subsystems.descorer.DeScorerSubsystem;
import frc.robot.subsystems.descorer.PivotIOSim;
import frc.robot.subsystems.descorer.PivotIOTalonFX;
import frc.robot.subsystems.descorer.WheelIOSim;
import frc.robot.subsystems.descorer.WheelIOTalonFX;
import frc.robot.subsystems.drive.Drive;
import frc.robot.subsystems.drive.GyroIO;
import frc.robot.subsystems.drive.GyroIOPigeon2;
import frc.robot.subsystems.drive.ModuleIO;
import frc.robot.subsystems.drive.ModuleIOSim;
import frc.robot.subsystems.drive.ModuleIOTalonFX;

public final class InitSubsystems {
  public static DeScorerSubsystem initDescorer() {
    return switch (ModeConstants.CURRENT_MODE) {
      case REAL -> new DeScorerSubsystem(new PivotIOTalonFX(), new WheelIOTalonFX());
      case SIM -> new DeScorerSubsystem(new PivotIOSim(), new WheelIOSim());
      default -> throw new UnsupportedOperationException("no type supported");
    };
  }

  public static Drive initDrive() {
    return switch (ModeConstants.CURRENT_MODE) {
      case REAL ->
      // Real robot, instantiate hardware IO implementations
      new Drive(
          new GyroIOPigeon2(),
          new ModuleIOTalonFX(TunerConstants.FrontLeft),
          new ModuleIOTalonFX(TunerConstants.FrontRight),
          new ModuleIOTalonFX(TunerConstants.BackLeft),
          new ModuleIOTalonFX(TunerConstants.BackRight));

      case SIM ->
      // Sim robot, instantiate physics sim IO implementations
      new Drive(
          new GyroIO() {},
          new ModuleIOSim(TunerConstants.FrontLeft),
          new ModuleIOSim(TunerConstants.FrontRight),
          new ModuleIOSim(TunerConstants.BackLeft),
          new ModuleIOSim(TunerConstants.BackRight));

      default ->
      // Replayed robot, disable IO implementations
      new Drive(
          new GyroIO() {},
          new ModuleIO() {},
          new ModuleIO() {},
          new ModuleIO() {},
          new ModuleIO() {});
    };
  }
}
