#!/bin/sh
mvn clean package && docker build -t it.ciacformazione/nostalciac .
docker rm -f nostalciac || true && docker run -d -p 8080:8080 -p 4848:4848 --name nostalciac it.ciacformazione/nostalciac 
