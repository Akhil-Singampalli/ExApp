FROM openjdk:11
VOLUME /tmp
EXPOSE 8000
ADD target/*.jar exultapp.jar
ENTRYPOINT ["sh","-c","java -jar /exultapp.jar"]