# $Id: GNUmakefile,v 1.15 2004-11-02 14:33:08 rzr Exp $
# * @author www.Philippe.COVAL.free.fr
# * Copyright and License : http://rzr.online.fr/license.htm
#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
ENV ?= j2me
RT_LIST?=midp1_0 midp1_0-nokia midp2_0 imode exen
RT ?=midp1_0
#RT ?=midp1_0-nokia
#RT ?=midp2_0

JAVA_HOME?=/usr/lib/j2se/1.4/
SW_ARC?=${HOME}/mnt/software/
# commands
UNZIP ?= unzip -q
CONVERTER ?=java -cp ${SW_DIR}midp4palm1.0/Converter/Converter.jar \
	com.sun.midp.palm.database.MakeMIDPApp  
FS=\\/
#export 
INFUSIO_PP_LIN ?=\/home\/${USER}\/
INFUSIO_PP_WIN ?=y:
export INFUSIO_PP_WIN INFUSIO_PP_LIN

#
SW_DIR ?= /opt/
SDKV_LIST?=21 20 00 exen
SDKV ?=21
#SDKV ?=20
#SDKV=00
CONFIG=${RT}
SDK_PATH ?=${SW_DIRW}WTK104 ${SW_DIR}WTK2.1 ${SW_DIR}midp2.0fcs
DATE ?=$(shell date +%Y%m%d)
# regnerated everytime
#TMP ?=$(shell mktemp)
TMP=/tmp/tmp-${USER}-${NAME}-${RT}-${SDKV}-${DATE}-tmp
ID ?=$(shell date +%Y%m%d%s)


VERSION_MAJ=0
VERSION_MIN=27
VERSION_REV=3

VERSION_DOT ?= ${VERSION_MAJ}.${VERSION_MIN}.${VERSION_REV}
VERSION_CHAR ?= ${VERSION_MAJ}_${VERSION_MIN}_${VERSION_REV}

VERSION ?= ${VERSION_DOT}
#VERSION ?=0.0.$(shell date +%Y%m%d%H)

# DEFINES+=-DDEVEL -DPRIVATE
# DEFINES+= -DPRIVATE
# -NOINLINE
MKDIR ?= @mkdir -p
#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
# PROJECTlication Specific
#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
SUFFIX_MIDLET ?=MIDlet
#SUFFIX_MIDLET=
PROJECT ?= Diet3D
PROJECT_DIST ?= diet3d
PROJECT_URL ?= "http://rzr.online.fr/java.htm"
PROJECT ?= ${PROJECT}
DEFINES+=-DNOINLINE -DVERSION="${VERSION}"

PWD:=$(shell pwd)/
DESTDIR=jclasses-${CONFIG}/
SRC_DIR:=src-${RT}/
SRC_IN_DIR:=${PWD}sources/
#DESTDIR=${SRC_DIR}jclasses-${CONFIG}/



WEBDIR ?=${HOME}/mnt/public_html/docs/java/${PROJECT_DIST}/
#URL_BASE?=file://
#URL_BASE?=http://rzr.online.fr/docs/java/jclasses/
#URL_BASE?=http://localhost/~${USER}/${PROJECT}/
URL_BASE?=http://localhost/~rzr/${PROJECT}/

URL?=${URL_BASE}${DESTDIR}${PROJECT}.jad
#URL=http://rzr.online.fr/docs/java/jclasses/

URL_WML?=http://localhost/~${USER}/wap.wml
#URL_PUB=http://nrv.homelinux.org/~${USER}/${PROJECT}/${DESTDIR}
URL_PUB?=


ifeq ($(RT),midp1_0) 
DEFINES+=-DMIDP_1_0
MIDPV="MIDP-1.0"
ALL+=${DESTDIR}${PROJECT}.jad ${DESTDIR}${PROJECT}.wml ${DESTDIR}${PROJECT}.html
JAVAC?=javac -target 1.2
# microemu is 1.1 =45.3 # 1.1=45.3 1.2=46 1.3=47
# micro emu @ moz+linux : 1.2+  
# micro emi @ ie+win : -target 1.1
endif

ifeq ($(RT),midp2_0) 
DEFINES+=-DMIDP_2_0 
MIDPV="MIDP-2.0"
ALL+=${DESTDIR}${PROJECT}.jad ${DESTDIR}${PROJECT}.wml ${DESTDIR}${PROJECT}.jar
endif

ifeq ($(RT),midp1_0-nokia) 
DEFINES+= -DNOKIA
MIDPV="MIDP-1.0"
EXT=${SW_DIR}Nokia/Devices/Nokia_Series_40_MIDP_Concept_SDK_Beta_0_3/lib/classes.zip
ALL+=${DESTDIR}${PROJECT}.jad ${DESTDIR}${PROJECT}.wml
endif


ifeq ($(RT),imode) 
DEFINES+=-DNTTDOCOMO
MIDPV="MIDP-1.0"
API=${HOME}${SW_DIR}iDK/lib/classes.zip
EXT=${HOME}${SW_DIR}iDK/lib/doja_classes.zip
FILES=${PROJECT} ${PROJECT}Canvas ${PROJECT}Imode
ALL+=${DESTDIR}${PROJECT}.jam 
endif


ifeq ($(RT),midp1_0-siemens) 
DEFINES+=-DMIDP_1_0 -DSIEMENS
MIDPV="MIDP-1.0"
EXT=${HOME}/lib/java/seimens-api.jar
ALL+=${DESTDIR}${PROJECT}.jad
endif

