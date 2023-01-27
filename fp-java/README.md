## fp-java-homework
This project provides a starter template for the java homework assignments for CSCI-EE88A


The project requires Java 17, gradle-7.3 . Project is shipped with gradle wrapper . So you should just be able to use ./gradlew
inside this direcory

## Install JDK17

https://docs.oracle.com/en/java/javase/17/install/overview-jdk-installation.html#GUID-8677A77F-231A-40F7-98B9-1FD0B48C346A

https://www.oracle.com/java/technologies/downloads/#java17

 - /usr/libexec/java_home -V (in mac) command will print JAVA_HOME path that can be used in IDE tools to setup the JDK for your projects;
 - export this variable in your shell so that gradle would use this JDK from the command line:
 `export JAVA_HOME=<value_from_the_script>`


### Getting started
 Use the following commands to get started with your project

 - Compile: `./gradlew build`
 - create eclipse project files -> `./gradlew cleanEclipe eclipse`
 - create idea project files -> `./gradlew cleanIdea idea`
 - Run tests: `./gradlew test`
 - Create an archive of this project with just source code and gradle script  -> `./gradlew clean assemble srcZip`

### License
Copyright 2023, Harvard Extension School CSCIE88A

Licensed under the Apache License, Version 2.0.
