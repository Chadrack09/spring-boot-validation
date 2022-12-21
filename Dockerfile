FROM ubuntu:latest

RUN mkdir /app

# install java 8 and maven
RUN apt-get update && apt-get install -y openjdk-8-jdk maven

# set environment variables
ENV JAVA_HOME /usr/lib/jvm/java-8-openjdk-amd64
ENV PATH $PATH:$JAVA_HOME/bin

WORKDIR /app

COPY target/*.jar /app/spring-boot-docker.jar

RUN ls -la /app

CMD ["java","-jar","~/app/spring-boot-docker.jar"]