
FROM adoptopenjdk:21-jre-hotspot

WORKDIR /app

COPY target/deploydocker-0.0.1-SNAPSHOT.jar /app

CMD ["java", "-jar", "deploydocker-0.0.1-SNAPSHOT.jar"]
