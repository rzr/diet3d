# $Id: GNUmakefile,v 1.3 2004-03-13 17:25:07 rzr Exp $
# * @author www.Philippe.COVAL.free.fr
# * Copyright and License : http://rzr.online.fr/license.htm
#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
ENV ?= j2me
RT_LIST?=midp1_0 midp1_0-nokia midp2_0 imode exen
#RT ?=midp1_0
#RT ?=midp2_0
RT ?=midp1_0-nokia
JAVA_HOME?=/usr/lib/j2se/1.4/

SW_ARC?=${HOME}/mnt/software/
# commands
UNZIP ?= unzip -q
CONVERTER ?=java -cp ${SW_DIR}midp4palm1.0/Converter/Converter.jar com.sun.midp.palm.database.MakeMIDPApp  
FS=\\/
#export 
INFUSIO_PP_LIN ?=\/home\/${USER}\/
INFUSIO_PP_WIN ?=y:
export INFUSIO_PP_WIN INFUSIO_PP_LIN


#
SW_DIR ?= /opt/
SDKV_LIST?=21 20 00 exen
#SDKV ?=21
SDKV ?=20
#SDKV=00
CONFIG=${RT}
SDK_PATH ?=${SW_DIRW}WTK104 ${SW_DIR}WTK2.1 ${SW_DIR}midp2.0fcs
DATE ?=$(shell date +%Y%m%d)
# regnerated everytime
#TMP ?=$(shell mktemp)
TMP=/tmp/tmp-${USER}-${NAME}-${RT}-${SDKV}-${DATE}-tmp
ID ?=$(shell date +%Y%m%d%s)
VERSION ?=0.0.$(shell date +%Y%m%d%H)
VERSION2 ?= 0.15
# crash on : 6600, menu 6650


#DEFINES+=-DNOINLINE -DDEBUG
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
URL_BASE?=http://localhost/~${USER}/${PROJECT}/
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
ALL+=${DESTDIR}${PROJECT}.jad ${DESTDIR}${PROJECT}.wml
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
TMP_DIR=./jclasses-${RT}/
DESTDIR=${TMP_DIR}
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
#TMP_DIR=./jclasses-${RT}/
TMP_DIR=${SRC_DIR}
#SRC_DIR_ABS=./src-${RT}/
FILES=${PROJECT} ${PROJECT}Canvas
#SRCS?=${FILES:=.java} 
DATA=${PROJECT}.xml
DATA_DIR=${SRC_DIR_ABS}
ALL=${DIR_PATH} ${OBJS} all-exen
TMP_DIR=./jclasses-${RT}/
DESTDIR=jclasses-${RT}/
SRC_DIR=src-${RT}/
#SRCS_IN?=${FILES:=.java.in}
#OBJS?=${FILES:=.class}
#PREVERIFY=${SW_DIR}midp2.0fcs/bin/preverify
PREVERIFY=echo ${SW_DIR}midp2.0fcs/bin/preverify
JAVAC=javac -g:none -target 1.1
JAVACP=javacp
#SRC_DIR_ABS ?=
#EXEN_RUN ?=cd ${SDK_DIR} && nice wine --
EXEN_RUN=nice wine --
WMTRANS=${EXEN_RUN} ${SDK_DIR}bin/vmtools/VMTrans.exe
WMTRANS_FLAGS= -gr -v -gp -g4 -dt -vt
#WMTRANS?=cd ${SDK_DIR}bin/vmtools/ && vmtrans
#WMTRANS?=cd ${SDK_DIR}bin/vmtools/ && vmtrans
# -dc "/home/rzr/src/Diet3D/src-exen/classes" -do "/home/rzr/src/Diet3D/src-exen/pvc" -gr -v -gp -g4 -dt -vt "resource"

