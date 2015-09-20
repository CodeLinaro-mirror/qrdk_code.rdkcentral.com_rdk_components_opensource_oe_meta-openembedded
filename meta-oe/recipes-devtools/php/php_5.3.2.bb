require php.inc

LIC_FILES_CHKSUM = "file://LICENSE;md5=120722ac328447294083a64f651c3ddc"

SRC_URI[md5sum] = "46f500816125202c48a458d0133254a4"
SRC_URI[sha256sum] = "9a380a574adcb3a9abe3226e7c3a9bae619e8a1b90842ec2a7edf0ad92afdeda"

SRC_URI += "file://acinclude-xml2-config.patch \
            file://0001-php-don-t-use-broken-wrapper-for-mkdir.patch \
            file://new-atuoconf-support.patch \
            file://0001-acinclude-use-pkgconfig-for-libxml2-config.patch \
            file://dom.patch \
            file://php-5.3.2-nolibdl-compile-error.patch \
"

SRC_URI_append_pn-php += "file://iconv.patch \
            file://imap-fix-autofoo.patch \
            file://pear-makefile.patch \
            file://phar-makefile.patch \
            file://php_exec_native.patch \
            file://php-fpm.conf \
            file://php-fpm-apache.conf \
"
PACKAGECONFIG = ""
