# This file is Confidential Information of CUJO LLC.
# Copyright (c) 2018-2019 CUJO LLC. All rights reserved.

SUMMARY = "CUJO lua coutil"
SECTION = "cujo/share/lua"
DEPENDS = "luavararg"
RDEPENDS_${PN} += "luavararg (>= 2.1.0)"
SRC_URI = "https://github.com/renatomaia/coutil/archive/v${PV}.tar.gz"
SRC_URI[md5sum] = "73f5118e025cf543b70e824ce311d63d"
SRC_URI[sha256sum] = "a765b628a43ab698a4fcb1817af250680fa3b3ecc9769a065da28ad000ece1e0"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=98ed66b5d87bb4152d51cba938287360"
S = "${WORKDIR}/coutil-${PV}"

LUA_LIB_DIR =  "${libdir}/lua/5.3"
LUA_SHARE_DIR = "${datadir}/lua/5.3"

do_install() {
	install -d ${D}${LUA_SHARE_DIR}
	install -d ${D}${LUA_SHARE_DIR}/coutil
	install -d ${D}${LUA_SHARE_DIR}/coutil/socket
	install -d ${D}${LUA_SHARE_DIR}/coutil/time
	install -m 0755 ${S}/lua/coutil/*.lua ${D}${LUA_SHARE_DIR}/coutil
	install -m 0755 ${S}/lua/coutil/socket/*.lua ${D}${LUA_SHARE_DIR}/coutil/socket
	install -m 0755 ${S}/lua/coutil/time/*.lua ${D}${LUA_SHARE_DIR}/coutil/time
}

FILES_${PN} += "${LUA_SHARE_DIR}/*"
