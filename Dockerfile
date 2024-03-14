FROM openjdk:17
EXPOSE 8081
ADD target/money-0.0.1-SNAPSHOT.jar money-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/money-0.0.1-SNAPSHOT.jar"]