# yocto-pi

Yocto layers for a RaspberryPi image.

## Building the image

This project comes with a containerized development environment which includes all necessary dependencies to perform a Yocto build. By using the [Visual Studio Code](https://code.visualstudio.com/) editor and the _Remote - Containers_ extension (`ms-vscode-remote.remote-containers`), open the editor and you should be prompted to open the workspace in a Docker container already set up with all the build dependencies. For more information, see the [`.devcontainer/Dockerfile`](.devcontainer/Dockerfile) and [`.devcontainer/devcontainer.json`](.devcontainer/devcontainer.json) files. You can also read the Visual Studio Code documentation on [developing inside a container](https://code.visualstudio.com/docs/remote/containers).

If you do not want to use the development container, you will need to install all the [Yocto dependencies](https://docs.yoctoproject.org/brief-yoctoprojectqs/index.html#build-host-packages) on your machine.

To build the RaspberryPi image, follow these steps:

```shell
# Clone the git submodules
git submodule update --init --recursive

# Init the build environment
source sources/poky/oe-init-build-env

# Start the build with bitbake
bitbake core-image-base
```

Once the build is done, the image should be available under `build/tmp/deploy/images/raspberrypi4/core-image-base-raspberrypi4.rootfs.wic.bz2` (from the root of the project).

> Note: The custom layer for compiling bootgen is under `sources/meta-bootgen`.
