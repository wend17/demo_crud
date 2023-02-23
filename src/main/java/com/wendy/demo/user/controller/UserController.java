package com.wendy.demo.user.controller;


import com.wendy.demo.user.domain.dto.User;
import com.wendy.demo.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping(value = "/update/{id}")
    public User updateUser (@PathVariable long id, @RequestBody User user){
        user.setId(id);
    return userService.update(user);
    }

    @DeleteMapping (value = "{id}")
    public void deleteUser(@PathVariable Long id){
    userService.deleteById(id);

    }
}
