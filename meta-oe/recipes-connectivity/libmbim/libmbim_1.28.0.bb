SUMMARY = "libmbim is library for talking to WWAN devices by MBIM protocol"
DESCRIPTION = "libmbim is a glib-based library for talking to WWAN modems and devices which speak the Mobile Interface Broadband Model (MBIM) protocol"
HOMEPAGE = "http://www.freedesktop.org/wiki/Software/libmbim/"

inherit meson
LICENSE = "GPLv2 & LGPLv2.1"
LIC_FILES_CHKSUM = "file://${S}/LICENSES/GPL-2.0-or-later.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"


S = "${WORKDIR}/libmbim-${SRCREV}/"

SRCREV = "357369cc6b014a9996ffe46772428a478c1ee7bd"
SRC_URI = "https://gitlab.freedesktop.org/mobile-broadband/libmbim/-/archive/${SRCREV}/libmbim-${SRCREV}.tar.bz2"
SRC_URI[sha256sum] = "aadc19893d127a3edf0a0d2050581d6c5c721fc16227f33d6939a705d558a56a"

#DEPENDS = "glib-2.0 glib-2.0-native libgudev"
DEPENDS=" \
  libxml2 \
  glib-2.0 \
  glib-2.0-native \
  gtk-doc \
  intltool-native \
"

PACKAGECONFIG[help2man] = "-Dman=true,-Dman=false,help2man"
PACKAGECONFIG[gobject-introspection-1.0] = "-Dintrospection=true,-Dintrospection=false,gobject-introspection-1.0"

EXTRA_OEMESON = " \
    -Dintrospection=false \
"