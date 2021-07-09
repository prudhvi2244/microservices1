FROM openjdk:8
EXPOSE 9555
ADD "target/config-server.jar" "config-server.jar"
ENTRYPOINT ["java","-jar","/config-server.jar"]