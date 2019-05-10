---
title: Gears
parent: Technical
has_children: true
nav_order: 1
---

# Gears

This document provides an introduction to gears with a focus on FRC. For more detail on a topic please ask a team lead or the internet.

## What is a Gear?

A gear is “*a rotating machine part having cut teeth, or cogs, which mesh with another toothed part to transmit torque. Geared devices can change the speed, torque, and direction of a power source.”*

Most of the gears that we use are *spur* or *straight cut* gears that have teeth projected radially. Spur gears produce no axial thrust.

*Pinions* are input gears on motors (red). *Bull gears* or just *gears*  are output gears driven by a pinion (blue).

![Gear animation showing pinion and bull meshing](res/pinionAnimation.gif)

One other important takeaway from this animation is the directionality of rotation - *meshed gears spin in opposite directions*. Be sure to remember this when designing systems!

## Gear Ratios

Gears can increase or decrease speed and torque. Speed is inversely dependent on torque - *"as speed increases, torque decreases"*. 

To calculate a gear ratio between an input gear and an output gear: $$ Ratio =  \frac{Teeth_{Input}}{Teeth_{Output}} $$

Given the input speed and torque and gearing ratio the output speed and torque can be found. 

For speed: $$ Speed_{Output} = Speed_{Input} * Ratio $$ 

And for torque: $$ Torque_{Output} = \frac{Torque_{Input}}{Ratio} $$