---
title: Optional Software
parent: Getting Started
layout: home
---


# Optional Software

If you are just trying to get started with progrmaming, don't worry about installing the Optional software yet.

## Vendor Specific Tools

Some FRC vendors, such as Cross the Road Electronics and REV Robotics, provide their own software tools for configuring their components.  The installation instructions for these tools can be found on the vendor websites.  Latest versions of these tools should be installed on the Driver Station laptop.  ***If you are the Lead Programmer, you are responsible for ensuring the latest version of this software is installed on the Driver Station laptop!***

### Common Vendor Tools
 - Rev Hardware Client
 - CTRE Tuner X

## Elastic Dashboard

The WPIlib suite comes with SmartDashboard and the Shuffleboard dashboard, but SmartDashboard is extremely bare and students tend to report Shuffleboard as buggy and tiresome to use. Elastic Dashboard is a newer Fluttr dashboard prefered by the drive team. ***The Lead Programmer should ensure that Elastic is installed on the Driver Station laptop. This is what the drive team is used to using to check robot status and select the auto routine.***

## FRC Update Suite (Windows Only)

The FRC Update Suite is a large installer released by FIRST and National Instruments every year.  Despite the confusing name, the installer is actually standalone, and does not "update" anything.  The Update Suite will remove older versions of itself if installing a new version, but it can also be installed by itself without any previous versions.  The FRC Update Suite installs the following software:

* **Driver Station**: The program that is used to control the physical robot.  It reads joysticks and other input devices attached to your computer, and transmits them to the robot.  It also manages the enabled state of the robot, and the robot cannot be enabled without it.  Only one Driver Station can be connected to the robot at a time.  [This FIRST ScreenSteps page](https://wpilib.screenstepslive.com/s/currentCS/m/driver_station/l/144976-frc-driver-station-powered-by-ni-labview) has a more detailed overview of the Driver Station.
* **roboRIO Imaging Tool**: The program that is used to update the operating system and firmware of the roboRIO.  [This FIRST ScreenSteps page](https://wpilib.screenstepslive.com/s/currentCS/m/getting_started/l/1009233-imaging-your-roborio) has a more detailed overview of the Imaging Tool, as well as instructions on how to use it on a roboRIO.
* **Other software**: The Update Suite also contains other miscellaneous software that is typically not ever used on our team.

The Update Suite is **optional.**  Nothing inside it is important to the code development process, and the two important components are installed on our Driver Station laptop.  This laptop can be used to enable and test the robot, as well as to image the roboRIO.  The Update Suite is also only compatible with Windows (7 and higher).  [This FIRST ScreenSteps page](https://wpilib.screenstepslive.com/s/currentCS/m/cpp/l/1027499-installing-the-frc-update-suite-all-languages) shows how to install the Update Suite.  ***If you are the Lead Programmer, you are responsible for ensuring the latest version of this software is installed on the Driver Station laptop!***

## FRC Radio Configuration Utility (Windows Only)

The Radio Configuration Utility is used to configure the Wi-Fi radio (router) used onboard the robot.  This utility can be run in several different modes:

* **Team Mode:** This mode configures the radio to create a Wi-Fi network.  This allows the Driver Station to connect directly to the robot, and we use this mode for robots that will be used at demos.  ***If you are the Outreach Director, you are responsible for ensuring that a radio configured in this mode is present on the robot prior to a demo.  Contact the Lead Programmer if necessary.  The orange "field radio" WILL NOT WORK outside of the shop.***
* **Offseason Mode:** This mode is designed to configure radios for offseason events, but we use it to configure our orange "field radio" to connect to the black Wi-Fi router mounted on the wall near the door.  The Driver Station laptop is connected to the black router directly via an ethernet cable.  This setup ensures a highly reliable connection to the robot, and we use this mode on the current year's robot when testing it in the shop.  ***If you are the Lead Programmer, you are responsible for ensuring the "shop radio" is configured at all times in this mode!***
* **Event Mode:** This mode is not accessible by teams, but is used at actual events.  Special laptops are present at all events to configure radios to event mode, which allows them to communicate with the field.

The Radio Configuration utility is written in Java, but only works on Windows due to the way FIRST chose to implement the underlying network code.  This utility is **optional.**  This software will always be present on the Driver Station laptop, and radios very infrequently have to be reconfigured.  [This FIRST ScreenSteps page](https://wpilib.screenstepslive.com/s/currentCS/m/getting_started/l/144986-programming-your-radio) shows how to install the Radio Configuration Utility, and [this guide]() ***ADD LINK*** shows how to use it to configure the radios for our team's unique setup.  **Do not follow the ScreenSteps instructions for configuring the radios, only follow the install instructions.**  ***If you are the Lead Programmer, you are responsible for ensuring the latest version of this software is installed on the Driver Station laptop!***

