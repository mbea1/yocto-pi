FROM ubuntu:22.04

ARG USER=dev
ARG USER_UID=1000
ARG USER_GID=$USER_UID
ARG DEBIAN_FRONTEND=noninteractive

RUN \
  # Add additional packages
  apt-get update && \
  apt-get -y install sudo wget gawk git diffstat unzip texinfo gcc build-essential \
  chrpath socat cpio python3 python3-pip python3-pexpect xz-utils \
  debianutils iputils-ping python3-git python3-jinja2 libegl1-mesa \
  libsdl1.2-dev python3-subunit mesa-common-dev zstd liblz4-tool file \
  locales libacl1 && \
  locale-gen en_US.UTF-8 && \
  # Add non-root user
  groupadd --gid $USER_GID $USER && \
  useradd -s /bin/bash --uid $USER_UID --gid $USER -m $USER --create-home && \
  usermod -a -G sudo $USER && \
  echo "$USER ALL = (ALL) NOPASSWD: ALL" >> /etc/sudoers && \
  # Clean up
  apt-get clean && \
  apt-get autoclean && \
  rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/* /var/cache/apt
