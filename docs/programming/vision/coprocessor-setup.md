# Setting up a Coprocessor

## Installing Ubuntu

When getting a new coprocessor, it will likely have Windows or some other undesirable operating system installed. We use Ubuntu Server for our coprocessors.

You will need:

- The coprocessor and its power supply
- A Thumbdrive (4GB minimum)
- A USB mouse and keyboard to use the installer
- A monitor. For the trigkey mini-PCs we adopted in fall of 2025, using HDMI cable for data and a USB-C for power will allow you to use the touchscreen monitor we normally use for SnakeScreen.

With your resources assembled,

- [ ] Navigate to [ubuntu.com](https://ubuntu.com/). In the navigation bar at the top, go to `Products > Ubuntu Server`. Download the latest image.

- [ ] Copy the image to your thumbdrive with a tool like [Balena Etcher](https://etcher.balena.io/).

- [ ] Plug the thumbdrive into the coprocessor, reboot it, and look for a message telling you what key to press to enter the bootloader. This is `Del` for our trigkey mini-PCs. Boot from the thumbdrive to run the installer.

- [ ] Advance through the install wizard using default settings except for the following:

    - Use `minimal install` rather than the standard install.

    - Install OpenSSH server.

    - Make sure you set a hostname, username, and password that is consistent with other coprocessors and consult other members and mentors of the subteam. Label the machine physically with the correct hostname and username, and potentially also the password.

- [ ] Once you've made it to a terminal, you'll have to set up a wifi connection. However, since you've used a minimal install, it's a bit more challenging than normal:

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

    Enable it with:

    ```sh
    ip link set <interface> up
    ```

    - Next, create a wpa_supplicant configuration file to configure a network SSID and password:

    ```sh
    wpa_passphrase "<SSID>" "<Password>" > /etc/wpa_supplicant/wpa_supplicant.conf
    ```

    - Start wpa_supplicant in the background:

    ```sh
    wpa_supplicant -Bc /etc/wpa_supplicant/wpa_supplicant.conf -i <interface>
    ```

    - To get an IP address on the local network, start dhcpd:

    ```sh
    dhcpd
    ```

    - You can update packages with `apt update` and `apt upgrade`. Install `ping` with `apt install iputils-ping`.

    - At this point, we recommend you install a text editor like Vim (`apt install vim`).

    - Reboot the machine with `shutdown -r now`.

## Permanently configuring network connection for ethernet and wifi

Create yaml files in `/etc/netplan/` to configure interfaces on startup. You can find docs on the YAML format on the [netplan docs](https://netplan.readthedocs.io/en/stable/netplan-yaml/).

**We have yet to successfully configure this. As soon as we do (probably Monday, 8/20/2025) this section will be updated.**