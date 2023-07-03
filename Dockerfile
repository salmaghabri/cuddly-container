# Use OpenJDK 17 as base image
FROM openjdk:17-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the packaged jar file into the container at /app
COPY target/spring-0.0.1-SNAPSHOT.jar /app/spring.jar

# Expose port 8080
EXPOSE 8080

# Command to run the spring boot application
CMD ["java", "-jar", "spring.jar"]
