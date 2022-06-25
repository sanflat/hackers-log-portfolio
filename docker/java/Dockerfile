FROM ubuntu:20.04

RUN apt-get update
RUN apt-get install -y openjdk-16-jdk
ENV JAVA_HOME /usr/lib/jvm/java-16-openjdk-amd64
ENV PATH $JAVA_HOME/bin:$PATH
VOLUME /tmp
RUN mkdir /app
WORKDIR /app