FROM eclipse-temurin:17.0.6_10-jre
LABEL authors="Jakub Kinder"

ENV SERVER_PORT=8080

ENV SPRING_CONFIG_IMPORT=optional:configserver:http://localhost:8086
ENV EUREKA_INSTANCE_INSTANCE_ID=1

EXPOSE 8080

COPY target/ElementsApp-0.0.1-SNAPSHOT.jar /opt/elements-app/Elements-app.jar

CMD ["java", "-jar", "/opt/elements-app/Elements-app.jar"]
