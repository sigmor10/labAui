#!/bin/bash

mvn clean package

docker build -t eureka-app .
