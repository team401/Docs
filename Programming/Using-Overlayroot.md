---
title: Using Overlayroot
parent: Vision
grand_parent: Programming
has_children: false
layout: home
---

# Using Overlayroot

`overlayroot` is a Linux utility that makes your filesystem appear read-only. If a file is saved or edited, changes will still appear, but the filesystem will reset to some default arrangement after a reboot. Knowing how to enable and disable overlayroot often proves to be a vital skill during competition, in case configurations on the coprocessor need to be changed.

## Installation

Overlayroot can be installed with `sudo apt install overlayroot`. Along with installing the utility, this creates an empty file at `/etc/overlayroot.conf`.

## Configuration

In the context of a 401 PhotonVision coprocessor, the overlayroot config file is only ever in one of two states:
```
overlayroot=""
```
...which disables overlayroot, and:
```
overlayroot="tmpfs:swap=1,recurse=0"
```
...which enables overlayroot with desirable settings. The details about these settings aren't relevant in this context, but can be googled easily ([this](https://spin.atomicobject.com/protecting-ubuntu-root-filesystem/) is a good article).

We would recommend arranging this file like so:
```
# ON:
overlayroot="tmpfs:swap=1,recurse=0"

# OFF:
#overlayroot=""
```
...with the currently inactive configuration commented out. We would also recommend adding a brief text file to the home directory explaining this file's location, along with how to enable and disable overlayroot.

## Enabling/Disabling Overlayroot

The process of enabling overlayroot when it is disabled should be fairly obvious: edit the config file using `sudo vim` or `sudo nano`, and reboot the device.

Disabling overlayroot when it is enabled is more complicated. If the config file is edited and the device rebooted, the config file will revert, and overlayroot will remain enabled! In order to make persistent file changes when overlayroot is enabled, run `sudo overlayroot-chroot`. Now the config file can be edited, and the filesystem will be mutable after a reboot.

In conclusion, to enable overlayroot:
 1. Run `sudo nano /etc/overlayroot.conf`
 2. Edit the file so that the uncommented section reads `overlayroot="tmpfs:swap=1,recurse=0"`
 3. Save and reboot

To disable overlayroot:
 1. Run `sudo overlayroot-chroot`
 2. Run `nano /etc/overlayroot-chroot`
 3. Edit the file so that the uncommented section reads `overlayroot=""`
 4. Save, `exit` and reboot