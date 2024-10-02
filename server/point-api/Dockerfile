# Base image
FROM amazoncorretto:21

# Copy the jar file
COPY build/libs/point-api-0.0.1-SNAPSHOT.jar app.jar

# Expose the port
EXPOSE 8081

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]