FROM adoptopenjdk/openjdk11:alpine-jre
WORKDIR /app
COPY build/libs/authentication-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8999
ENTRYPOINT ["java", "-jar", "app.jar"]
