SUMMARY = "Backported and Experimental Type Hints for Python 3.7+"
DESCRIPTION = "The typing_extensions module serves two related purposes:\
\
* Enable use of new type system features on older Python versions. For \
  example, typing.TypeGuard is new in Python 3.10, but typing_extensions \
  allows users on previous Python versions to use it too.\
* Enable experimentation with new type system PEPs before they are accepted \
  and added to the typing module."
HOMEPAGE = "https://github.com/python/typing_extensions"
BUGTRACKER = "https://github.com/python/typing_extensions/issues"
SECTIONS = "libs"
LICENSE = "PSF-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fcf6b249c2641540219a727f35d8d2c2"

# The name on PyPi is slightly different.
PYPI_PACKAGE = "typing_extensions"

SRC_URI[sha256sum] = "23478f88c37f27d76ac8aee6c905017a143b0b1b886c3c9f66bc2fd94f9f5783"

inherit pypi python_flit_core

UPSTREAM_CHECK_REGEX = "/typing-extensions/(?P<pver>(\d+[\.\-_]*)+)/"

BBCLASSEXTEND = "native nativesdk"
