#!/bin/bash

cd ElementsApp || exit
./build.sh
cd ..

cd gatewayApp || exit
./build.sh
cd ..

cd lab2/main || exit
./build.sh
cd ..
cd ..