ifeq ($(RT),j2se) 
SDKV=00
DEFINES+=-DAWT -DJ2SE
API=""
OBJ_DIR=./jclasses-${RT}/
DESTDIR=${OBJ_DIR}
CLASSPATH=${DESTDIR}:.
FILES=${PROJECT} ${PROJECT}Canvas ${PROJECT}Applet
OBJS=$(FILES:=.class) ${PROJECT}CommandLine.class
ALL=${OBJS}
JAVAC= javac -target "1.1" -g:none
DATA?=applet.htm
DATA_DIR=${DESTDIR}
PREVERIFY=echo
endif


EXEN_TARGET?=le_default.exn
ifeq ($(RT),exen) 
EXENC=cd ${SDK_DIR}bin && ${SDK_DIR}bin/exenc
DEFINES+=-DEXEN
MIDPV=exen
SDKV=exen
SDK=InFusioSDK
SDK_DIR=${HOME}/mnt/${SDK}/
API=${SDK_DIR}etc/lib/ExEnV2.jar
#OBJ_DIR=./jclasses-${RT}/
OBJ_DIR=${SRC_DIR}
#SRC_DIR_ABS=./src-${RT}/
FILES=${PROJECT} ${PROJECT}Canvas
#SRCS?=${FILES:=.java} 
DATA=${PROJECT}.xml
DATA_DIR=${SRC_DIR_ABS}
ALL=${DIR_PATH} ${OBJS} all-exen
DESTDIR=jclasses-${RT}/
SRC_DIR=src-${RT}/
OBJ_DIR=${SRC_DIR}
#/jclasses-${RT}/

#SRCS_IN?=${FILES:=.java.in}
#OBJS?=${FILES:=.class}
#PREVERIFY=${SW_DIR}midp2.0fcs/bin/preverify
PREVERIFY=echo ${SW_DIR}midp2.0fcs/bin/preverify
JAR=echo jar
JAVAC=javac -g:none -target 1.1
JAVACP=javacp
#SRC_DIR_ABS ?=
#EXEN_RUN ?=cd ${SDK_DIR} && nice wine --
EXEN_RUN=nice wine --
WMTRANS=${EXEN_RUN} ${SDK_DIR}bin/vmtools/VMTrans.exe
WMTRANS_FLAGS= -gr -v -gp -g4 -dt -vt
#WMTRANS?=cd ${SDK_DIR}bin/vmtools/ && vmtrans
#WMTRANS?=cd ${SDK_DIR}bin/vmtools/ && vmtrans
# -dc "/home/rzr/src/${PROJECT}/src-exen/classes" -do "/home/rzr/src/${PROJECT}/src-exen/pvc" -gr -v -gp -g4 -dt -vt "resource"

SDK_DIR_WIN= Y:\\home\\${USER}\\mnt\\${SDK}\\
#EXEN_ROM ?= ${SDK_DIR_WIN}etc\\exenrom\\ExEnV2\\lexen.rom
EXEN_ROM=${SDK_DIR}etc/exenrom/ExEnV2/lexen.rom
#PVC2ROM ?=wine -- ${SDK_DIR}bin/vmtools/exenrom/exenrom.exe
#PVC2ROM ?=wine -- ${SDK_DIR}bin/vmtools/exenrom/exenrom.exe
PVC2ROM=wine -- ${SDK_DIR}bin/vmtools/exenrom/exenrom

VM_EXEN=${EXEN_RUN} ${SDK_DIR}bin/simulator_v2/generic/Color/gensimu.exe 
EXN2CTC=wine -- ${HOME}/mnt/bin-WIN32/EXN2CTC.exe
CLASSPATH=${OBJ_DIR}:${API}
endif#endif

#FILES= MathFixed ${PROJECT}Render ${PROJECT}Canvas ${PROJECT}${SUFFIX_MIDLET}
FILES ?= ${PROJECT} ${PROJECT}Canvas ${PROJECT}${SUFFIX_MIDLET}
#FILES=  ${PROJECT}Canvas ${PROJECT}${SUFFIX_MIDLET}


##
#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
# Env Specific
#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

ifeq ($(API),"")
JAVACFLAGS=-d ${OBJ_DIR} -classpath ${CLASSPATH}
else
JAVACFLAGS=-bootclasspath ${API} -classpath ${CLASSPATH} -d ${OBJ_DIR}
endif

ifeq ($(SDKV),10) 
SDK:=WTK104
SDK_DIR=${SW_DIR}${SDK}/
API ?=${SDK_DIR}lib/midpapi.zip
CLASSPATH=${API}:${EXT}:${OBJ_DIR}
VM=${SDK_DIR}bin/emulator
endif

ifeq ($(SDKV),20)
SDK:=midp2.0fcs
SDK_DIR:=${SW_DIR}${SDK}/
MIDP_HOME=${SDK_DIR}
export MIDP_HOME
API ?=${SDK_DIR}classes/
VM=${SDK_DIR}bin/midp
CLASSPATH=${API}:${EXT}:${OBJ_DIR}
endif

ifeq ($(SDKV),21)
SDK:=WTK2.1
SDK_DIR:=${SW_DIR}${SDK}/
API ?=${SDK_DIR}lib/cldcapi10.zip
API_MIDP ?=${SDK_DIR}lib/midpapi20.zip
CLASSPATH=${API}:${API_MIDP}:${OBJ_DIR}:${EXT}
VM=${SDK_DIR}bin/emulator
endif


# 
# Default values
#

DESTDIR_ABS ?=${PWD}${DESTDIR}
SRC_DIR_ABS ?=${PWD}${SRC_DIR}
TMP_DIR ?=/tmp/${SRC_DIR_ABS}/tmp/
OBJ_DIR ?=${TMP_DIR}${DESTDIR}

#SRCS=$(wildcard *.java)
#SRCS=
#FILES=$(SRCS:.java=) 
JAVAC ?= javac 
JAVA ?=java
APPLETVIEWER ?= appletviewer
PREVERIFY ?= preverify
JAR ?= jar

