# =========================
# Build Stage
# =========================
# Use Maven with Java 21 to build the Spring Boot app
# Use an official Maven image that bundles Eclipse Temurin JDK 21
FROM maven:3.9.6-eclipse-temurin-21 AS build

# Set working directory inside the container
WORKDIR /app

# Copy Maven config to install dependencies
COPY pom.xml .

# Copy source code
COPY src ./src

# Build the project and skip tests
RUN mvn clean package -DskipTests

# =========================
# Run Stage
# =========================
# Use a lightweight Java 21 runtime to run the app
# Alpine images for newer JDKs may be unavailable in some registries; using the standard Temurin 21 JDK
FROM eclipse-temurin:21-jdk

# Set working directory inside the container
WORKDIR /app

# Copy the built .jar from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose port 5000 (or 8080 if you prefer)
EXPOSE 5000

# Run the Spring Boot app
ENTRYPOINT ["java","-jar","app.jar"]
