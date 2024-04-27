package com.lxh.HelloWorld.controller;

import com.lxh.HelloWorld.component.JWTComponent;
import com.lxh.HelloWorld.dao.User;
import com.lxh.HelloWorld.exception.Code;
import com.lxh.HelloWorld.service.UserService;
import com.lxh.HelloWorld.dao.vo.Result;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping("/api/")
@Slf4j
@RequiredArgsConstructor
public class LoginController {
    private final UserService userService;
    private final PasswordEncoder encoder;
    private final JWTComponent jwtComponent;

    @PostMapping("login")
    public Mono<Result> login(@RequestBody User user, ServerHttpResponse response) {

        return Mono.just(userService.login(user))
                .filter(u -> encoder.matches(user.getPassword(), u.getPassword()))
                .map(u -> {
                    Map<String, Object> tokenM =
                            Map.of("uid", u.getId(),
                                    "name", u.getName());
                    String token = jwtComponent.encode(tokenM);
                    response.getHeaders().add("token", token);
                    return Result.success(Map.of("user", u));
                })
                .defaultIfEmpty(Result.error(Code.LOGIN_ERROR));
    }

}
