#!/bin/bash

ng build --configuration production

docker build -t front-end-app .