SDK_DIR_WIN= Y:\\home\\${USER}\\mnt\\${SDK}\\
#EXEN_ROM ?= ${SDK_DIR_WIN}etc\\exenrom\\ExEnV2\\lexen.rom
EXEN_ROM=${SDK_DIR}etc/exenrom/ExEnV2/lexen.rom
#PVC2ROM ?=wine -- ${SDK_DIR}bin/vmtools/exenrom/exenrom.exe
#PVC2ROM ?=wine -- ${SDK_DIR}bin/vmtools/exenrom/exenrom.exe
PVC2ROM=wine -- ${SDK_DIR}bin/vmtools/exenrom/exenrom

VM_EXEN=${EXEN_RUN} ${SDK_DIR}bin/simulator_v2/generic/Color/gensimu.exe 
EXN2CTC=wine -- ${HOME}/mnt/bin-WIN32/EXN2CTC.exe
CLASSPATH=${TMP_DIR}:${API}
endif#endif

#FILES= MathFixed ${PROJECT}Render ${PROJECT}Canvas ${PROJECT}${SUFFIX_MIDLET}
FILES ?= ${PROJECT} ${PROJECT}Canvas ${PROJECT}${SUFFIX_MIDLET}
#FILES=  ${PROJECT}Canvas ${PROJECT}${SUFFIX_MIDLET}

##
#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
# Env Specific
#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

ifeq ($(API),"")
JAVACFLAGS=-d ${TMP_DIR} -classpath ${CLASSPATH}
else
JAVACFLAGS=-bootclasspath ${API} -classpath ${CLASSPATH} -d ${TMP_DIR}
endif

ifeq ($(SDKV),10) 
SDK:=WTK104
SDK_DIR=${SW_DIR}${SDK}/
API ?=${SDK_DIR}lib/midpapi.zip
CLASSPATH=${API}:${EXT}:${TMP_DIR}
VM=${SDK_DIR}bin/emulator
endif

ifeq ($(SDKV),20)
SDK:=midp2.0fcs
SDK_DIR:=${SW_DIR}${SDK}/
MIDP_HOME=${SDK_DIR}
export MIDP_HOME
API ?=${SDK_DIR}classes/
VM=${SDK_DIR}bin/midp
CLASSPATH=${API}:${EXT}:${TMP_DIR}
endif

ifeq ($(SDKV),21)
SDK:=WTK2.1
SDK_DIR:=${SW_DIR}${SDK}/
API ?=${SDK_DIR}lib/cldcapi10.zip
CLASSPATH=${API}:${SDK_DIR}lib/midpapi20.zip:${TMP_DIR}:${EXT}
VM=${SDK_DIR}bin/emulator
endif


# 
# Default values
#

DESTDIR_ABS ?=${PWD}${DESTDIR}
SRC_DIR_ABS ?=${PWD}${SRC_DIR}
TMP_DIR ?=/tmp/${SRC_DIR_ABS}${DESTDIR}

#SRCS=$(wildcard *.java)
#SRCS=
#FILES=$(SRCS:.java=) 
JAVAC ?= javac 
JAVA ?=java
APPLETVIEWER ?= appletviewer
PREVERIFY ?= preverify


#DESTDIR ?=./
#DESTDIR = ../jclasses-${ENV}/
DIRPATH=${SRC_DIR_ABS} ${TMP_DIR} ${DISTDIR_ABS} ${DESTDIR} ${SRC_IN_DIR}
vpath:=${DIRPATH}
VPATH:=${DIRPATH}
PATH:=${JAVA_HOME}/bin/:${PATH}:${SDK_DIR}bin/

SRCS ?= $(FILES:=.java)
SRCS_IN ?= $(FILES:=.java.in)
OBJS ?= $(FILES:=.class)
CLASSPATH ?= ${TMP_DIR}

export RT SDKV MIDPV SDK SDK_DIR

#DEFINES+="-DHAVE_AWT"
export CLASSPATH
#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
# Rules
#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
default: help info all

