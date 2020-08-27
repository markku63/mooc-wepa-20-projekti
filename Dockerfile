FROM maven:3.6-openjdk-11 AS builder
WORKDIR /build
COPY pom.xml /build/
COPY src /build/src/
RUN mvn clean package

FROM openjdk:11-jre-slim
# For local testing:
ENV PORT=8080 SPRING_PROFILE="production"
EXPOSE $PORT

WORKDIR /app
COPY --from=builder /build/target/wepa_Projekti-1.0-SNAPSHOT.jar .

# compatible with Heroku
CMD java $JAVA_OPTS -Dspring.profiles.active=$SPRING_PROFILE -Dserver.port=$PORT -jar /app/wepa_Projekti-1.0-SNAPSHOT.jar