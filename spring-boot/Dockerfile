FROM alpine/git as clone
WORKDIR /app
RUN git clone https://github.com/estebancabezudo/xal.git

FROM maven:3.5-jdk-8-alpine as build
WORKDIR /app
COPY --from=clone /app/xal /app
RUN mvn -X install

