#!/bin/bash
javac ../src/compute/Compute.java compute/Task.java
jar cvf compute.jar ../src/compute/*.class
