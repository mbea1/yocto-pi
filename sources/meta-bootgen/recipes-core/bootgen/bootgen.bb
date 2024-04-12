SUMMARY = "Xilinx Bootgen"
DESCRIPTION = "Generate boot images for Xilinx devices"
SECTION = "utilities"

SRC_URI = "git://github.com/Xilinx/bootgen.git;protocol=https;tag=2019.2"

S = "${WORKDIR}/git"

DEPENDS += "openssl"

CXXFLAGS += "-L${STAGING_LIBDIR} -L${STAGING_LIBDIR_NATIVE} -L${STAGING_BASELIBDIR} -L${STAGING_BASE_LIBDIR_NATIVE}"

do_compile() {
    oe_runmake \
        "CROSS_COMPILER=${TARGET_PREFIX}g++" \
        "LIBS=${STAGING_LIBDIR}/libssl.a ${STAGING_LIBDIR}/libcrypto.a -ldl -lpthread" \
        "INCLUDE_USER=-I${STAGING_INCDIR}/c++/13.2.0/aarch64-poky-linux -I${STAGING_INCDIR}/c++/13.2.0 -I${STAGING_INCDIR}"
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/bootgen ${D}${bindir}
}
