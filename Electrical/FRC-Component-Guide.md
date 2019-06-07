---
title: FRC Component Guide
parent: Electrical
has_children: false
nav_order: 3
---

# FRC Component Guide

There are a number of electrical and pneumatic components which are vital to the success of a FRC robot. Thus, it is important to know basic information about each component, each component's function, and how to properly wire these components.

 1. TOC
{:toc}

## Components for Control

### roboRIO

![](../res/roboRIO.jpg)

The roboRIO is the main controller of every FRC robot. It uses CAN and PWM to provide instructions to motor controllers and components such as the Pneumatic Control Module. The roboRIO can also deal with digital inputs from

In addition to this, the roboRIO also provides the power for the Robot Signal Light and is connected to the router over Ethernet.

#### Connection Information

| Component                   | Connection                                                   | Appropriate Gauge/Type         |
| --------------------------- | ------------------------------------------------------------ | ------------------------------ |
| Power Distribution Panel    | roboRIO power input from PDP 10A protected channel           | 18 AWG silicone wire           |
| Robot Signal Light          | roboRIO power output to signal light from "RSL" port         | 22 AWG silicone wire           |
| Router                      | Ethernet                                                     | CAT6 Cable                     |
| Pneumatic Control Module    | CAN output to PCM from roboRIO CAN port                      | CAN Wire (22 AWG Yellow/Green) |
| Servo                       | PWM output to servo from roboRIO PWM rail                    | 22 AWG 3-pin wire              |
| Banner Photoelectric Sensor | Banner Sensor data output to roboRIO Digital Input/Output (DIO) rail | 22 AWG 3-pin wire              |

#### Wiring Information

##### roboRIO Power

In order to connect the power wires to the roboRIO, use a small flathead screwdriver to loosen the screws on the side of the power input connector. These screws are shown in the image below:

![](../res/roboRIOPowerConnector.jpg)

This connector is not labeled as it is on the roboRIO, but it is very important to note that **the red wire MUST go into the port labeled "V"** and that **the black wire MUST go into the port labeled "C".** Strip about ~5/16" of jacketing off each wire, insert the wires into the connector, and then secure the wires by tightening each screw.

##### CAN 

Strip ~5/16" of jacketing off of the yellow and green wires, then use your fingernail or a flathead screwdriver to push down the "buttons" of the Weidmuller terminals. This is shown below.

![](../res/weidmuller.png)

Insert the yellow wire into the terminal marked "YLW" and the green wire into the terminal marked "GRN". After inserting the wires, give them a gentle tug to verify that the connection is secure.

If you are using ferrules, insert each stripped wire into each ferrule and then crimp the ferrules using the appropriate crimping tool. **The white ferrules are intended for 18 AWG wire**; thus, it is important to **strip twice as much wire and then fold the exposed wire in half in order to double its effective wire radius.** After the ferrules have been crimped and they have been tug tested, push the two wires into their respective terminals. No "button" pushing is required for this.

more to come

