# This file is Confidential Information of CUJO LLC.
# Copyright (c) 2018-2019 CUJO LLC. All rights reserved.

SUMMARY = "CUJO Lua OOP debugging utilities classes"
SECTION = "cujo/share/lua"
DEPENDS = "lua"
RDEPENDS_${PN} += "lua (>= 5.3)"
SRC_URI = "git://github.com/renatomaia/loop-debugging.git"
SRCREV = "c5a6fef73d54084c7cf794ceedd5ab4bef083696"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f6390e5d18a581762454ab3d8f11dae2"
S = "${WORKDIR}/git"

LUA_LIB_DIR =  "${libdir}/lua/5.3"
LUA_SHARE_DIR = "${datadir}/lua/5.3"

do_install() {
	install -d ${D}${LUA_SHARE_DIR}
	install -d ${D}${LUA_SHARE_DIR}/loop
	install -d ${D}${LUA_SHARE_DIR}/loop/debug
	install -m 0755 ${S}/lua/loop/debug/*.lua ${D}${LUA_SHARE_DIR}/loop/debug
}

FILES_${PN} += "${LUA_SHARE_DIR}/*"