#DESTDIR ?=./
#DESTDIR = ../jclasses-${ENV}/
DIRPATH=${SRC_DIR_ABS} ${OBJ_DIR} ${DISTDIR_ABS} ${DESTDIR} ${SRC_IN_DIR}
vpath:=${DIRPATH}
VPATH:=${DIRPATH}
PATH:=${JAVA_HOME}/bin/:${PATH}:${SDK_DIR}bin/

SRCS ?= $(FILES:=.java)
SRCS_IN ?= $(FILES:=.java.in)
OBJS ?= $(FILES:=.class)
CLASSPATH ?= ${OBJ_DIR}


#export RT SDKV MIDPV SDK SDK_DIR

#DEFINES+="-DHAVE_AWT"
export CLASSPATH
#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
# Rules
#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
default: all

all compile build: pre ${ALL} post
	@echo "#- $@"
#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~# Application rules
#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
help: help-${PROJECT} help-${ENV}
	@echo "#"

help-${PROJECT}: 
	@echo "#"
	@echo "# ${PROJECT} java / ${ENV} demo (3d engine on fixed points)"
	@echo "# Contact: http://rzr.online.fr/java.htm"
	@echo "#"


help-${ENV}:
	@echo "# Type following targets for compiling or running :"
	@echo "#"
	@echo "# make run # 3d demo (start ${ENV} emulator)"
	@echo "# make applet # 3d demo  (start j2sk appletviewer)"
	@echo "# make all # compile sources (all)"
	@echo "# make compile # compile sources (step)"
	@echo "# make clean # wipe .class out"
	@echo "#"
	@echo "# Options are : make RT=[${RT}] SDKV=[${SDKV}]"
	@echo "# RT { ${RT_LIST} }"
	@echo "# SDK { ${SDKV_LIST} }"
# 	@echo "make application # 3d demo (lunch it in jvm)"

#mesh:
#	../diet3d-tools/diet3dconvert --stdio --langjava < ../../diet3d-rzr/ext-data/simpson-front.asc >| ../diet3d-java/Mesh.java

# sed -e "s/\/\/\(.\*@use_awt\)/\1/g" < ${PROJECT}Render.java
dist: clean-bak diet3d-java.zip
	cp ../diet3d-java.zip ${WEBDIR}
#	-cp ${OBJ_DIR}*.java ${SRC_DIR_ABS}


${PROJECT}Canvas.java.in: ${PROJECT}.java.in

${PROJECT}.java.in: MathFixed.java.in Raster.java.in

${PROJECT}Applet: MathFixed.class ${PROJECT}.class ${PROJECT}Applet.class

${PROJECT}.java: ${PROJECT}.java.in Raster.java.in

${PROJECT}Raster.java: ${PROJECT}Raster.java.in 

${PROJECT}CommandLine.class: ${PROJECT}CommandLine.java
	${JAVAC} -classpath /opt/jars/gif89.jar:${DESTDIR} -d ${DESTDIR}  $<


gif anim: ${PROJECT}Applet ${PROJECT}.gif
	echo display $<

${PROJECT}.gif: ${PROJECT}CommandLine.class
	${JAVA} -classpath  /opt/jars/gif89.jar:${DESTDIR} ${<F:.class=} $@

#${PROJECT}Render.java: ${SRC_DIR_ABS}${PROJECT}Render.java

#${PROJECT}Canvas.java: ${SRC_DIR_ABS}${PROJECT}Canvas.java

#${PROJECT}MIDlet.java: ${SRC_DIR_ABS}${PROJECT}MIDlet.java

#resource.java: ${SRC_DIR_ABS}resource.java

#${DEST_DIR}%.java: ${SRC_DIR_ABS}%.java

# MIDlet-Icon: ${PROJECT}.png

#${PROJECT}RenderAwt.java: ${PROJECT}Render.java
#	echo "//DO NOT EDIT THIS FILE IT IS GENERATED FROM $^ " > $@
#	sed -e "s/\s*\/\/\(.*@use_awt\)/\1/g" < $^ | \
#	sed -e "s/\(.*@use_${ENV}\)/\/\/\1/g"  >> $@


#${PROJECT}Render.class: ${PROJECT}Render.java
#	${JAVAC} -d ${DESTDIR} $^ 



#	touch $@

#${SRCS}: GNUmakefile

exec-micro:
	${MAKE} RT=midp1_0 exec-memu

exec-memu: ${DESTDIR}${PROJECT}.html  ${DESTDIR}../lib/me-applet.jar modes
	echo "$@ : $<"
	ls ${DESTDIR}
	-${MAKE} browse URL="${URL_BASE}$<"
	-${APPLETVIEWER} ${URL_BASE}$<

#	appletviewer  ${PWD}$<

${DESTDIR}../lib/me-applet.jar:
	${MKDIR} ${@D}
	cp ${WEBDIR}lib/me-applet.jar $@


browse:
	${MAKE} browse-arg "ARG=${URL}"

browse-arg:
	 lynx -dump -head ${ARG}
	 lynx -dump -source ${ARG}
	 lynx -dump ${ARG}

xbrowse:
	lynx -dump -head ${URL}
	mozilla ${URL}

#TODO	#xmllint
#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
# J2ME Section
#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


%.class:%.java
	${MKDIR} ${OBJ_DIR}
	${JAVAC} ${JAVACFLAGS} ${SRC_DIR_ABS}${^F}

%.java: %.java.in ${SRCS_IN}
	${MKDIR} ${SRC_DIR_ABS}
	cpp -undef -fno-show-column ${DEFINES} -C -P -I. -I ${SRC_IN_DIR} $< \
> ${TMP}
	@mv  ${TMP} ${SRC_DIR_ABS}$@
