package com.tistory.lky1001.webfluxsecurityexample.user.handler;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class UserHandler {

    public Mono<ServerResponse> getUser(ServerRequest serverRequest) {
        return ServerResponse.ok().build();
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    public Mono<ServerResponse> getSecureUser(ServerRequest serverRequest) {
        return ServerResponse.ok().build();
    }
}
