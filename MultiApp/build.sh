#!/bin/bash

cd ElementsApp || exit
./build.sh
cd ..

cd gatewayApp || exit
./build.sh
cd ..

cd EurekaApp || exit
./build.sh
cd ..

cd ConfigApp || exit
./build.sh
cd ..

cd FrontEndApp || exit
./build.sh
cd ..

cd lab2/main || exit
./build.sh
cd ..
cd ..
