package com.tistory.lky1001.webfluxsecurityexample;

import com.tistory.lky1001.webfluxsecurityexample.security.handler.AuthHandler;
import com.tistory.lky1001.webfluxsecurityexample.user.handler.UserHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@SpringBootApplication
public class WebfluxsecurityexampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebfluxsecurityexampleApplication.class, args);
    }

    @Bean
    @Autowired
    public RouterFunction<ServerResponse> monoRouterFunction(UserHandler userHandler, AuthHandler authHandler) {
        return route(GET("/users/{user}").and(accept(APPLICATION_JSON)), userHandler::getUser)
                .andRoute(GET("/users/{user}/secure").and(accept(APPLICATION_JSON)), userHandler::getSecureUser)
                .andRoute(POST("/auth").and(accept(APPLICATION_JSON)), authHandler::auth);
    }
}
