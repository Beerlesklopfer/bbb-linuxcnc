SUMMARY = "linuxcnc can drive milling machines, lathes, 3D printers, laser cutters, plasma cutters, robot arms, hexapods, and more."
SECTION = "x11/application"
HOMEPAGE = "https://linuxcnc.org"
#LICENSE = "LGPL-3.0"
#LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""
PN   = "linuxcnc"
PV   = "2.9.2"
PKGV = "${PV}"

BB_STRICT_CHECKSUM = "0"
PREFERRED_VERSION_linuxcnc = "2.9.2"

#SRCBRANCH          = "master"
#SRCTAG             = "v2.9.2"
#SRC_URI            = "https://github.com/LinuxCNC/linuxcnc.git;branch=${SRCBRANCH};tag=${SRCTAG};protocol=https;"
#SRC_URI[sha256sum] = "7387a4bb00be6b2f246fc7e3f8dd39d10af1bab45d81f7f3cc4d2450b10ba966"

SRC_URI             = "https://github.com/LinuxCNC/linuxcnc/archive/refs/tags/v2.9.2.tar.gz"
SRC_URI[sha256sum]  = "56648e0a9a6fcd4ea7d5c00174a90177f8e39c2f10b130ceff8f0481f26bfaf7"

SYSTEMD_SERVICE_${PN} = "linuxcnc.service"

DEPENDS = "ncurses npth tcl boost libmodbus libusb libgpiod glib-2.0 glibc-locale gtk+ gtk+3 asciidoc qtbase"

inherit autotools core-image gettext

EXTRA_OECONF += "--host=$(uname -s)-linux-gnu --enable-toolnml --enable-build-documentation=html --with-realtime=uspace --with-libmodbus --with-libusb-1.0 --prefix=/usr --sysconfdir=/etc --localstatedir=/var"
EXTRA_AUTORECONF += ""

do_configure(){
   cd "${S}/src" 
   autoreconf --install 
   ./configure ${EXTRA_OECONF}
}

do_compile(){
    echo "(***********************************************)";
    export DEB_HOST_ARCH=$(uname -m)
    export DEB_HOST_ARCH_OS=$(uname -s)
    cd "${S}/src"
    oe_runmake
    echo "(***********************************************)";
}


do_install () {
   install -d "${D}/${bindir}"
   install -d "${D}/${libdir}"
   install -d "${D}/${includedir}"
   install -d "${D}/${datarootdir}"

   install -m 0775 "${B}/bin/*"     -t "${D}/${bindir}"
   install -m 0775 "${B}/lib/*"     -t "${D}/${libdir}"
   install -m 0664 "${B}/include/*" -t "${D}/${includedir}"
   install -m 0664 "${B}/share/*"   -t "${D}/${datarootdir}"
   echo "(*****   I N S T A L L    D O N E   *****)";

}

do_display_banner(){
    bb.plain("***********************************************");
    bb.plain("*                                             *");
    bb.plain("*  Example recipe created by bitbake-layers   *");
    bb.plain("*                                             *");
    bb.plain("***********************************************");}

addtask display_banner before do_build

do_populate_sdk(){
  :
}

do_package_write_deb(){
  :
}

do_package_write_ipk(){
  :
}

do_package_write_rpm(){
  :
}

BBCLASSEXTEND = "native nativesdk"


