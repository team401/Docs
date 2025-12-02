# Setting up a Coprocessor

## Installing Ubuntu

When getting a new coprocessor, it will likely have Windows or some other undesirable operating system installed. We use Ubuntu Server for our coprocessors.

You will need:

- The coprocessor and its power supply
- A Thumbdrive (4GB minimum)
- A USB mouse and keyboard to use the installer
- A monitor. For the trigkey mini-PCs we adopted in fall of 2025, using HDMI cable for data and a USB-C for power will allow you to use the touchscreen monitor we normally use for SnakeScreen.

With your resources assembled,

- [x] Navigate to [ubuntu.com](https://ubuntu.com/). In the navigation bar at the top, go to `Products > Ubuntu Server`. Download the latest image.

- [x] Copy the image to your thumbdrive with a tool like [Balena Etcher](https://etcher.balena.io/).

- [x] Plug the thumbdrive into the coprocessor, reboot it, and look for a message telling you what key to press to enter the bootloader. This is `Del` for our trigkey mini-PCs. Boot from the thumbdrive to run the installer.

- [x] Advance through the install wizard using default settings except for the following:

    - Use `minimal install` rather than the standard install.

    - If there is an option to set up networking, you can try to do so here. This will provide a GUI.
      If you skip setting up the network here, you will need to specify the network configuration manually below, which is what we did.

    - Install OpenSSH server when prompted.

    - Make sure you set a hostname, username, and password that is consistent with other coprocessors and consult other members and mentors of the subteam. Label the machine physically with the correct hostname and username, and potentially also the password.  For instance, we set `team401-photonvision1` or `team401-photonvision2` as the hostname, and `team401` as the username.

- [x] Once you've made it to a terminal, you'll have to set up networking. However, since you've used a minimal install, it's a bit more challenging than normal:

    - Many of the next steps will require administrator permissions.

    Enter a root shell with:

    ```sh
    sudo su - 
    ```

    Now that you have elevated permissions, **be very careful** as many confirmations will be skipped.

    - First, check what interfaces you have with:

    ```sh
    ip link
    ```

    You should see something like `wlp88s0`. Look for one that starts with `wl` for a wireless interface.
    Also look for one that starts with `en`, such as `enp89s0`. This will be your wired Ethernet interface.

- [x] Set up netplan. To that end, create yaml files in
    `/etc/netplan/` to configure interfaces on startup. You
    can find docs on the YAML format on the [netplan
    docs](https://netplan.readthedocs.io/en/stable/netplan-yaml/).

    To that end, you need to create two files in `/etc/netplan`.
    Since you don't have an editor, you need to write these files with cat.
    To set up Wi-Fi, create a file such as `20-wifi-chromebook.yaml` in `/etc/netplan` with this content:
```yaml
# cat > /etc/netplan/20-wifi-chromebook.yaml
network:
  version: 2
  wifis:
    wlp88s0:
      optional: true
      access-points:
        "access point name SSID":
          password: "xxxxxx"
      dhcp4: true
      dhcp6: false
^D  <- just type Control-D here
```
    Replace `wlp88s0` with the name of the WiFi interface you learned earlier.
    Replace `access point name SSID` with the SSID of your access point, and enter the WiFi password.
    Make sure to keep the double quotes.
    Finally, run (from a root shell),
```bash
chmod go-r /etc/netplan/20-wifi-chromebook.yaml
netplan apply
```
    This will render (=apply) this network configuration.

- [x] Test network connectivity.

    - If your WiFi provides Internet connectivity, you should now be able
      to update packages with `apt update` and `apt upgrade`.

    - If you need to know your assigned IP address, run `ip addr`. Look for
      a section that corresponds to the `wlp88s0` interface:
```
3: wlp88s0: <BROADCAST,MULTICAST,UP,LOWER_UP> mtu 1500 qdisc noqueue state UP group default qlen 1000
    inet 10.90.161.58/16 brd 10.90.255.255 scope global dynamic noprefixroute wlp88s0
       valid_lft 34652sec preferred_lft 34652sec
```
    In this example, `10.90.161.58` is the IP address assigned.

    - Since openssh is enabled, you should be able to `ssh team401@10.90.161.58` from any
      laptop connected to the same subnet as the robot.  Do this so you can copy and paste the
      following commands.

    - Install `ping` with `apt install iputils-ping`.

    - Install a text editor like Vim (`apt install vim`).

- [x] Add the setup for the static ethernet. In `/etc/netplan`,  create `10-ethernet-static.yaml` with this content:
```yaml
network:
  version: 2
  ethernets:
    enp89s0:
      optional: true
      dhcp4: false
      dhcp6: false
      addresses:
        - 10.4.1.11/24
```
    where `enp89s0` should be the name of the Ethernet interface from the previous step.
    Change the permissions to satisfy netplan's expectations:

    ```bash
    chmod go-r /etc/netplan/10-ethernet-static.yaml
    netplan apply
    ```

    - Reboot the machine with `shutdown -r now`.

    - The machine should boot up without delay and connect to the network.
    The netplan configuration should be permanent.

## Installing Photonvision.

- [x] To install Photonvision, we are following the instructions for [Other Debian-Based Co-Processor Installation](https://docs.photonvision.org/en/latest/docs/advanced-installation/sw_install/other-coprocessors.html).

   Currently, these are:
```bash
$ wget https://git.io/JJrEP -O install.sh
$ sudo chmod +x install.sh
$ sudo ./install.sh
$ sudo reboot now
```
   This will install the latest version of PhotonVision.
   For whatever reason, Photonvision will make a number of configuration changes,
   one of which will be to activate `NetworkManager` as the default renderer for `netplan`.
   This should not cause any issues.

   After Photonvision is installed and running, visit the URL of the machine
   using port 5800; for instance, `http://10.90.161.58:5800/` where you need to replace `10.90.161.58`
   with the IP reported by `ip a`.  Note that your laptop must be connected to the
   same network (typically, WiFi network) as the MiniPC.

## Changing BIOS settings

To help improve performance, we've made the following changes to the BIOS:

- Advanced -> Power & Performance -> CPU - Power Management Control -> View/Configure Turbo Options:
    - Energy-efficient Turbo - OFF - Hopefully prevents a little bit of opportunistic throttling of turbo frequency
- Boot -> Fast Boot - ON (boot faster??)

We still need to find and modify the setting to make the coprocessor boot when power is applied (or, if it is already enabled, document it here!).