#	@echo -e "\n ### !!! MAKE MAY FAILS, just restart (vpath bug) ### \n"
#	@ls -l ${SRC_DIR_ABS}$@

#	sed -e "s/\s*\/\/@cpp \(.*\)/\1/g" < $< | \

%.java %.MF %.in: GNUmakefile

jar ${PROJECT}.jar: ${DESTDIR} GNUmakefile ${DESTDIR}${PROJECT}.jar 

${SRC_DIR_ABS}MANIFEST.MF: ${SRC_IN_DIR}MANIFEST.MF.in
	@echo "#+ $@"
	${MKDIR}  ${SRC_DIR_ABS}
	cat $< | \
	sed -e "s/\(MicroEdition-Profile: \)MIDP-[0-9]*.[0-9]*/\1${MIDPV}/g" |\
	sed -e "s/\(MIDlet-Version: \)[0-9]*.[0-9]*/\1${VERSION_DOT}/g" \
	> $@
	@echo "#- $@"
#	s/\(MIDlet-Version:\) .*/\1 ${VERSION}/g


# MIDlet-Icon: /JBenchmark2/JBenchmark.png

default-MANIFEST.MF:
	@echo "MIDlet-1: ${PROJECT}, ${PROJECT}.png, ${PROJECT}MIDlet"
	@echo "MIDlet-Name: ${PROJECT}"
	@echo "MIDlet-Description: please describe"
	@echo "MIDlet-Vendor: ${USER}@${HOSTNAME}"
	@echo "MIDlet-Info-URL: ${URL} "
	@echo "MicroEdition-Configuration: CLDC-1.0"
	@echo "MicroEdition-Profile: MIDP-1.0"
	@echo "MIDlet-Version: ${VERSION_DOT}"



 #${PROJECT}MIDlet$$Tick.class ${PROJECT}Render.class 
${DESTDIR}${PROJECT}.jar:${SRC_DIR_ABS}MANIFEST.MF ${OBJS} ${DESTDIR}
	@echo "#+ $@"
	cd ${OBJ_DIR} && \
	${PREVERIFY} -classpath ${CLASSPATH} -d . .  && \
	${JAR} cvfm ${DESTDIR_ABS}${PROJECT}.jar ${SRC_DIR_ABS}MANIFEST.MF . 
	file ${DESTDIR}${PROJECT}.jar
	-${CLEAN} ${DESTDIR}${PROJECT}.jad
	@echo "-$(^F) $(^F:.class=)"
	@echo "#- $@"

jar-size: ${DESTDIR}${PROJECT}.jar
	@stat $^ | grep "Size:" | sed -e "s/ *Size: \([0-9]*\).*/\1/g" | head -1
SIZE:=` \
 stat ${DESTDIR}${PROJECT}.jar \
 | grep "Size:" | sed -e "s/ *Size: \([0-9]*\).*/\1/g" | head -1 \
 `

size:
	@echo "$^ Size = ${SIZE}"

check: ${DESTDIR}${PROJECT}.jad ${DESTDIR}${PROJECT}.jar
	@echo "#+ $@"
	@ls -l ${DESTDIR}${PROJECT}.jar
	@grep Size: ${DESTDIR}${PROJECT}.jad
	@echo "#- $@"

jad: ${DESTDIR}${PROJECT}.jad

jad-rm:
	@-${CLEAN} ${DESTDIR}${PROJECT}.jad
	echo "#- $@"

jad-re: jad-rm jad check

jad-all:	
	${MAKE} RT=midp1_0 jad-re
	${MAKE} RT=midp2_0 jad-re
	${MAKE} RT=midp1_0-nokia jad-re

size-bug:
	stat ${DESTDIR}${PROJECT}.jar | grep "Size:" \
	 | sed -e "s/ *Size: \([0-9]*\).*/\1/g"
	cat $< | grep "MIDlet-Jar-Size:" \
	 | sed -e "s/MIDlet-Jar-Size: \([0-9]*\)\s*/\1/g"

# TODO: size ?
${DESTDIR}${PROJECT}.jad: ${SRC_DIR_ABS}MANIFEST.MF ${DESTDIR}${PROJECT}.jar
	@echo "#+ $@ ${SIZE}"
	cat $< > $@
	echo "MIDlet-Jar-URL: ${PROJECT}.jar" >> $@
	echo "MIDlet-Jar-Size: ${SIZE}">> $@
	echo "" >> $@
	sed -e "s/MIDlet-Jar-Size: \([0-9]*\)/MIDlet-Jar-Size: \1/g" < $@
	@echo "#- $@"
# 	echo "MIDlet-Version: ${VERSION_DOT}">> $@


${DESTDIR}${PROJECT}.jam: ${DESTDIR}${PROJECT}.jar ${SRC_DIR_ABS}MANIFEST.MF GNUmakefile
	stat ${DESTDIR}${PROJECT}.jar | grep "Size:" \
	 | sed -e "s/ *Size: \([0-9]*\).*/\1/g"
	cat $@ | grep "MIDlet-Jar-Size:" \
	 | sed -e "s/MIDlet-Jar-Size: \([0-9]*\)\s*/\1/g"
	@echo "AppName = ${PROJECT}" > $@
	@echo "ConfigurationVer = CLDC-1.0" >>$@
	@echo "ProfilVer = DoJa-1.5oe" >>$@
	@echo "AppClass = ${PROJECT}Imode" >>$@
	@echo "PackageURL = ${PROJECT}.jar" >> $@
	@echo "AppSize = ${SIZE}">> $@
	@echo "LastModified = `date -R -u`" >> $@
	@echo "" >> $@
	@cat $@
	@echo "#- $@"
