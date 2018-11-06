package com.tistory.lky1001.webfluxsecurityexample.security.handler;

import com.tistory.lky1001.webfluxsecurityexample.security.*;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Arrays;

@Component
public class AuthHandler {

    private JWTUtil jwtUtil;

    private PBKDF2Encoder passwordEncoder;

    public AuthHandler(JWTUtil jwtUtil, PBKDF2Encoder passwordEncoder) {
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    public Mono<ServerResponse> auth(ServerRequest serverRequest) {
        Mono<AuthResponse> response = serverRequest.bodyToMono(AuthRequest.class)
            .map(authRequest -> {
                CustomUserDetails userDetails = new CustomUserDetails("test");
                userDetails.setEnabled(true);
                userDetails.setRoles(Arrays.asList(Role.ROLE_USER));

                return new AuthResponse(jwtUtil.generateToken(userDetails));
            });

        return ServerResponse.ok().body(response, AuthResponse.class);
    }
}
