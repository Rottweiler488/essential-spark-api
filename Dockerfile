#stage 1: build
FROM eclipse-temurin:21-jdk-alpine AS builder

WORKDIR /workapp

COPY gradlew .
COPY gradle gradle
COPY build.gradle.kts settings.gradle.kts ./
COPY .git .git

RUN ./gradlew dependencies --no-daemon

COPY src src

RUN ./gradlew bootJar --no-daemon

#stage 2: run
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

RUN addgroup -S dockeruser && adduser -S dockeruser -G dockeruser
USER dockeruser:dockeruser

COPY --from=builder /workapp/build/libs/essential-spark-*.jar app.jar

EXPOSE 7132

ENTRYPOINT ["java", "-jar", "app.jar"]