all compile build: pre ${ALL} post

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
#	-cp ${TMP_DIR}*.java ${SRC_DIR_ABS}


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

# MIDlet-Icon: Diet3D.png

#${PROJECT}RenderAwt.java: ${PROJECT}Render.java
#	echo "//DO NOT EDIT THIS FILE IT IS GENERATED FROM $^ " > $@
#	sed -e "s/\s*\/\/\(.*@use_awt\)/\1/g" < $^ | \
#	sed -e "s/\(.*@use_${ENV}\)/\/\/\1/g"  >> $@


#${PROJECT}Render.class: ${PROJECT}Render.java
#	${JAVAC} -d ${DESTDIR} $^ 



#	touch $@

#${SRCS}: GNUmakefile

run-micro:
	${MAKE} RT=midp1_0 run-memu

run-memu: ${DESTDIR}${PROJECT}.html  ${DESTDIR}../lib/me-applet.jar modes
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
	${MKDIR} ${TMP_DIR}
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

${PROJECT}.jar: ${DESTDIR} GNUmakefile ${DESTDIR}${PROJECT}.jar 

${SRC_DIR_ABS}MANIFEST.MF: ${SRC_IN_DIR}MANIFEST.MF.in
	${MKDIR}  ${SRC_DIR_ABS}
	cat $< | \
	sed -e "s/\(MicroEdition-Profile: \)MIDP-[0-9]*.[0-9]*/\1${MIDPV}/g" |\
	sed -e "s/\(MIDlet-Version: \)[0-9]*.[0-9]*/\1${VERSION2}/g" \
	> $@

#	s/\(MIDlet-Version:\) .*/\1 ${VERSION}/g



 #${PROJECT}MIDlet$$Tick.class ${PROJECT}Render.class 
${DESTDIR}${PROJECT}.jar:${SRC_DIR_ABS}MANIFEST.MF ${OBJS}
	cd ${TMP_DIR} && \
	${PREVERIFY} -classpath ${CLASSPATH} -d . .  && \
	jar cvfm ${DESTDIR_ABS}${PROJECT}.jar ${SRC_DIR_ABS}MANIFEST.MF . 
	file ${DESTDIR}${PROJECT}.jar
	@echo "-$(^F) $(^F:.class=)"


SIZE=`stat $^ | grep "Size:" | sed -e "s/ *Size: \([0-9]*\).*/\1/g" | head -1`

size: ${PROJECT}.jar
	@echo "$^ Size = ${SIZE}"


${DESTDIR}${PROJECT}.jad:  ${DESTDIR}${PROJECT}.jar ${SRC_DIR_ABS}MANIFEST.MF 
	stat ${DESTDIR}${PROJECT}.jar | grep "Size:" \
	 | sed -e "s/ *Size: \([0-9]*\).*/\1/g"
	cat $@ | grep "MIDlet-Jar-Size:" \
	 | sed -e "s/MIDlet-Jar-Size: \([0-9]*\)\s*/\1/g"
	cat ${SRC_DIR_ABS}MANIFEST.MF > $@
	echo "MIDlet-Jar-URL: ${PROJECT}.jar" >> $@
	echo "MIDlet-Jar-Size: ${SIZE}">> $@
	echo "" >> $@
	sed -e "s/MIDlet-Jar-Size: \([0-9]*\)/MIDlet-Jar-Size: \1/g" < $@

# 	echo "MIDlet-Version: ${VERSION2}">> $@


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
	@echo "LastModified = `date`" >> $@
	@echo "" >> $@
	@cat $@
#	cat ${SRC_DIR_ABS}${PROJECT}.jam > $@
#	#sed -e "s/MIDlet-Jar-Size: \([0-9]*\)/MIDlet-Jar-Size: \1/g" < $@

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


applethtml: ${DESTDIR}${PROJECT}Applet.html

