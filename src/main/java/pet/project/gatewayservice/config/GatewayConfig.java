package pet.project.gatewayservice.config;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    private final static String AUTH_SERVICE_ROUTE_ID = "2";
    private final static String AUTH_SERVICE_PREFIX = "/api/auth";
    private final static String AUTH_SERVICE_URI = "http://localhost:8081";

    private final static String USER_SERVICE_ROUTE_ID = "3";
    private final static String USER_SERVICE_PREFIX = "/api/users";
    private final static String USER_SERVICE_URI = "http://localhost:8082";

    private final static String POST_SERVICE_ROUTE_ID = "4";
    private final static String POST_SERVICE_PREFIX = "/api/posts";
    private final static String POST_SERVICE_URI = "http://localhost:8083";

    private final static String NOTIFICATION_SERVICE_ROUTE_ID = "5";
    private final static String NOTIFICATION_SERVICE_PREFIX = "/api/notifications";
    private final static String NOTIFICATION_SERVICE_URI = "http://localhost:8084";

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(AUTH_SERVICE_ROUTE_ID, r -> r.path(AUTH_SERVICE_PREFIX + "/**")
                        .filters(f -> f.stripPrefix(2))
                        .uri(AUTH_SERVICE_URI))
                .route(USER_SERVICE_ROUTE_ID, r -> r.path(USER_SERVICE_PREFIX + "/**")
                        .filters(f -> f.stripPrefix(2))
                        .uri(USER_SERVICE_URI))
                .route(POST_SERVICE_ROUTE_ID, r -> r.path(POST_SERVICE_PREFIX + "/**")
                        .filters(f -> f.stripPrefix(2))
                        .uri(POST_SERVICE_URI))
                .route(NOTIFICATION_SERVICE_ROUTE_ID, r -> r.path(NOTIFICATION_SERVICE_PREFIX + "/**")
                        .filters(f -> f.stripPrefix(2))
                        .uri(NOTIFICATION_SERVICE_URI))
                .build();
    }
}
