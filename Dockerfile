FROM openjdk:11
EXPOSE 8080
ADD target/spring-petstore.jar spring-petstore.jar
ENTRYPOINT ["java","-jar","/spring-petstore.jar"]