package com.codecamp.SpyGlassApi.domain.user.controller;

import com.codecamp.SpyGlassApi.domain.goal.service.GoalService;
import com.codecamp.SpyGlassApi.domain.user.exceptions.UserNameNotFoundException;
import com.codecamp.SpyGlassApi.domain.user.exceptions.UserNameTakenException;
import com.codecamp.SpyGlassApi.domain.user.model.User;
import com.codecamp.SpyGlassApi.domain.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("")
    public ResponseEntity<User> create(@RequestBody User user) throws UserNameTakenException {
        user = userService.createUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @DeleteMapping("")
    public ResponseEntity<?> delete(@PathVariable String userName){
        try{
            userService.deleteUserAccount(userName);
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .build();

        }catch (UserNameNotFoundException ex){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

}
