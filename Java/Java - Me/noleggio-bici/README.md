# Build
mvn clean package && docker build -t it.ciacformazione/noleggio-bici .

# RUN

docker rm -f noleggio-bici || true && docker run -d -p 8080:8080 -p 4848:4848 --name noleggio-bici it.ciacformazione/noleggio-bici 