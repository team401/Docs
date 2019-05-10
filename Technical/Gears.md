---
title: Gears
parent: Technical
has_children: true
has_math: true
nav_order: 1
---

# Gears
{: .no_toc }

## Tabl;

{:toc}

---

This document provides an introduction to gears with a focus on FRC. For more detail on a topic please ask a team lead or the internet.

## What is a Gear?

A gear is “*a rotating machine part having cut teeth, or cogs, which mesh with another toothed part to transmit torque. Geared devices can change the speed, torque, and direction of a power source.”*

Most of the gears that we use are *spur* or *straight cut* gears that have teeth projected radially. Spur gears produce no axial thrust.

*Pinions* are input gears on motors (red). *Bull gears* or just *gears*  are output gears driven by a pinion (blue).

![Gear animation showing pinion and bull meshing](../res/pinionAnimation.gif)

One other important takeaway from this animation is the directionality of rotation - *meshed gears spin in opposite directions*. Be sure to remember this when designing systems!

## Gear Ratios

Gears can increase or decrease speed and torque. Speed is inversely dependent on torque - *"as speed increases, torque decreases"*. 

To calculate a gear ratio between an input gear and an output gear: $$ Ratio =  \frac{Teeth_{Input}}{Teeth_{Output}} $$

Given the input speed and torque and gearing ratio the output speed and torque can be found. 

For rotational speed: $$ Speed_{Output} = Speed_{Input} * Ratio $$ 

And for torque: $$ Torque_{Output} = \frac{Torque_{Input}}{Ratio} $$

### Gear Ratio Example

![](../res/12to48.PNG)

A 12 tooth gear spinning clockwise at a free speed of 100 revolutions per minute with a max torque of 10 foot-pounds meshes with a 48 tooth gear. What speed and torque will the 48 tooth gear have?

Ratio: $$  Ratio =  \frac{Teeth_{Input}}{Teeth_{Output}} = \frac{12\ teeth}{48\ teeth} = \frac{1}{4} $$

Speed:  $$  Speed_{Output} = Speed_{Input} * Ratio  = 100\ RPM * \frac{1}{4} = 25\ RPM$$

Torque: $$ Torque_{Output} = \frac{Torque_{Input}}{Ratio} = \frac{10\ \text{ft-lb}}{\frac{1}{4}} = 4 * 10\ \text{ft-lb} = 40\ \text{ft-lb} $$

The gear pair a 1:4 gear ratio, so the 48 tooth gear will spin counterclockwise at one fourth the speed of the 12 tooth gear but will have four times the torque.