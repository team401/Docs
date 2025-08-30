---
title: Programming Your Radio
parent: Hardware Setup
grand_parent: Programming
has_children: false
layout: home
---

# Programming Your Radio

As of the 2025 season, Team 401 uses the [VH-109 radio from VividHosting](https://frc-radio.vivid-hosting.net/).

The [quick start guide](https://frc-radio.vivid-hosting.net/overview/quick-start-guide) from the VividHosting Docs is pretty good. However, the documentation for how to configure the radios can be slightly confusing.

## Configuring a radio for shop testing

The radio configuration that we have found to be best is to configure the radio in "Robot Radio Mode".

We recommend suffixing your radios with something unique, and labelling them as such. For instance, we suffix our radios with their year and a number.

Configuring the radio in "Robot Radio Mode" will make the radio act as a Wifi 6 client, and it will try to connect to an access-point. To use it for at home testing, do one of the following:

### Use a second VH-109 as an access point

For testing with Wifi 6 performance, configure a second VH-109 as an access point. Instructions for this can be found [on the VividHosting docs website](https://frc-radio.vivid-hosting.net/overview/practicing-at-home#vh-109-as-an-access-point-recommended).

You will still need the radio on your robot to be configured as a robot radio. You will also need a way to power the access point radio using some sort of wall adapter

To connect to the radio for shop testing, you can:

 - Use a wifi-6 capable laptop
 - Use an ethernet cable to connect directly to the access point radio

### Use the Robot Radio as a 2.4 GHz Access Point

When DIP switch #3 is in the on position, it enables the radio's 2.4ghz access point mode. When the radio cannot connect to a wifi 6 access point and is not connected to a computer via ethernet, it will begin broadcasting its own network. This means that a radio configured in "Robot Radio Mode" can be used just like an older version 2.4ghz radio and function as an access point, with the only configuration change necessary being enabling DIP switch #3.

## Quickly Configuring Multiple Radios

Sometimes, you may need to quickly flash multiple radios (e.g. a new release of radio firmware comes out, or it is a new FRC season, and you need to update all of the radios in the shop).

The following steps will guide you through the most expedient way to do this. More detailed, better instructions can be found in [VividHosting's docs](https://frc-radio.vivid-hosting.net/overview/quick-start-guide).

### Initial Setup

This method uses a robot to power the radio. Power your radio using the robot's electrical setup.

1. First, download and extract the [network assistant tool](https://frc-radio.vivid-hosting.net/overview/programming-your-radio-at-home/network-assistant-tool) from Vivid-Hosting. This tool automatically configures a static IP address for your ethernet port.

2. Next, navigate to the [radio firmware page](https://frc-radio.vivid-hosting.net/overview/firmware-releases) and download both the release for radios prior to 1.2.0 AND the release for radios currently at 1.2.x. Keep this page open so that you can easily copy the checksums when installing the firmware later.

With these 3 resources downloaded, you can start configuring your first radio.

### For Each Radio

Repeat these steps for each radio you configure.

1. With the robot off, wire the radio to be powered. Technically, you could power the radio with a power adapter as well, but if you already have a robot on hand it is convenient to use it for power.

2. Turn the robot on, and connect your computer to the robot radio __using the `DS` port on the radio__.

3. Run the Network Assistant Tool (it must be run as administrator). Select the ethernet port that you connected the radio to, and click the button to configure the port. It seems that sometimes the configuration form renders incorrectly if you don't run the Network Assistant Tool every time you configure a radio, even if you ran it when you configured the last radio.

4. Wait for the radio to be powered on, based on the [LED status indicators](https://frc-radio.vivid-hosting.net/overview/led-status-indications). The PWR light will be ON and the SYS light will either be ON or blinking at 1hz.

5. Check the current firmware version: Once radio has finished booting, refresh the configuration page and navigate to "(radio ip)/status"  in your browser to check the status (the radio IP will already by in the URL after being opened by the Network Assistant Tool). Near the bottom of the status page, the current firmware version will be displayed. This version will tell you what firmware version to install in the next step:

   If the version is before 1.2.0, you will have to use the firmware file that ends in a string of numbers.

   If the version is 1.2.x or later, use the firmware file that ends in 1.2_X.

6. Navigate back to the configuration page. Select the correct firmware file. Then, go back to the firmware downloads page that you download earlier, and copy the checksum from the file. Paste it in the field of the radio configuration page and click upload.

7. Wait for the radio to finish installing firmware. You will know it is done when the SYS light stops blinking quickly and instead is either solid ON or blinking at 1hz.

8. Scroll to the top of the page, select "Robot Radio Mode," type in your team number, and any network suffix you want, and choose a password. Click 'configure'.

9. You can verify that the configuration is updated, unplug the ethernet cable that connects your computer to the radio. Then, turn DIP switch #3 to the ON position and refresh your computer's wifi menu until the radio's wifi network appears.