#	cat ${SRC_DIR_ABS}${PROJECT}.jam > $@
#	#sed -e "s/MIDlet-Jar-Size: \([0-9]*\)/MIDlet-Jar-Size: \1/g" < $@
#  Sun, 20 Jun 2004 06:17:48 = good
# dim avr 11 12:34:33 CEST 2004 = bad
wml: ${DESTDIR}${PROJECT}.wml

${DESTDIR}${PROJECT}.wml: ${DESTDIR}${PROJECT}.jad
	@echo "<?xml version=1.0?>\n\
<!DOCTYPE wml PUBLIC \"-//WAPFORUM//DTD WML 1.1//EN\"\n\
  \"http://www.wapforum.org/DTD/wml1.1.xml\">\n\
<wml>\n\
<card>\n\
<p>\n\
<a href=\"${URL_PUB}${PROJECT}.jad\">${PROJECT}.jad</a>\n\
</p>\n\
</card>\n\
</wml>\
" > $@
	@echo "#- $@"

applethtml: ${DESTDIR}${PROJECT}Applet.html

${DESTDIR}${PROJECT}Applet.html: ${PROJECT}Applet.class
	@echo "<html>" > $@
	@echo "<applet width=200 height=200" >> $@
	@echo "code=${<F:.class=}" >> $@
	@echo "></applet>" >> $@
	@echo "</html>" >> $@
	@echo "#- $@"

${DESTDIR}${PROJECT}.html: ${PROJECT}.jar
	@echo "<html>" > $@
	@echo "<H1>${PROJECT} Applet @" >> $@
	@echo "<a href=${PROJECT_URL}>${PROJECT_URL}</a>" >> $@
	@echo "</H1>" >> $@
	@echo "<applet code=\"com.barteo.emulator.applet.Main\"" >> $@
	@echo " width=170 height=445 " >> $@
	@echo " archive=\"../lib/me-applet.jar,${<F}\" " >> $@
	@echo ">">> ${DESTDIR}${PROJECT}.html >> $@
	@echo "<param name=midlet value=${PROJECT}MIDlet>" >> $@
	@echo "</applet><hr><pre>">> $@
	${MAKE} info-user >> $@
	@echo "</html>" >> $@
	@echo "#- $@"

palmos pda prc: 
	${MAKE} RT=midp1_0 ${PROJECT}.prc
	${MAKE} RT=midp2_0 ${PROJECT}.prc
pro-all: 
	${MAKE} RT=midp1_0 pro
	${MAKE} RT=midp2_0 pro
	${MAKE} RT=midp1_0-nokia pro

${PROJECT}.prc: ${DESTDIR} ${DESTDIR}${PROJECT}.jad  ${DESTDIR}${PROJECT}.jar
	${CONVERTER} -type Data -jad ${DESTDIR}${PROJECT}.jad ${DESTDIR}${PROJECT}.jar

jar: ${OBJS} ${OBJ_DIR} ${DESTDIR_ABS} ${DESTDIR}${PROJECT}.jar
#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
# hany rules for testing deploy etc
#
exec exec: modes ${DESTDIR} ${DESTDIR}${PROJECT}.wml url exec-${RT}

test test-all: clean-all compile-all modes exec-all clean-all

test-ri:
	${MAKE} RT=midp1_0 rebuild exec-ri

test-nokia n nokia midp1_0-nokia: 
	${MAKE} RT=midp1_0-nokia rebuild exec

test-midp1_0 1 10 midp1_0:
	${MAKE} RT=midp1_0 rebuild exec

test-midp2_0 20 midp2_0:
	${MAKE} RT=midp2_0 rebuild exec

j2se:
	${MAKE} RT=j2se SDKV=0 rebuild exec

build-all compile-all: 
	${MAKE} RT=midp1_0 
	${MAKE} RT=midp2_0
	${MAKE} RT=midp1_0-nokia
	${MAKE} RT=j2se SDKV=00
	${MAKE} RT=midp1_0-nokia 
	${MAKE} RT=imode
	${MAKE} RT=exen

all-post compile-post:
	${MAKE} RT=midp1_0 pro prc 
	${MAKE} RT=midp2_0 pro prc 
	${MAKE} RT=midp1_0-nokia pro

# uninstall 


#jar ${DESTDIR}${PROJECT}.jar ${DESTDIR}${PROJECT}.jad ${DATA} post
#dir ${ALL}  
# or post-${RT}

srcs: ${SRCS}
	@ls ${SRC_DIR_ABS}

dir:${DIRPATH}

${DIRPATH}:
	${MKDIR} $@

compile-force:
	@echo "### !!! this workaroud the vpath bug"
	-${MAKE} compile
	-${MAKE} compile
	-${MAKE} compile
	-${MAKE} compile
	-${MAKE} compile
	-${MAKE} compile
	 ${MAKE} compile

srcin: ${SRCS_IN} 


install-data: ${DATA}
	echo "### debug here : $^"
${DATA}: ${OBJS}
	cp ${SRC_IN_DIR}$(@F) ${DATA_DIR}





demo: 
	${MAKE} RT=midp2_0 exec-ri-url



exec-application: ${PROJECT}Applet
	cd ${DESTDIR} && \
	${JAVA} $^

exec-j2se exec-applet: ${DESTDIR}applet.htm 
	-${APPLETVIEWER} $<


${DESTDIR}applet.htm post-j2se: ${PROJECT}Applet
	cp ${SRC_IN_DIR}applet.htm ${DESTDIR}



names:
	-mv readme README
	-mv authors AUTHORS
	-mv copying COPYING

info infos: info-proj
	@echo "# default settings are : "
	@echo "# SDK=${SDK}"
	@echo "# SDK_DIR=${SDK_DIR}"
	@echo "# CLASSPATH=${CLASSPATH}"
	@echo "# PATH=${PATH}"
	@echo "# DESTDIR=${DESTDIR}"
	@echo "# DESTDIR_ABS=${DESTDIR_ABS}"
	@echo "# VPATH=${VPATH}"

