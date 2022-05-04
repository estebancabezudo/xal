FROM alpine/git as clone
WORKDIR /app
RUN git clone https://github.com/estebancabezudo/xal.git

FROM maven:3.5-jdk-8-alpine as build

COPY --from=clone /app/xal /app
COPY --from=clone /app/xal/spring-boot/application.properties /app/

WORKDIR /app
RUN mvn -X install
ENTRYPOINT ["java", "-jar","/app/target/xal-v1.jar"]