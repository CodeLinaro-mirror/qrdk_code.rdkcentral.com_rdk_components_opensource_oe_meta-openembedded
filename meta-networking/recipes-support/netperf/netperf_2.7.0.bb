DESCRIPTION = "\
Netperf is a benchmark that can be used to measure the performance of many \
different types of networking. It provides tests for both unidirectional \
throughput, and end-to-end latency."
HOMEPAGE = "https://hewlettpackard.github.io/netperf/"
SECTION = "console/network"
LICENSE = "netperf"
LIC_FILES_CHKSUM = "file://COPYING;md5=a0ab17253e7a3f318da85382c7d5d5d6"

SRC_URI = "git://github.com/HewlettPackard/netperf.git;nobranch=1"

SRCREV = "f46c0319851d85e135e46289fa484b01705af73e"

S = "${WORKDIR}/git"

inherit autotools

do_configure_prepend () {
	#sockaddr sa_len member variable is applicable only for BSD system. Commenting it out.
	echo "Prepend has been called"
	sed -i 's/^\(AC_CHECK_SA_LEN.*\)/#\1/' ${S}/configure.ac
}

do_install () {
        install -d ${D}${bindir}
        install -m 0755 ${WORKDIR}/git/src/netperf ${D}${bindir}
}


