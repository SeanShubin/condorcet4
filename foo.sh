#!/usr/bin/env bash

while sleep 2
do
curl -m 10 -d -v -u coj_osn_de:coj_osn_de https://services-b2b.tst1.intra.pb-nonprod.de/165/v1/soap?wsdl
done
