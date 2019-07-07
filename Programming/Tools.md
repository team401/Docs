---
title: Tools
parent: Programming
has_children: true
nav_order: 1

---

# Tools

This page covers the various tools we use during the FRC software development process.  Some of these tools are optional for pure code development.  The order of this list represents the order each tool should be installed, and links are provided to more detailed installation instructions if applicable.

1. TOC
{:toc}

## Java SE (Installation Required)

Java SE (Standard Edition) is the version of the JVM (Java Virtual Machine) and JDK (Java Development Kit) that is used in FRC.  While other versions of Java exist (Java EE, etc.),  Java SE is the most common and is the version that is downloaded by default from Java's main website.  There are two popular organizations publishing versions of Java SE: Oracle and OpenJDK.  Oracle is a corporation that publishes free but closed source versions of Java SE, while OpenJDK is a free and open source implementation.  In all recent versions of Java SE, they are completely functionally equivalent.  [This guide](Installing-JDK.md) shows how to install the Oracle release of Java SE, and specifically the JDK release.  JDK releases contain the tools required to develop Java programs, while JRE releases only contain the tools to run compiled Java programs.

## Git (Installation Required)

Git is a version control system used to track the history of each file in the robot code folder.  This allows us to easily revert changes to the code to an earlier working version, as well as to ensure that the latest version of our code is always stored in one place.  GitHub is an online Git hosting provider, which means that our code is stored not only on your computer, but also on GitHub's servers.  This ensures our code is never accidentally lost or deleted, and provides a central location for all programmers to upload new code to.  Git also provides conflict resolution features, which means multiple programmers can work on the same file and upload changes without issues.  [This guide](Installing-Git.md) shows how to install Git, and [this guide](Using-Git.md) explains the basics of using Git and GitHub.

## IntelliJ IDEA (Installation Required)

IntelliJ IDEA is an IDE (Integrated Development Environment) for writing programs in Java, Kotlin, and many other languages.  Some other IDEs you may have heard of for Java development are Eclipse and NetBeans.  IntelliJ IDEA stands out for its exceptional code completion and suggestion features, which make writing code much faster.  IntelliJ IDEA is also made by the same company (JetBrains) as Kotlin, the language we use on the team.  This ensures tight integration between these two tools.  Finally, IntellIJ IDEA has integrated Git support, meaning instead of having to run Git commands in the console, a GUI is provided for uploading and downloading code from GitHub.  [This guide](Installing-IDEA.md) shows how to install IntelliJ IDEA Community Edition, which is the free release of IntelliJ IDEA.

## Kotlin (No Installation Required)

Kotlin is an object oriented, type safe programming language that runs on the JVM (Java Virtual Machine).  All code written in Kotlin is 100% compatible with code written in Java, meaning that Kotlin programs gain access to the same set of libraries and tools as Java programmers, with the added benefits of Kotlin, such as type inference, shorter functional syntax, etc.  Kotlin is an easy language to learn with prior Java knowledge, and its full Java compatibility makes it a great choice for FRC programming.  Since we use IntelliJ IDEA, Kotlin comes preinstalled and no further installation steps are required

## Gradle (No Installation Required)

Gradle is a build system that manages compiling, testing, and deploying our code, as well as managing all of the libraries that we use in our code.  It was originally designed for Java code, but quickly expanded to support many programming languages, including Kotlin.  Gradle is the official build system as of the 2019 FRC system.  Gradle has excellent built in support in IntelliJ IDEA, which means instead of having to type gradle commands into a console, a GUI is provided.  Gradle can be used as both a system wide application that you have to install, or a "wrapper", which is a small set of files stored in the code folder itself.  The Gradle wrapper has the benefit of being completely portable.  We use the Gradle wrapper for our code development, so no further installation steps are required.

## FRC Update Suite (Installation Optional, Windows Only)

The FRC Update Suite is a large installer released by FIRST and National Instruments every year.  Despite the confusing name, the installer is actually standalone, and does not "update" anything.  The Update Suite will remove older versions of itself if installing a new version, but it can also be installed by itself without any previous versions.  The FRC Update Suite installs the following software:

