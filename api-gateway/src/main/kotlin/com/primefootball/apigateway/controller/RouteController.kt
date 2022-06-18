package com.primefootball.apigateway.controller

import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.PredicateSpec
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.context.annotation.Bean
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin
class RouteController {
    @Bean
    fun myRoutes(builder: RouteLocatorBuilder): RouteLocator {
        return builder.routes()
            .route { p: PredicateSpec ->
                p.path("/posts/**")
                    .uri("http://post-service-service.default.svc.cluster.local")
            }
            .route { p: PredicateSpec ->
                p.path("/timeline/**")
                    .uri("http://timeline-service-service.default.svc.cluster.local")
            }
            .route { p: PredicateSpec ->
                p.path("/hello-posts")
                    .uri("http://posts-service-service.default.svc.cluster.local")
            }
            .route { p: PredicateSpec ->
                p.path("/hello-timeline")
                    .uri("http://timeline-service-service.default.svc.cluster.local")
            }

//            .route { p: PredicateSpec -> p.path("/posts/**").uri("http://localhost:8089") }
//            .route { p: PredicateSpec -> p.path("/timeline/**").uri("http://localhost:8088") }
//            .route { p: PredicateSpec -> p.path("/hello-posts").uri("http://localhost:8089") }
//            .route { p: PredicateSpec -> p.path("/hello-timeline").uri("http://localhost:8088") }

//            .route { p: PredicateSpec -> p.path("/posts/**").uri("http://post-service:8089") }
//            .route { p: PredicateSpec -> p.path("/timeline/**").uri("http://timeline-service:8088") }
//            .route { p: PredicateSpec -> p.path("/hello-posts").uri("http://post-service:8089") }
//            .route { p: PredicateSpec -> p.path("/hello-timeline").uri("http://timeline-service:8088") }
            .build()
    }

    @GetMapping("/hello")
    fun hello(): String {
        return "Hello gateway!!!!!"
    }
}
