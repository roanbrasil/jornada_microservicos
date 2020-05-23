package br.com.jornada_gateway.jornadagateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JornadaGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(JornadaGatewayApplication.class, args);
    }

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                    .path("/produto")
                    .filters(f -> f
                            .addRequestHeader("system-id", "101"))
                    .uri("http://localhost:8082")
                )
                .route(p -> p
                        .path("/cliente")
                        .filters(f -> f
                                .addRequestHeader("system-id", "101"))
                        .uri("http://localhost:8081")
                )
                .build();
    }
}
