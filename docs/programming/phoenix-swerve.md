
# Using Phoenix Swerve

## Introduction

Swerve Drive is a unique type of drivetrain used in robotics. It allows a robot to move in any direction while maintaining any orientation (often referred to as holonomic drive). This is achieved by having each wheel on a separate swivel, allowing it to rotate independently. The wheels are typically driven by individual motors, providing precise control over the robot's movement. This makes Swerve Drive particularly useful in situations where agility and maneuverability are key. For more information on what swerve is, visit [6624's Swerve Docs](https://compendium.readthedocs.io/en/latest/tasks/drivetrains/swerve.html).

## Generating Swerve Code

401 uses [CTRE's Phoenix Pro Swerve Generator](https://pro.docs.ctr-electronics.com/en/latest/docs/tuner/tuner-swerve/index.html) for our swerve code. This lets us write less code and enables us to utilize Phoenix Pro's various benefits.

Follow the tutorial on the generator site to create a new project.

## Common Errors and Tips

- When [verifying steer](https://pro.docs.ctr-electronics.com/en/latest/docs/tuner/tuner-swerve/validating-drivetrain.html#verify-steer), you might encounter a problem where the "Start" and "Stop" buttons are missing, they are simply underneath the toolbar. Hide it and the buttons should appear!
- The variable `kSlipCurrentA` in `TunerConstants` should be the current at which the wheels start to slip **per individual motor**.
- When controlling the drivetrain with `setControl(...)`, make sure to include `.withDriveRequestType(DriveRequestType.Velocity)` inside the method. This will allow you to utilize the feedforward and feedback values you tuned earlier in `TunerConstants`. For example:

```java linenums="1"
setControl(
    new new SwerveRequest.FieldCentric()
        .withVelocityX(vx)
        .withVelocityY(vy)
        .withRotationalRate(omega)
        .withDeadband(0.0)
        .withRotationalDeadband(0.0)
        .withDriveRequestType(DriveRequestType.Velocity)
);
```
