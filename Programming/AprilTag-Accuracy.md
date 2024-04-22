---
title: What Affects AprilTag Accuracy?
parent: Using AprilTags
grand_parent: Programming
has_children: false
layout: home
---

# What Affects AprilTag Accuracy?

Strangely, there don't seem to be very comprehensive resources on the factors influencing the accuracy of an AprilTag pose. Here's some information we've been able to accumulate on the topic.

_**Future documenters: Just because this page has many words in it does not mean it's done. This page is based on the anecdotal experience of one senior, and makes a starting point, but not taken as gospel.**_

## Number of Tags

We recommend setting your AprilTag strategy in PhotonVision to `MULTI_TAG_PNP_ON_COPROCESSOR`. [PNP](https://en.wikipedia.org/wiki/Perspective-n-Point) is an algorithm that takes a set of points in screen-space with known real-world location and extrapolates the location of the camera. This algorithm gets more accurate with more points. _**We recommend rejecting single-tag camera measurements, as PNP fails to produce consistent results with only four points.**_ To learn more about this affect, read about [pose ambiguity](https://docs.wpilib.org/en/stable/docs/software/vision-processing/apriltag/apriltag-intro.html#d-to-3d-ambiguity) on WPIlib Docs.

## Distance

The accuracy of an AprilTag measurement is inversely proportional to the average distance of the tags from the camera. We don't have a standardized mechanism for gauging accuracy based on distance, but it is recommended to test heavily, especially in auto. 

## Angle

Unlike distance, the average angle of an AprilTag measurement produces unreliable results both when it is too big and too small. We recommend gating the maximum average tag angle at between 60° and 100°, and adjusting the minimum angle based on the tag layout of the field. A minimum angle is often less necessary than a maximum angle as it produces less detrimental variations.

## Calibration

While the average tag distance and angle will always cause inaccuracies eventually, they tend to exasperate poor camera calibrations. Be sure to read the [calibration section of PhotonVision Docs thoroughly](https://docs.photonvision.org/en/latest/docs/calibration/calibration.html). As of the 2024 season, we recommend using the builtin PhotonVision camera calibration process, with the MrCal checkbox enabled.

If two cameras are identical, a _finals-match-in-four-minutes_ calibration solution might include copying the calibration data from one camera to another. This sort of works, but can introduce inaccuracies. If time allows, calibrate every camera individually and be sure to back up the `json` file in a memorable location.