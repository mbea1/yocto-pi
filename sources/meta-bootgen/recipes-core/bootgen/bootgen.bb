SUMMARY = "Xilinx Bootgen"
DESCRIPTION = "Bootgen is a tool provided by Xilinx for generating boot images for their FPGA and SoC devices."
SECTION = "utilities"

SRC_URI = "git://github.com/Xilinx/bootgen.git;protocol=https;tag=2019.2"

S = "${WORKDIR}/git"

do_compile() {
    oe_runmake
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/bootgen ${D}${bindir}
}
