SUMMARY = "Xilinx Bootgen"
DESCRIPTION = "Generate boot images for Xilinx devices"
SECTION = "utilities"

SRC_URI = "git://github.com/Xilinx/bootgen.git;protocol=https;branch=master"
SRCREV = "2019.2"

S = "${WORKDIR}/git"

DEPENDS += "openssl"

CXXFLAGS += "--sysroot=${STAGING_DIR_TARGET}"

do_compile() {
    oe_runmake \
        "CROSS_COMPILER=${TARGET_PREFIX}g++"
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/bootgen ${D}${bindir}
}
