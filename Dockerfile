# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /Medilocker

# Copy the compiled .jar file from your local machine to the container
COPY target/MedilockerBackend.jar MedilockerBackend.jar

# Expose the port your Spring Boot app will run on (default is 8080)
EXPOSE 8080

# Define the command to run your application
ENTRYPOINT ["java", "-jar", "/Medilocker/MedilockerBackend.jar"]
