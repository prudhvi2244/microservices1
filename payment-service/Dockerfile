FROM openjdk:8
EXPOSE 9002
ADD "target/payment-service.jar" "payment-service.jar"
ENTRYPOINT ["java","-jar","/payment-service.jar"]