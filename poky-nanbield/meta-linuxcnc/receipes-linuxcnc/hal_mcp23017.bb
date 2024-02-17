SUMMARY = "linuxcnc can drive milling machines, lathes, 3D printers, laser cutters, plasma cutters, robot arms, hexapods, and more."
SECTION = "x11/application"
HOMEPAGE = "https://linuxcnc.org"
#LICENSE = "LGPL-3.0"
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""
PN   = "hal_mcp23017"
PV   = "2.9.2"
PKGV = "${PV}"

DEPENDS += " linuxcnc i2c-tools"

#SRCBRANCH          = "master"
#SRCTAG             = "v2.9.2"
#SRC_URI            = "https://github.com/thgerner/hal_mcp23017.git;branch=${SRCBRANCH};tag=${SRCTAG};protocol=https;"
SRC_URI            = "https://github.com/Beerlesklopfer/hal_mcp23017.git;branch=${SRCBRANCH};tag=${SRCTAG};protocol=https;"
SRC_URI[sha256sum] = "54e1ec749144413340f19dfe926356a4f2aea51df9f87ffee4e871e9c0a35794"

do_compile(){
    echo "(***********************************************)";
    export DEB_HOST_ARCH=$(uname -m)
    export DEB_HOST_ARCH_OS=$(uname -s)
    cd "${S}/src"
    oe_runmake
    echo "(***********************************************)";
}

