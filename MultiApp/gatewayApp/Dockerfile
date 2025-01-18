FROM eclipse-temurin:17.0.6_10-jre
LABEL authors="kuba"

ENV SERVER_PORT=8080

ENV APP_GATEWAY_HOST=localhost:8080

ENV EUREKA_CLIENT_SERVICEURL_DEFAULTZONE=http://localhost:8085/eureka
ENV EUREKA_INSTANCE_INSTANCE_ID=1

EXPOSE 8080

COPY target/gatewayApp-0.0.1-SNAPSHOT.jar /opt/gateway-app/gateway-app.jar

CMD ["java", "-jar", "/opt/gateway-app/gateway-app.jar"]
