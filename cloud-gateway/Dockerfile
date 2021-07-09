FROM openjdk:8
EXPOSE 9999
ADD "target/cloud-gateway.jar" "cloud-gateway.jar"
ENTRYPOINT ["java","-jar","/cloud-gateway.jar"]