info-proj:
	@echo "# PROJECT=${PROJECT}"
	@echo "# ALL=${ALL}"
	@echo "# OBJS=${OBJS}"


cc-wildcards:
	${MKDIR} ${DESTDIR}	
	${JAVAC} ${JAVACFLAGS} *.java

pre: ${SDK_DIR} dir
	@echo "- $@"

post: modes 

force:
	echo "forced"


rebuild: clean-all all

rebuild-all: clean-all compile-all 

reinstall: rebuild-all install

imode all-imode: ${DESTDIR} ${OBJS} jar ${DESTDIR}${PROJECT}.jar ${DESTDIR}${PROJECT}.jam ${DATA}


log.txt: clean default clean
	date > $@
	date >> $@

#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
# Deploy

release: clean-all compile-all  compile-post exec-all install

install: modes install-classes arch

install-classes install-dist dist-install:
	ls ${WEBDIR}
	-${CLEAN} -rf ${WEBDIR}${DESTDIR}
	cp -rf ${DESTDIR} ${WEBDIR}
	cp -rf ./jclasses-* ${WEBDIR}
	ls -l ${WEBDIR}${DESTDIR}

install-post:
	@echo "MIDlet-Jar-URL: Diet3D.jar"


TMP_DIR=${HOME}/tmp/${PROJECT}/${DATE}/${PROJECT}/
install-src:  AUTHORS README COPYING src-midp1_0 jclasses-midp1_0 
	-mkdir -p ${TMP_DIR}
	cp -rf $^ ${TMP_DIR}
	ls -lR ${TMP_DIR}
	cd ${TMP_DIR}.. && zip -r9 ${PROJECT_DIST}-src.zip ${PROJECT}
	ls -lR ${TMP_DIR}../${PROJECT_DIST}-src.zip

CLEAN=rm -rf

clean-bak:
	-@${CLEAN} *~ "#*" "#*.*" \#* *.log log.txt 2>&1 2>/dev/null
	-@find . -name "*~" -exec ${CLEAN} {} \; 2>&1 2>/dev/null
	-@find . -name "*#*" -exec ${CLEAN} {} \; 2>&1 2>/dev/null
	@echo "# $@"

