FROM centos:7

RUN yum install -y java-11

WORKDIR /app

COPY xal-v1.jar /app/
COPY application.properties /app/

COPY sample.csv /app

ENTRYPOINT ["java", "-jar","/app/xal-v1.jar"]