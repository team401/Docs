---
title: Coppercore - Drive With Joysticks Command
parent: Programming
has_children: false
layout: home
---

# Drive With Joysticks Command
This command, placed inside of coppercore's wpilib_interface library, has several advanced features to help make driving smoother. These include:
- enhanced sensitivity via squaring the magnitude of linear and rotational velocities
- adjustable deadbands
- adjustable max speeds (linear and rotational)

# Using the Command
## Importing Library
To import the command simply add this line to the robot code's build.gradle under dependencies similar to how other coppercore dependencies are added
```
dependencies {
    ...
    implementation "io.github.team401.coppercore:wpilib_interface:$version"
    ...
}
```
## Setting Up Drive Subsystem
In order to use this command, the drive subsystem must implement the DriveTemplate located in wpilib_interface library:
```
public class SwerveDrive implements DriveTemplate {
    ...
}
```
***Note:*** by implementing DriveTemplate, you DO NOT have to extend SubsystemBase, this step is already included within the DriveTemplate. 

### Adding SetGoalSpeeds method
The DriveTemplate also requires that the driveSubsytem have a setGoalSpeeds method. This is how the DriveWithJoysticks command will tell drive what speeds are being commmanded. An example of adding this to the talonfx-swerve used in 2025 is shown below.
```
public class Drive implements DriveTemplate {
    public ChassisSpeeds goalSpeeds = new ChassisSpeeds();
    //...
    public void setGoalSpeeds(ChassisSpeeds speeds) {
        this.goalSpeeds = speeds;
    }

    // NOTE: parameter was removed from this method since we set goal speeds elsewhere
    public void runVelocity() { 
        // Calculate module setpoints
        ChassisSpeeds discreteSpeeds = ChassisSpeeds.discretize(goalSpeeds, 0.02); // only difference is found on this line, where speeds discretized are based on set goal speeds
        SwerveModuleState[] setpointStates = kinematics.toSwerveModuleStates(discreteSpeeds);
        SwerveDriveKinematics.desaturateWheelSpeeds(setpointStates, TunerConstants.kSpeedAt12Volts);

        // Log unoptimized setpoints and setpoint speeds
        Logger.recordOutput("SwerveStates/Setpoints", setpointStates);
        Logger.recordOutput("SwerveChassisSpeeds/Setpoints", discreteSpeeds);

        // Send setpoints to modules
        for (int i = 0; i < 4; i++) {
            modules[i].runSetpoint(setpointStates[i]);
        }

        // Log optimized setpoints (runSetpoint mutates each state)
        Logger.recordOutput("SwerveStates/SetpointsOptimized", setpointStates);
    }
}
```
Furthermore, to keep things uniform throughout code, any other commands for running velocity should now be sent to setGoalSpeeds method. Braking could be done like so `drive.setGoalSpeeds(new ChassisSpeeds(0));`

### Adjusting RunVelocity
finally, remove the parameter from runVelocity method like above, and add this runVelocity method to the end of the drivetrains periodic method
```
@Override
public void periodic {
    //...
    this.runVelocity();
    //...
}

## Adding Command to RobotContainer
This just involved setting the default command for drive to a new instance of the DriveWithJoysticks command. Linear and angular speeds should match the max of those set in drive subsystem.
```
drive.setDefaultCommand(
    new DriveWithJoysticksCommand(
        drive, // type: DriveTemplate
        leftJoystick, // type: CommandJoystick
        righJoystick, // type: CommandJoystick
         maxLinearSpeed, // type: double (m/s)
         maxAngularSpeed, // type: double (rad/s)
         joystickDeadband // type: double
    )
);
```
***Note:*** If joysticks behave with too much sensitivity (barely tapping causes movement) increase the deadband, maybe 0.05 -> 0.1
