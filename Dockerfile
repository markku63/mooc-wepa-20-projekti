FROM maven:3.6-openjdk-11 AS builder
WORKDIR /build
# RUN git clone https://github.com/markku63/mooc-wepa-20-projekti.git .
COPY pom.xml /build/
COPY src /build/src/
RUN mvn clean package

FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=builder /build/target/wepa_Projekti-1.0-SNAPSHOT.jar .
EXPOSE 8080
CMD [ "java", "-jar", "/app/wepa_Projekti-1.0-SNAPSHOT.jar" ]