FROM openjdk:11
VOLUME /tmp
EXPOSE 8080
ADD target/ws-prueba-api-0.0.1-SNAPSHOT.jar ws-prueba-api-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/ws-prueba-api-0.0.1-SNAPSHOT.jar"]