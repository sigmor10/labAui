package lab4.gatewayapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayAppApplication.class, args);
    }

    @Bean
    public RouteLocator routeLocator(
            RouteLocatorBuilder builder,
            @Value("${app.gateway.host}") String hostUrl,
            @Value("${app.brand.url}") String brandUrl,
            @Value("${app.smartphone.url}") String phoneUrl
    ) {
        return builder.routes()
                .route("brands", r -> r
                        .host(hostUrl)
                        .and()
                        .path(
                                "/api/brands",
                                "/api/brands/{uuid}"
                        )
                        .uri(brandUrl))
                .route("smartphones", r -> r
                        .host(hostUrl)
                        .and()
                        .path(
                                "/api/smartphones",
                                "/api/smartphones/{uuid}",
                                "/api/brands/{brandId}/smartphones"
                        )
                        .uri(phoneUrl))
                .build();
    }
}
