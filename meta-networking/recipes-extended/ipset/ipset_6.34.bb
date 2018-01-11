SUMMARY = "administration tool for IP sets"
DESCRIPTION = "ipset is used to set up, maintain and inspect so called IP sets in the Linux kernel. \
Depending on the type of the set, an IP set may store IP(v4/v6) addresses, (TCP/UDP) port numbers, \
IP and MAC address pairs, IP address and port number pairs"
HOMEPAGE = "http://ipset.netfilter.org/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"

SRC_URI = "http://ipset.netfilter.org/ipset-${PV}.tar.bz2"
SRC_URI[md5sum] = "51bd03f976a1501fd45e1d71a1e2e6bf"
SRC_URI[sha256sum] = "d70e831b670b7aa25dde81fd994d3a7ce0c0e801559a557105576df66cd8d680"

inherit autotools

DEPENDS = "libtool virtual/kernel"
PARALLEL_MAKE = ""
EXTRA_OECONF = "--with-kernel=${STAGING_INCDIR} \
              "

