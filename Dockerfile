FROM openjdk:8-jdk-alpine
MAINTAINER hukamsingh
COPY subsetsum-0.0.1-SNAPSHOT.jar subsetsum-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","subsetsum-0.0.1-SNAPSHOT.jar"]