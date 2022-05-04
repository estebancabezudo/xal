* Change to the directory spring-boot

* Run database and centos
  docker-compose up

* Create image
  docker build --network postgres -t xal-app .

* Run API
  docker run --volume appData:/home/data --network postgres -p 8081:8080 xal-app

* Copy the data to the file server
  docker container cp sample.csv fileServer:/home/data/data.csv

* Check for the empty data
  curl --location --request GET 'localhost:8081/people'

* Ingest the file data
  curl --location --request POST 'localhost:8081/people/ingest'

* Check again
  curl --location --request GET 'localhost:8081/people'

* Get one person
  curl --location --request GET 'localhost:8081/people/21'

