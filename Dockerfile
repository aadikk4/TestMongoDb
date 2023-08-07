# Stage 1: Build the application
FROM maven:3.8.4-openjdk-17-slim as builder
COPY . /usr/src/mymongodb
WORKDIR /usr/src/mymongodb
RUN mvn clean package

# Stage 2: Create the final container with the built application
FROM openjdk:17-alpine
COPY --from=builder /usr/src/mymongodb/target/TestMongoDb-0.0.1-SNAPSHOT.war /app/TestMongoDb.war
CMD ["java", "-jar", "/app/TestMongoDb.war"]
