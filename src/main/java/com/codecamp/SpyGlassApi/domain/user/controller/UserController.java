package com.codecamp.SpyGlassApi.domain.user.controller;

import com.codecamp.SpyGlassApi.domain.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {

    private UserService userService;

    private UserController(UserService userService){
        this.userService = userService;
    }


}
