DESCRIPTION = "A server-side, HTML-embedded scripting language. This package provides the CGI."
HOMEPAGE = "http://www.php.net"
LICENSE = "PHP-3.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=120722ac328447294083a64f651c3ddc"

INC_PR = "r5"

# The new PHP downloads server groups PHP releases by major version so find
# the major version of the PHP recipe.
PHP_MAJVER = "${@d.getVar('PV',1).split('.')[0]}"
SRC_URI = "http://museum.php.net/php${PHP_MAJVER}/php-${PV}.tar.bz2"

SRC_URI[md5sum] = "46f500816125202c48a458d0133254a4"
SRC_URI[sha256sum] = "9a380a574adcb3a9abe3226e7c3a9bae619e8a1b90842ec2a7edf0ad92afdeda"

SRC_URI += "file://acinclude-xml2-config.patch \
            file://0001-php-don-t-use-broken-wrapper-for-mkdir.patch \
"

S = "${WORKDIR}/php-${PV}"

inherit autotools

do_configure () {
   ./configure --build=x86_64-linux --host=i586-rdk-linux --target=i586-rdk-linux \
               --enable-fast-install \
               --enable-shared --disable-static --with-pic \
               --without-iconv \
               --without-mysql \
               --without-pear \
               --prefix=${D} \
               --disable-phar \
               --enable-sockets \
               --enable-session \
               --with-zlib-dir=${STAGING_LIBDIR}/.. \
               --with-openssl-dir=${STAGING_LIBDIR} \
               --disable-libxml \
               --disable-dom \
               --disable-xml \
               --disable-simplexml \
               --disable-xmlreader \
               --disable-xmlwriter \
	       --with-config-file-path=${sysconfdir} \
}

do_compile_prepend() {
    rm -fr ${S}/libtool
    ln -s  ${STAGING_BINDIR_CROSS}/i586-rdk-linux-libtool ${S}/libtool
}

do_compile() {
        oe_runmake "LIBTOOL=${STAGING_BINDIR_CROSS}/i586-rdk-linux-libtool"
}

do_install_append() {
   install -m 0777 ${D}/bin/* ${STAGING_BINDIR_NATIVE}
   install -m 0777 ${D}/bin/* ${STAGING_BINDIR}
}

FILES_${PN} += "/bin/*"
FILES_${PN} += "/man/*"
FILES_${PN} += "/lib/*"
FILES_${PN} += "/include/php/*"
