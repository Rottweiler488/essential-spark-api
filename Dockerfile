FROM eclipse-temurin:21-jre

WORKDIR /app

COPY build/libs/esapp-latest.jar app.jar

EXPOSE 7132

ENTRYPOINT ["java", "-jar", "app.jar"]