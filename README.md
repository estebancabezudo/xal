* Solo es necesario el archivo zip para correr los contenedores y el servidor con la API en la máquina local

* Solo debemos tener instalado Docker

* Luego de descargar el archivo zip lo descomprimimos. Para probar el sistema tenemos dos formas. Una con un script y otro ejectuando cada uno de los comandos por separado

* Entramos al directorio donde descargamos los archivos y ejecutamos en Linux o Mac
  sh ./run.sh

  Si no usamos Linux o Mac podemos hacer los pasos manuales

* Ejecutamos los contenedore con la base de datos y el servidor de archivos
  docker-compose up

* Creamos la imagen con la API
  docker build --network postgres -t xal-app .

* Ejecutamos un contenedor con la imagen de la API
  docker run --volume appData:/home/data --network postgres -p 8081:8080 xal-app

* Copiamos el archivo con los datos al servidor de archivos
  docker container cp sample.csv fileServer:/home/data/data.csv

  curl --location --request GET 'localhost:8081/people'

* Cargamos los datos del servidor de archivos en el sistema
  curl --location --request POST 'localhost:8081/people/ingest'

* Verificamos que estén los datos
  curl --location --request GET 'localhost:8081/people'

* Obtenemos los datos de una persona
  curl --location --request GET 'localhost:8081/people/21'

El versionamiento de la base de datos se realiza con liquidbase
