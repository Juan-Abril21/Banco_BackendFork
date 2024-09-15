FROM ubuntu:latest AS build
RUN apt-get update && apt-get install -y \
    build-essential \
    cmake \
    git \
    libboost-all-dev \
    libssl-dev \
    libtool \
    pkg-config \
    wget \
RUN apt-get install openjdk-17-jdk -y
COPY . .
RUN ./gradlew bootJar --no-daemon

FROM openjdk-17-jdk-slim
EXPOSE 8080
COPY --from=build /build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]