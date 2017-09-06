SUMMARY = "An open source CPE implementation of MAP-E/MAP-T which can be run on Linux and Openwrt."

DESCRIPTION = "MAP is an open source CPE implementation of draft-ietf-softwire-map and draft-ietf-softwire-map-t. \
               It runs on Linux and Openwrt. \
               MAP is a mechanism for transporting IPv4 packets across an IPv6 network using IP translation (MAP-T) \
               or encapsulation (MAP-E), and a generic mechanism for mapping between IPv6 addresses and IPv4 addresses \
               and transport layer ports. It is defined in https://datatracker.ietf.org/doc/draft-ietf-softwire-map/ \
               and https://datatracker.ietf.org/doc/draft-ietf-softwire-map-t/ "

HOMEPAGE = "https://github.com/cernet/MAP"
LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://../readme;md5=444167a8769017f1c1c1438f2da79e40"

SRC_URI = "git://github.com/cernet/MAP"
SRCREV = "03d2baf2242ede7ce473039ac08026aa3c99f05b"

S="${WORKDIR}/git/utils"

do_compile() {
   oe_runmake -B -C ${S}
}

do_install() {
   install -d ${D}${bindir}
   install ivictl ${D}${bindir}
}

FILES_${PN} = "${bindir}/ivictl"
