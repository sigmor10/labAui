#!/bin/bash

mvn clean package

docker build -t elements-app .
