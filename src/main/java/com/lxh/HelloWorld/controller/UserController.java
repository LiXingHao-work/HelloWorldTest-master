package com.lxh.HelloWorld.controller;
import com.lxh.HelloWorld.dao.User;
import com.lxh.HelloWorld.dao.vo.Result;
import com.lxh.HelloWorld.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/user/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("HelloWorld")
    public Mono<Result> getUsers() {
        List<User> users = userService.list();
        return Mono.just(Result.success(users));
    }

}
