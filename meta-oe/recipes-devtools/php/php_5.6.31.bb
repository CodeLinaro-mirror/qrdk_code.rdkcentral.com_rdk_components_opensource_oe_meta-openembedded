require php.inc

LIC_FILES_CHKSUM = "file://LICENSE;md5=b602636d46a61c0ac0432bbf5c078fe4"

SRC_URI += "file://acinclude-xml2-config.patch \
            file://0001-php-don-t-use-broken-wrapper-for-mkdir.patch \
            file://0001-acinclude-use-pkgconfig-for-libxml2-config.patch \
"
SRC_URI_append_pn-php += "file://iconv.patch \
            file://imap-fix-autofoo.patch \
            file://pear-makefile.patch \
            file://phar-makefile.patch \
            file://php_exec_native.patch \
            file://fix-fpm-cross-compile.patch \
            file://php-fpm.conf \
            file://php-fpm-apache.conf \
            file://950-Fix-dl-cross-compiling-issue.patch \
"

SRC_URI[md5sum] = "40d4939e116c46cec0a486e2fab7c8b0"
SRC_URI[sha256sum] = "6687ed2f09150b2ad6b3780ff89715891f83a9c331e69c90241ef699dec4c43f"
