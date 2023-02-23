package com.wendy.demo.user.controller;

import com.wendy.demo.user.domain.entity.UserEntity;
import com.wendy.demo.user.domain.output.UserOutput;
import com.wendy.demo.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserOutput> findAll(){
       return userService.findAll();
    }

}
