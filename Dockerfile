# Use an official Maven image to build the app
FROM maven:3.9.9-eclipse-temurin-23 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the entire project into the container
COPY . .

# Build the project and create the jar file
RUN mvn clean package -DskipTests

# Use a smaller image to run the application
FROM eclipse-temurin:23-jre-alpine

# Create a directory for the app
RUN mkdir /app

# Copy the jar file from the build stage to the run stage
COPY --from=build /app/target/*.jar /app/server-0.0.1-SNAPSHOT.jar

# Expose the port the app runs on
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java","-jar","/app/server-0.0.1-SNAPSHOT.jar"]