${DESTDIR}${PROJECT}Applet.html: ${PROJECT}Applet.class
	@echo "<html>" > $@
	@echo "<applet width=200 height=200" >> $@
	@echo "code=${<F:.class=}" >> $@
	@echo "></applet>" >> $@
	@echo "</html>" >> $@

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


palmos pda prc: 
	${MAKE} RT=midp1_0 ${PROJECT}.prc
	${MAKE} RT=midp2_0 ${PROJECT}.prc

${PROJECT}.prc: ${DESTDIR} ${DESTDIR}${PROJECT}.jad  ${DESTDIR}${PROJECT}.jar
	${CONVERTER} -type Data -jad ${DESTDIR}${PROJECT}.jad ${DESTDIR}${PROJECT}.jar

jar: ${OBJS} ${TMP_DIR} ${DESTDIR_ABS} ${DESTDIR}${PROJECT}.jar
#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
# hany rules for testing deploy etc
#
run run: modes ${DESTDIR} ${DESTDIR}${PROJECT}.wml url run-${RT}

test test-all: clean-all compile-all modes run-all clean-all

test-ri:
	${MAKE} RT=midp1_0 rebuild run-ri

test-nokia n nokia midp1_0-nokia: 
	${MAKE} RT=midp1_0-nokia rebuild run

test-midp1_0 1 10 midp1_0:
	${MAKE} RT=midp1_0 rebuild run

test-midp2_0 20 midp2_0:
	${MAKE} RT=midp2_0 rebuild run

j2se:
	${MAKE} RT=j2se SDKV=0 rebuild run

build-all compile-all: 
	${MAKE} RT=midp1_0 
	${MAKE} RT=midp2_0
	${MAKE} RT=midp1_0-nokia
	${MAKE} RT=j2se SDKV=00
	${MAKE} RT=midp1_0 prc
	${MAKE} RT=midp2_0 prc
	${MAKE} RT=imode
	${MAKE} RT=exen

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
	-${MAKE} RT=midp2_0 all 
	${MAKE} RT=midp2_0 all run-ri



run-application: ${PROJECT}Applet
	cd ${DESTDIR} && \
	${JAVA} $^

run-j2se run-applet: ${DESTDIR}applet.htm 
	-${APPLETVIEWER} $<


${DESTDIR}applet.htm post-j2se: ${PROJECT}Applet
	cp ${SRC_IN_DIR}applet.htm ${DESTDIR}



names:
	-mv readme README
	-mv authors AUTHORS
	-mv copying COPYING

info infos:
	@echo "#default settings are : "
	@echo "#SDK=${SDK}"
	@echo "#SDK_DIR=${SDK_DIR}"
	@echo "#CLASSPATH=${CLASSPATH}"
	@echo "#PATH=${PATH}"
	@echo "#DESTDIR=${DESTDIR}"
	@echo "#DESTDIR_ABS=${DESTDIR_ABS}"
	@echo "#VPATH=${VPATH}"


cc-wildcards:
	${MKDIR} ${DESTDIR}	
	${JAVAC} ${JAVACFLAGS} *.java


pre: ${SDK_DIR} dir

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

release: clean-all test-all install

install: modes install-classes arch

install-classes install-dist dist-install:
	ls ${WEBDIR}
	-${CLEAN} -rf ${WEBDIR}${DESTDIR}
	cp -rf ${DESTDIR} ${WEBDIR}
	cp -rf ./jclasses-* ${WEBDIR}
	ls -l ${WEBDIR}${DESTDIR}

install-src:  ${HOME}/homedir/
	mv ${HOME}/homedir/${PROJECT} ${HOME}/homedir/${PROJECT}-bak-${ID}
	cp -rf ${PWD}   ${HOME}/homedir/

CLEAN=rm -rf

clean-bak:
	-@${CLEAN} *~ "#*" "#*.*" \#* *.log log.txt 2>&1 2>/dev/null
	-@find . -name "*~" -exec ${CLEAN} {} \; 2>&1 2>/dev/null
	-@find . -name "*#*" -exec ${CLEAN} {} \; 2>&1 2>/dev/null
	@echo "# $@"

