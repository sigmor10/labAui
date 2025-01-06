#!/bin/bash

mvn clean package

docker build -t gateway-app .
