FROM eclipse-temurin:17-jdk-focal
EXPOSE 8080
ADD target/money-0.0.1-SNAPSHOT.jar money-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/money-0.0.1-SNAPSHOT.jar"]