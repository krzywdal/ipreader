# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the packaged JAR file into the container
COPY build/libs/ipreader-0.0.1-SNAPSHOT.jar /app/ipreader.jar

# Expose the port that the application will run on
EXPOSE 8080

# Run the Dropwizard application when the container launches
CMD ["java", "-jar", "ipreader.jar"]
