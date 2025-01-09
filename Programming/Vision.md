---
title: Vison
parent: Programming
has_children: true
layout: home
---

# Vision
{: .no_toc }
Modelled after the 2025 advantage kit vision template, this vision subsystem runs on photon vision. Within the subsystem, poses are rejected according to their field position and average tag distance. If they aren't rejected, they are then passed on to the drive's pose estimator. 

## Table Of Contents

1. TOC
{:toc}

## Dependencies
- Advantage Kit - used for the advanced logging provided within AdvantageScope
- Photon Vision - framework used to read results from cameras and filter poses out from AprilTags