* **Driver Station**: The program that is used to control the physical robot.  It reads joysticks and other input devices attached to your computer, and transmits them to the robot.  It also manages the enabled state of the robot, and the robot cannot be enabled without it.  Only one Driver Station can be connected to the robot at a time.  [This FIRST ScreenSteps page](https://wpilib.screenstepslive.com/s/currentCS/m/driver_station/l/144976-frc-driver-station-powered-by-ni-labview) has a more detailed overview of the Driver Station.
* **roboRIO Imaging Tool**: The program that is used to update the operating system and firmware of the roboRIO.  [This FIRST ScreenSteps page](https://wpilib.screenstepslive.com/s/currentCS/m/getting_started/l/1009233-imaging-your-roborio) has a more detailed overview of the Imaging Tool, as well as instructions on how to use it on a roboRIO.
* **Other software**: The Update Suite also contains other miscellaneous software that is typically not ever used on our team.

The Update Suite is **optional.**  Nothing inside it is important to the code development process, and the two important components are installed on our Driver Station laptop.  This laptop can be used to enable and test the robot, as well as to image the roboRIO.  The Update Suite is also only compatible with Windows (7 and higher).  [This FIRST ScreenSteps page](https://wpilib.screenstepslive.com/s/currentCS/m/cpp/l/1027499-installing-the-frc-update-suite-all-languages) shows how to install the Update Suite.  ***If you are the Technical Director, you are responsible for ensuring the latest version of this software is installed on the Driver Station laptop!***

## WPILib (Installation Optional)

WPILib is not a "tool" per se, but rather a library used within our code which allows us to control the actual hardware, such as motor controlers, etc., on the robot.  It is included here because starting in 2019, a WPILib installer was also released.  This installer has the ability to install over 2 GB of software on your computer!  The good thing is, we only need one component of it.  The actual WPILib library used in the code is downloaded by Gradle, and does not need to be installed with this tool.  The rest of the installer is used to configure VS Code, which is the officially supported IDE for FRC Java and C++ teams.  We don't use VS Code, so we don't need any of these parts.  The components we do use from this installer include:

* **SmartDashboard/ShuffleBoard:** A dashboard application that is used to see various values published by our robot code, as well as configure settings within our robot code.  SmartDashboard was the name of this tool until the 2018 season, when it was replaced by a new tool: ShuffleBoard.  Both programs are still installed by the installer, but ShuffleBoard is the most up to date dashboard software, and the only supported dashboard starting in 2020.  [This FIRST ScreenSteps page](https://wpilib.screenstepslive.com/s/currentCS/m/shuffleboard) provides a lot of information on using ShuffleBoard from both the application itself, as well as within robot code.  Using dashboards from robot code will be described in other programming tutorials on this site.
* **OutlineViewer**: An application that directly modifies Network Tables values on the robot, as well as provides you the ability to start your own Network Tables server.  Network Tables are described elsewhere on this site, but essentially they are what allows the dashboard application and the robot code to communicate.  They are also used by the Limelight vision camera.  OutlineViewer is a useful tool for viewing these values, but is not used very frequently.

The installation on Windows is provided by an installer, while on Mac and Linux installation is done by simply unzipping an archive into your Documents (or any other) folder.  [This guide](Installing-wpilib-no-vscode.md) shows how to install only the parts of WPILib that we actually need.  These utilities are only ever useful when used with the Driver Station software on an actual robot, so installing them is optional since they will aleady be installed on the Driver Station laptop.  ***If you are the Technical Director, you are responsible for ensuring the latest version of this software is installed on the Driver Station laptop!***

## FRC Radio Configuration Utility (Installation Optional, Windows Only)

The Radio Configuration Utility is used to configure the Wi-Fi radio (router) used onboard the robot.  This utility can be run in several different modes:

* **Team Mode:** This mode configures the radio to create a Wi-Fi network.  This allows the Driver Station to connect directly to the robot, and we use this mode for robots that will be used at demos.  ***If you are the Outreach Director, you are responsible for ensuring that a radio configured in this mode is present on the robot prior to a demo.  Contact the Technical Director if necessary.  The orange "field radio" WILL NOT WORK outside of the shop.***
* **Offseason Mode:** This mode is designed to configure radios for offseason events, but we use it to configure our orange "field radio" to connect to the black Wi-Fi router mounted on the wall near the door.  The Driver Station laptop is connected to the black router directly via an ethernet cable.  This setup ensures a highly reliable connection to the robot, and we use this mode on the current year's robot when testing it in the shop.  ***If you are the Technical Director, you are responsible for ensuring the "shop radio" is configured at all times in this mode!***
* **Event Mode:** This mode is not accessible by teams, but is used at actual events.  Special laptops are present at all events to configure radios to event mode, which allows them to communicate with the field.

The Radio Configuration utility is written in Java, but only works on Windows due to the way FIRST chose to implement the underlying network code.  This utility is **optional.**  This software will always be present on the Driver Station laptop, and radios very infrequently have to be reconfigured.  [This FIRST ScreenSteps page](https://wpilib.screenstepslive.com/s/currentCS/m/getting_started/l/144986-programming-your-radio) shows how to install the Radio Configuration Utility, and [this guide]() ***ADD LINK*** shows how to use it to configure the radios for our team's unique setup.  **Do not follow the ScreenSteps instructions for configuring the radios, only follow the install instructions.**  ***If you are the Technical Director, you are responsible for ensuring the latest version of this software is installed on the Driver Station laptop!***

## Vendor Specific Tools (Installation Optional)

Some FRC vendors, such as Cross the Road Electronics and REV Robotics, provide their own software tools for configuring their components.  The installation instructions for these tools can be found on the vendor websites.  Latest versions of these tools should be installed on the Driver Station laptop.  ***If you are the Technical Director, you are responsible for ensuring the latest version of this software is installed on the Driver Station laptop!***