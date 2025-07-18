# Use lightweight OpenJDK image
FROM openjdk:17-jdk-slim

# Set working directory in container
WORKDIR /app

# Copy the built JAR into container
COPY target/orderenricher-0.0.1-SNAPSHOT.jar app.jar

# Expose port used by Spring Boot
EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]