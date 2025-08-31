
# Vision

Modelled after the 2025 advantage kit vision template, this vision subsystem runs on photon vision. Within the subsystem, poses are rejected according to their field position and average tag distance. If they aren't rejected, they are then passed on to the drive's pose estimator.

## Dependencies

- AdvantageKit - used for the advanced logging provided within AdvantageScope
- PhotonVision - framework used to read results from cameras and filter poses out from AprilTags
