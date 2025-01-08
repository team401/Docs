---
title: Common PhotonVision Problems
parent: Using AprilTags
layout: home
---

# Common PhotonVision Problems

## When I select one of my cameras, the feed doesn't change, and my settings don't persist
Assuming you waited a few seconds before trying to change settings, this is most likely happening because the name of your camera is the same as that of another camera. If you're using Arducam cameras, install the [Arducam Serial Number Modification Tool](https://docs.arducam.com/UVC-Camera/Serial-Number-Tool-Guide/#software) and change the name of one or both of the conflicting cameras. We recommend naming cameras in accordance with their position on the robot, eg: `front-right`, `back-center`.

## I can't ping my coprocessor
Ping (or ssh)`photonvision.local` instead of the device's actual IP. It seems like the PhotonVision daemon somehow disrupts standard Ubuntu Server networking configs.

## I get a 'Something Nasty' error message when I try to ssh into the coprocessor
This means you connected to a different device on the same address (probably another PhotonVision coprocessor). Run `ssh-keygen photonvision.local` and the issue should be resolved.

## If all else fails, RTFM
If your problem is not one of those covered above, try looking at the [troubleshooting section of PhotonVision docs](https://docs.photonvision.org/en/latest/docs/troubleshooting/common-errors.html).