clean-bin:
	-@${CLEAN} *.class *.jar \
	${TMP_DIR}/*.class ${DESTDIR}/*.jad ${DESTDIR}/*.jar \
	2>&1 2>/dev/null
	@echo "# $@"

#${DESDIR}

clean: clean-bak clean-bin clean-src
	@echo "# $@"
GEN_PATH ?= tmpclasses tmplib  classes  res src bin

clean-all: clean clean-src clean-src-all
	-@${CLEAN} -rf ${DESTDIR}../jclasses* ${TMP_DIR}../jclasses* ${DESTDIR} jclasses-midp*  ${GEN_PATH} \
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
#	@find ${PWD} -name "*.jad" -exec chmod a+rX {} \;
#	@find ${PWD} -name "*.jar" -exec chmod a+rX {} \;

arc zip arch: ${PROJECT_DIST}-${VERSION2}_${DATE}.zip

${PROJECT_DIST}.zip ${PROJECT_DIST}-${DATE}.zip ${PROJECT_DIST}-${VERSION2}_${DATE}.zip: clean-bak
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

run-all: run-all-midp1_0 run-all-midp1_0-nokia run-all-midp2_0 run-all-j2se run-all-exen

run-all-midp1_0:
	${MAKE} RT=midp1_0 run-WTK2.1 run-WTK104 
	${MAKE} RT=midp1_0 run-nokia-40 run-nokia-60 run-micro
	-${MAKE} RT=midp1_0 run-midp2.0fcs

run-all-midp2_0:
	${MAKE} RT=midp2_0 run-WTK2.1 run-nokia 
	-${MAKE} RT=midp2_0 run-midp2.0fcs 

run-all-midp1_0-nokia:
	${MAKE} RT=midp1_0-nokia run
	${MAKE} RT=midp1_0-nokia run-nokia-60

run-url-all: modes ${SDK_PATH}

run-url-wtk2:
	${SW_DIR}WTK2.1/bin/emulator -Xjam:transient=${URL} 

run-url-wtk1:
	${SW_DIR}WTK104/bin/emulator -Xjam:transient=${URL} 

run-url run-midp2.0fcs run-ri-url run-url-20:
	@echo "### !!! Dont exit after shutdown? Hit ^C ($@)"
	-killall -9 midp
	-${SW_DIR}midp2.0fcs/bin/midp -autotest ${URL} &
	-killall -9 midp
	@echo "$@ ${URL}"

run-ri: ${DESTDIR}${PROJECT}.jad modes
	${MAKE} run-ri-url RT=${RT}

#run-WTK104 run-WTK2.1 ${PROJECT}: ${SDK_DIR} url
#	${VM} -Xdescriptor:${URL}

run-midp2_0 run-wtk run-21  run-WTK2.1: ${DESTDIR}${PROJECT}.jad
	${SW_DIR}WTK2.1/bin/emulator -Xdescriptor:$^ 

run-midp1_0 run-bw run-WTK104: ${DESTDIR}${PROJECT}.jad
	${SW_DIR}WTK104/bin/emulator -Xdescriptor:$^ 

EMU_HOME?=${SW_DIR}Nokia/Devices/Nokia_Series_40_MIDP_Concept_SDK_Beta_0_3/

run-midp1_0-nokia run-nokia-40 run-Nokia: ${DESTDIR}${PROJECT}.jad
	java -cp ${EMU_HOME}tools/emulator.jar  -Demulator.home="${EMU_HOME}"   com.nokia.phone.sdk.Emulator -uei $<

run-nokia run-nokia-60 run-n60: ${DESTDIR}${PROJECT}.jad
	${SW_DIR}Nokia/Devices/Series_60_MIDP_Concept_SDK_Beta_0_3_1_Nokia_edition/bin/emulator $^

run-all-j2se:
	${MAKE} RT=j2se run
# standalone
exec: exec-WTK104

exec exec-midp20 exec-WTK2.1:
	${SW_DIR}WTK2.1/bin/emulator -Xjam:force 

exec-midp10 exec-WTK104:
	${SW_DIR}WTK104/bin/emulator -Xjam:force 



#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
# www.in-fusio.com 's Exen
#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


${SRC_DIR_ABS}${PROJECT}.xml: ${SRC_IN_DIR}${PROJECT}.xml
	${MKDIR} ${@D} 
	cp $^ $@

${DESTDIR}${EXEN_TARGET}: ${SRC_DIR_ABS}${PROJECT}.xml
	echo source ${SDK_DIR}bin/setupenv
	@echo INFUSIO_PP_LIN=${INFUSIO_PP_LIN}
	cd ${SDK_DIR}bin && exenc $<

%.pcp: %.exn
	${EXN2CTC} $^

#${DESTDIR}${EXEN_TARGET}: ${SRC_DIR_ABS}${EXEN_TARGET}
#	${MKDIR} ${@D}
#	cp -a $< ${@D}
#	${EXN2CTC} $@

#  ${DESTDIR}${EXEN_TARGET}
all-exen: 
	make RT=exen \
	 ${DESTDIR}${EXEN_TARGET} ${DESTDIR}${EXEN_TARGET:.exn=.pcp}
	@echo "### - $@"
all-exen exen-post: ${DESTDIR}${EXEN_TARGET}


run-all-exen: 
	@echo "### + $@"
	${MAKE} RT=exen all-exen run
	@echo "### - $@"

run-exen: ${DESTDIR}${EXEN_TARGET}
	${MAKE} RT=exen run-exen-arg  ARG="$<"

run-exen-arg:
	ls -l $<
	cd ${<D} && \
	${VM_EXEN} ${<F}

install-exen: ${EXEN_ROM}



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
	-@${CLEAN} ${TMP_DIR}*.pvc 
	cd ${TMP_DIR} &&  \
	${WMTRANS} ${WMTANS_FLAGS}\
	${OBJS:.class=} && ls 

#vmtrans -do "PVC file" -v -gp -g4 -dt -vt "Target file"


post-exen: exen-pvc-fast le_default.exn

#exen-rom: ${DEST_DIR}${EXEN_TARGET}
#	echo "$<"

#${OBJS:.class=.pvc}
bug-exen-rom:
	@echo "... creating rom"
	-@${CLEAN} ${TMP_DIR}*.exn
	cd ${TMP_DIR} &&  ls && \
	${PVC2ROM} -gv -dc . -dr ${EXEN_ROM} -do ${F} 


test-exen: src-exen/ExEn/${EXEN_TARGET}
	${MAKE} RT=exen	run-exen ARG="${<D}/${<F}"
bug-exen: 
	${MAKE} RT=exen default post-exen-pvc post-exen
#	${WMTRANS} -h


bug-all-exen: 
	${MAKE} RT=exen srcs exen-exenc



bug-test-exen: le_default.exn
	ls -l $<
	${MAKE} run-exen ARG=$<


#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
info-project:
	@echo DESTDIR=${DESTDIR}
	@echo DESTDIR_ABS=${DESTDIR_ABS}
	@echo SRC_DIR_ABS=${SRC_DIR_ABS} 
	@echo TMP_DIR=${TMP_DIR}
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
	uname -a
	arch
	hostname

CVSROOT?=${HOME}/var/cvs


cvs-init: ${CVSROOT}

${CVSROOT}:
	${MKDIR} $@
	cvs init

cvs-import:
	echo CVSROOT=${CVSROOT}
	cvs -d ${CVSROOT} import ${PROJECT} ${USER} orig

#	@echo EMAIL=${EMAIL}
# $Id: GNUmakefile,v 1.3 2004-03-13 17:25:07 rzr Exp $
#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
