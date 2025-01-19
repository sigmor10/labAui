FROM eclipse-temurin:17.0.6_10-jre
LABEL authors="Jakub Kinder"

ENV SERVER_PORT=8080

ENV EUREKA_CLIENT_SERVICEURL_DEFAULTZONE=http://localhost:8085/eureka
ENV EUREKA_INSTANCE_INSTANCE_ID=1

ENV SPRING_PROFILES_ACTIVE=native

ENV SPRING_CLOUD_CONFIG_SERVER_NATIVE_SEARCH_LOCATIONS=file:/var/config-app/configuration

VOLUME /var/config-app/configuration


EXPOSE 8080

COPY target/ConfigApp-0.0.1-SNAPSHOT.jar /opt/config-app/Config-app.jar

CMD ["java", "-jar", "/opt/config-app/Config-app.jar"]
