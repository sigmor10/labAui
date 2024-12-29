FROM eclipse-temurin:17.0.6_10-jre
LABEL authors="Jakub Kinder"

ENV SERVER_PORT=8080

ENV SPRING_DATASOURCE_URL=jdbc:h2:mem:smartphones
ENV SPRING_DATASOURCE_DRIVERCLASSNAME=org.h2.Driver
ENV SPRING_DATASOURCE_USERNAME=admin
ENV SPRING_DATASOURCE_PASSWORD=password
ENV SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.H2Dialect
ENV SPRING_JPA_GENERATE_DDL=true
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update


EXPOSE 8080

COPY target/ElementsApp-0.0.1-SNAPSHOT.jar /opt/elements-app/Elements-app.jar

CMD ["java", "-jar", "/opt/elements-app/Elements-app.jar"]
