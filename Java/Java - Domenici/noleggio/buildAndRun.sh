#!/bin/sh
mvn clean package && docker build -t it.ciacformazione/noleggio .
docker rm -f noleggio || true && docker run -d -p 8080:8080 -p 4848:4848 --name noleggio it.ciacformazione/noleggio 
