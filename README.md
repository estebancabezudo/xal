* Change to the directory spring-boot

* Create image
  docker build -t xal-app .

* Run
  docker-compose up

* Check for the empty data
  curl --location --request GET 'localhost:8081/people'

* Ingest the file data
  curl --location --request POST 'localhost:8081/people/ingest'

* Check again
  curl --location --request GET 'localhost:8081/people'

* Get one person
  curl --location --request GET 'localhost:8081/people/21'
