---
title: Using AprilTags
parent: Programming
has_children: true
layout: home
---

# Using AprilTags
{: .no_toc }

AprilTags are a vital part of the modern FRC control system. They allow a robot to localize itself on the field without relying on dead-reckoning. Use the topics on this document to set up a robust AprilTag localization system.

## PhotonVision

Team 401 uses a piece of open-source software called [PhotonVision](https://photonvision.org) to run our vision pipeline. We recommend reading their [docs](https://docs.photonvision.org/en/latest) to learn how to set it up for your year. Also feel free to read [Common PhotonVision Problems]({{ site.baseurl }}/Programming/PhotonVision-Problems.html).

## Overlayroot

If you're using a Beelink or other mini-PC running Ubuntu Server, we recommend setting up `overlayroot` to ensure the operating system survives a sudden power loss. If the PC shuts of suddenly without overlayroot enabled, you risk breaking the OS installation, and you will have to reinstall. See [Using Overlayroot]({{ site.baseurl }}/Programming/Using-Overlayroot.html) for more details.

## Kalman Filter

As far as an FRC student is concerned, a Kalman filter is a giant pile of linear algebra that combines measurements from unreliable sources. For a robot pose estimator, one can specify expected standard deviations for the x-axis, the y-axis, and robot rotation or theta. For detailed, high school-level information on the mechanics of a Kalman filter, look [here](https://thekalmanfilter.com/kalman-filter-explained-simply/), [here](https://docs.wpilib.org/en/stable/docs/software/advanced-controls/state-space/state-space-observers.html), or at [the Matlab video series](https://youtu.be/mwn8xhgNpFY?si=U2H4U4Lw_r9oYQGj) on the subject. For information on using WPIlib's pose estimator object, look [here](https://docs.wpilib.org/en/stable/docs/software/advanced-controls/state-space/state-space-pose-estimators.html).

For more information on what should inform AprilTag standard deviations, read [What Affects AprilTag Accuracy?]({{ site.baseurl }}/Programming/AprilTag-Accuracy.html)