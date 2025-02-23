# Build stage
FROM gradle:jdk21-jammy AS build
WORKDIR /API
COPY . .
RUN gradle build --no-daemon

# Run stage
FROM eclipse-temurin:21-jre-jammy
WORKDIR /API
COPY --from=build /API/build/libs/*.jar API.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "API.jar"]