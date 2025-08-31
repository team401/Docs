
# Import coppercore vision project into robot code

To import vision simply add this line to the robot code's build.gradle under dependencies similar to how other coppercore dependencies are added

```groovy
dependencies {
    ...
    implementation "io.github.team401.coppercore:vision:$version"
    ...
}
```

## Adding Vision to RobotContainer.java

### Initialize Vision

Begin by initializing drive subsystem followed by instantiating a VisionLocalizer with VisionIO's based on simulation / real / replay \

***Sim Example:***

```java
vision =
            new VisionLocalizer(
                swerveDrive::addVisionMeasurement,
                VisionConstants.fieldLayout,
                new double[0],
                new VisionIOPhotonSim("front", robotToCamera0, swerveDrive::getPose, VisionConstants.fieldLayout),
                new VisionIOPhotonSim("back", robotToCamera1, swerveDrive::getPose, VisionConstants.fieldLayout));
```

VisionIO classes expect a name, robot to camera translation, pose supplier, and field layout.
Additionally, the visionConsumer can be changed within a later method by running `vision.setVisionConsumer(yourConsumer)`.

***Note:*** This allows for adding a dummy method during initialization (accepting a Pose2d, double, and Matrix<N3, N1> and returning nothing). However, a real method should be added later (possibly after running null check on drive) to ensure vision estimates are incorporated.

### Using Replay

For replay, io implementations are disabled (the same number of io's should still be added) like so:

```java
vision = new VisionLocalizer(swerveDrive::addVisionMeasurement, VisionConstants.fieldLayout, new double[0], new VisionIO() {}, new VisionIO() {});
```

## Looking at Vision Logs

### Inputs

Each VisionIO has auto logged inputs. These include a connected status, latest target observed, poses observed, tags used, and the average tag distance.
By looking at the tag id's, it is easy to see how well your camera is performing, higher tag counts show good camera placement

### Outputs

This is where the benefit of Advantage Kit comes in. A plethora of data is available including a list of all poses observed, which ones were rejected, and which ones were accepted.

#### Individual Camera Data

***Located under `RealOutputs/Vision/camera/(index)`***

this is where you can find the poses observed by the individual camera. It is helpful to look here to make sure each camera is placed in an optimal spot for viewing AprilTags.

#### Summary Data

***Located under `RealOututs/Vision/Summary/`***

This is where a full summary of poses is found. It compiles poses viewed from each io for a quick overview, this is helpful to ensure that poses are being rejected when they should be.
