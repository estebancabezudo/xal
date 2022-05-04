docker-compose up &
docker build --network postgres -t xal-app .
docker run --volume appData:/home/data --network postgres -p 8081:8080 xal-app &
docker container cp sample.csv fileServer:/home/data/data.csv
