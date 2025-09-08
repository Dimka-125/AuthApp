FROM eclipse-temurin:17-jdk-alpine

EXPOSE 8080

ADD target/AuthApp-0.0.1-SNAPSHOT.jar MyAuthApp.jar

ENTRYPOINT ["java", "-jar", "MyAuthApp.jar"]