clean-bin:
	-@${CLEAN} *.class *.jar \
	${OBJ_DIR}/*.class ${DESTDIR}/*.jad ${DESTDIR}/*.jar \
	2>&1 2>/dev/null
	@echo "# $@"

#${DESDIR}

clean: clean-bak clean-bin clean-src
	@echo "# $@"
GEN_PATH ?= tmpclasses tmplib  classes  res src bin

clean-all: clean clean-src clean-src-all
	-@${CLEAN} -rf ${DESTDIR}../jclasses* ${OBJ_DIR}../jclasses* ${DESTDIR} jclasses-midp*  ${GEN_PATH} \
	/tmp/home/${USER} 2>&1 2>/dev/null
	-@${CLEAN} *.log 2>&1 2>/dev/null
	ls
	@echo "# $@"
clean-sys:
	-@${CLEAN} -rf ${SDK_PATH} 2>&1 2>/dev/null
	@echo "# $@"
clean-src:
	-@${CLEAN} ${SRC_DIR_ABS}/* 2>&1 2>/dev/null
	@echo "# $@"

clean-src-all:
	-@${CLEAN} -rf src-10 src-10-nokia src-20  src-exen* src-  src-midp* src-exen* src-j2se src-imode 2>&1 2>/dev/null
	@echo "# $@"

dir-gen: ${GEN_PATH}


url: modes ${DESTDIR}${PROJECT}.jad ${DESTDIR}${PROJECT}.jar
	lynx -dump -head ${URL_BASE}${DESTDIR}${PROJECT}.jar
	lynx -dump -head ${URL}
	lynx -dump ${URL}


modes:
	find ${PWD} -type f -exec chmod a-x+X {} \;
	-@chmod -R a+rX ${HOME}/public_html/
	@echo "#- $@"


arc zip arch: ${PROJECT_DIST}-${VERSION_DOT}_${DATE}.zip

${PROJECT_DIST}.zip ${PROJECT_DIST}-${DATE}.zip ${PROJECT_DIST}-${VERSION_DOT}_${DATE}.zip: clean-bak
	-cp ${WEBDIR}/../00index.htm ./
	cd .. && ${CLEAN} $@; zip -r -9 $@ ${PROJECT} && ls -l $@



#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~# SDK
# 

clean-sdk:
	${SW_DIR}WTK104/bin/emulator -Xjam:remove=${PROJECT}


${SW_DIR}WTK104: ${SW_ARC}j2me_wireless_toolkit-1_0_4_01-bin-linuxi386.bin
	-cd ${SW_DIR} && umask 000 && \
	-${CLEAN} -rf $@ ; ${MKDIR} $@  
	cd $@ && ${UNZIP} $<

${SW_DIR}WTK2.1: ${SW_ARC}j2me_wireless_toolkit-2_1-beta-bin-linux-i386.bin 
	-cd ${SW_DIR} && umask 000 && \
	-${CLEAN} -rf $@ ; ${MKDIR} $@ 
	 cd $@ && ${UNZIP} $<

${SW_DIR}midp2.0fcs: ${SW_ARC}midp-2_0-src-linux-i686.zip 
	-cd ${SW_DIR} && umask 000 && \
	-${CLEAN} -rf $@ 	
	${UNZIP} $<

uninstall:
	-${SW_DIR}WTK104/bin/emulator -Xjam:remove=all
	-${SW_DIR}WTK2.1/bin/emulator -Xjam:remove=all
	-${SW_DIR}midp2.0fcs/bin/midp -remove all

uninstall-all:
	-${CLEAN} -rf ${SDK_PATH}
#	${CLEAN} -rf "${SW_DIR}WTK104/appdb/www%002e#Philippe%002e#C#O#V#A#L%002efree%002e#F#R_#"*


install-all: ${SDK_PATH}


#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~# Emulators
# 

exec-all: exec-all-midp1_0 exec-all-midp1_0-nokia exec-all-midp2_0 exec-all-j2se exec-all-exen

exec-all-midp1_0:
	${MAKE} RT=midp1_0 exec-WTK2.1 exec-WTK104 
	${MAKE} RT=midp1_0 exec-nokia-40 exec-nokia-60 exec-micro
	-${MAKE} RT=midp1_0 exec-midp2.0fcs

exec-all-midp2_0:
	${MAKE} RT=midp2_0 exec-WTK2.1 exec-nokia 
	-${MAKE} RT=midp2_0 exec-midp2.0fcs 

exec-all-midp1_0-nokia:
	${MAKE} RT=midp1_0-nokia exec
	${MAKE} RT=midp1_0-nokia exec-nokia-60

exec-url-all: modes ${SDK_PATH}

exec-url-wtk2: browse
	${SW_DIR}WTK2.1/bin/emulator -Xjam:transient=${URL} 

exec-url-wtk1: browse
	${SW_DIR}WTK104/bin/emulator -Xjam:transient=${URL} 

exec-url exec-midp2.0fcs exec-ri-url exec-url-20: browse
	@echo "### !!! Dont exit after shutdown? Hit ^C ($@)"
	-killall -9 midp
	-${SW_DIR}midp2.0fcs/bin/midp -autotest ${URL} &
	@echo "$@ ${URL}"
#	-killall -9 midp

ri exec-ri: ${DESTDIR}${PROJECT}.jad modes
	${MAKE} exec-ri-url RT=${RT}

#exec-WTK104 exec-WTK2.1 ${PROJECT}: ${SDK_DIR} url
#	${VM} -Xdescriptor:${URL}

exec-midp2_0 exec-wtk exec-21  exec-WTK2.1: ${DESTDIR}${PROJECT}.jad
	${SW_DIR}WTK2.1/bin/emulator -Xdescriptor:$^ 

exec-midp1_0 exec-bw exec-WTK104: ${DESTDIR}${PROJECT}.jad
	${SW_DIR}WTK104/bin/emulator -Xdescriptor:$^ 

EMU_HOME?=${SW_DIR}Nokia/Devices/Nokia_Series_40_MIDP_Concept_SDK_Beta_0_3/

exec-midp1_0-nokia exec-nokia-40 exec-Nokia: ${DESTDIR}${PROJECT}.jad
	java -cp ${EMU_HOME}tools/emulator.jar  -Demulator.home="${EMU_HOME}"   com.nokia.phone.sdk.Emulator -uei $<

exec-nokia exec-nokia-60 exec-n60: ${DESTDIR}${PROJECT}.jad
	${SW_DIR}Nokia/Devices/Series_60_MIDP_Concept_SDK_Beta_0_3_1_Nokia_edition/bin/emulator $^

exec-all-j2se:
	${MAKE} RT=j2se exec
# standalone
start: start-WTK104

emu 	wtk start start-midp20 start-WTK2.1:
	${SW_DIR}WTK2.1/bin/emulator -Xjam:force 

start-midp10 start-WTK104:
	${SW_DIR}WTK104/bin/emulator -Xjam:force 



#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
# www.in-fusio.com 's Exen
#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


${SRC_DIR_ABS}${PROJECT}.xml: ${SRC_IN_DIR}${PROJECT}.xml
	${MKDIR} ${@D} 
	cp $^ $@

exenc: ${DESTDIR}${EXEN_TARGET}

${DESTDIR}${EXEN_TARGET}: ${SRC_DIR_ABS}${PROJECT}.xml
	@echo "#+ $@"
	@echo source ${SDK_DIR}bin/setupenv
	@echo INFUSIO_PP_LIN=${INFUSIO_PP_LIN}
	cd ${SDK_DIR}bin && exenc $<
	@cp ${SRC_DIR_ABS}${@F} ${@}
	@echo "#- $@"
#	@-${CLEAN} ${<D}*.class

pcp: ${DESTDIR}${EXEN_TARGET:.exn=.pcp}

%.pcp: %.exn
	${EXN2CTC} $^

#${DESTDIR}${EXEN_TARGET}: ${SRC_DIR_ABS}${EXEN_TARGET}
#	${MKDIR} ${@D}
#	cp -a $< ${@D}
#	${EXN2CTC} $@

#  ${DESTDIR}${EXEN_TARGET}
all-exen: 
	make RT=exen \
	 ${DESTDIR}${EXEN_TARGET} 
	@echo "### - $@"
all-exen exen-post: ${DESTDIR}${EXEN_TARGET}


exec-all-exen: 
	@echo "### + $@"
	${MAKE} RT=exen all-exen pcp exec 
	@echo "### - $@"

exec-exen: ${DESTDIR}${EXEN_TARGET}
	@echo "#+ $@"
	ls -l $<
	cd ${<D} && \
	echo ${VM_EXEN} ${<F}
	@echo "#- $@"

exec-exen-arg:
	@echo "#+ $@"
	ls -l $<
	cd ${<D} && \
	${VM_EXEN} ${<F}
	@echo "#- $@"

install-exen: ${EXEN_ROM}


clean-exen:
	-@rm -rf *-exen
	@echo "#- $@"
exen:
	echo source ${SDK_DIR}bin/setupenv
	${MAKE} RT=$@ all all-exen 
#exenexen-obj exen-pvc-fast exen-rom

#${DEST_DIR}${ARG}: all-exen

exen-obj exen-classes: ${SRCS}
	${MKDIR} ${DESTDIR}
	${JAVACP} $^

exen-pvc: ${FILES:=.pvc}

%.pvc: %.class
	cd ${^D} && \
	${WMTRANS} ${^F:.class=}


# SVM Classfile Translator 1.0 (Build 10205)

# && ls
#  -do "." -v -gp -g4 -dt -vt ${PROJECT}Render
#&& ls 
#	${WMTRANS} -gp -v -w -vd $(^F:.class=) && ls # -vt -ve ...

#INFUSIO_PP_LIN=\/home\/rzr\/mnt\/infusio

#VMTRANS += -gp -v -w 
VMTRANS_FLAGS += -do "PVC file" -v -gp -g4 -dt -vt "Target"

exen-build:
	${MAKE} RT=exen srcs exen-obj exen-pvc pvc-link exen-rom

pvc-link exen-pvc-fast: ${OBJS}
	-@${CLEAN} ${OBJ_DIR}*.pvc 
	cd ${OBJ_DIR} &&  \
	${WMTRANS} ${WMTANS_FLAGS}\
	${OBJS:.class=} && ls 
	@echo "#- $@"

#vmtrans -do "PVC file" -v -gp -g4 -dt -vt "Target file"


post-exen: exen-pvc-fast le_default.exn

#exen-rom: ${DEST_DIR}${EXEN_TARGET}
#	echo "$<"

#${OBJS:.class=.pvc}
bug-exen-rom:
	@echo "... creating rom"
	-@${CLEAN} ${OBJ_DIR}*.exn
	cd ${OBJ_DIR} &&  ls && \
	${PVC2ROM} -gv -dc . -dr ${EXEN_ROM} -do ${F} 
	@echo "#- $@"

test-exen: src-exen/ExEn/${EXEN_TARGET}
	${MAKE} RT=exen	exec-exen ARG="${<D}/${<F}"

bug-exen: 
	${MAKE} RT=exen default post-exen-pvc post-exen
#	${WMTRANS} -h


bug-all-exen: 
	${MAKE} RT=exen srcs exen-exenc



bug-test-exen: le_default.exn
	ls -l $<
	${MAKE} exec-exen ARG=$<

#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

${SRC_DIR}${PROJECT}.pro: ${OBJ_DIR}
	@echo "#+ $@"
	@echo ""
	@echo "#### Optimising Bytecode"
	@echo "#"
	@echo "" > $@
	@echo "-libraryjars ${API}:${API_MIDP}" >> $@
	@echo "-injars ${DESTDIR}${PROJECT}.jar" >> $@
	@echo "-outjar ${OBJ_DIR}${PROJECT}obfuscated.jar" >> $@
	@echo "-overloadaggressively" >> $@
	@echo "-defaultpackage ''" >> $@
	@echo "-keep public class * " >> $@
	cat $@
	@echo "#- $@"

OBFUSCATE=java -jar /mnt/c/usr/jclasses/proguard.jar

${OBJ_DIR}${PROJECT}obfuscated.jar: ${DESTDIR}${PROJECT}.jar
	@echo "#+ $@"
	${OBFUSCATE} @${SRC_DIR}${PROJECT}.pro
	ls -l $<
	ls -l $@
	@echo "#- $@"

pro-post:  ${OBJ_DIR}${PROJECT}obfuscated.jar  pro-preverif ${DESTDIR_ABS}
	@echo "#+ $@"
	mv $< ${DESTDIR_ABS}${PROJECT}.jar
	@echo "#- $@"

pro-preverif-jar: ${OBJ_DIR}${PROJECT}obfuscated.jar  
	${PREVERIFY} -classpath ${API}:${API_MIDP} $<
	@echo "#- $@ # doesnt work"

PREVERIFYDIR=${OBJ_DIR}../obfuscated-${RT}/
pro-preverif: ${OBJ_DIR}${PROJECT}obfuscated.jar  
	@echo "#+ $@"
	ls -l $<
	-${CLEAN} ${PREVERIFYDIR}
	${MKDIR} ${PREVERIFYDIR}
	cd ${PREVERIFYDIR} && \
	jar xvf $< && \
	${PREVERIFY} -classpath ${API}:${API_MIDP} -d .  . && \
	jar cvfm $< ${SRC_DIR_ABS}MANIFEST.MF . 
	@echo "#- $@"

obfuscate obfuscated proguard pro: ${SRC_DIR}${PROJECT}.pro  pro-post jad-re

api: doc-api-${RT} force

doc-api-${RT}:
	javadoc -d $@ ${SRC_DIR}/*.java

#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
info-project:
	@echo DESTDIR=${DESTDIR}
	@echo DESTDIR_ABS=${DESTDIR_ABS}
	@echo SRC_DIR_ABS=${SRC_DIR_ABS} 
	@echo OBJ_DIR=${OBJ_DIR}
# imported rules 

version:
	${JAVA} -version
	${JAVAC} -help
	${MAKE} --version
	${SH} --version

info-user:
	@echo PROJECT=${PROJECT}
	@echo PROJECT_URL=${PROJECT_URL}
	@echo USER=${USER}
	@echo OSTYPE=${OSTYPE}
	@echo OS=${OS}
	@echo DATE=${DATE}
	@echo VERSION=${VERSION}
	uname -a
	arch
	hostname
cvs-tag:
	@echo cvs tag "${PROJECT}-${VERSION_CHAR}-${DATE}-${PROFILE}"

force:
	@echo "- $@"
#	@echo EMAIL=${EMAIL}
# $Id: GNUmakefile,v 1.15 2004-11-02 14:33:08 rzr Exp $
#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
