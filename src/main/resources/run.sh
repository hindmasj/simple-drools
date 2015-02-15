#!/bin/bash

LOC=$(dirname $(readlink -f ${BASH_SOURCE[0]}))

CLASSPATH=${LOC}/SimpleDrools.jar
for j in $(ls ${LOC}/SimpleDrools_lib/*.jar);do
	CLASSPATH=$CLASSPATH:${j}
done

java -cp $CLASSPATH com.github.hindmasj.simpledrools.Runner $@
