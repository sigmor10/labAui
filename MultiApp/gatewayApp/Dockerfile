FROM eclipse-temurin:17.0.6_10-jre
LABEL authors="kuba"

ENV SERVER_PORT=8080

ENV APP_GATEWAY_HOST=localhost:8080
ENV APP_SMARTPHONE_URL=http://localhost:8082
ENV APP_BRAND_URL=http://localhost:8081

EXPOSE 8080

COPY target/gatewayApp-0.0.1-SNAPSHOT.jar /opt/gateway-app/gateway-app.jar

CMD ["java", "-jar", "/opt/gateway-app/gateway-app.jar"]
