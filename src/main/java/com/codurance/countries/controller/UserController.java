package com.codurance.countries.controller;

import com.codurance.countries.domain.MyUser;
import com.codurance.countries.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path="/users")
    @ResponseStatus(code= HttpStatus.OK)
    @ResponseBody
    public MyUser validate_user(@RequestParam String username, @RequestParam String password) {

        MyUser user = new MyUser(username, password);

        return userService.validate_user(user);
    }

    @PostMapping(path="/users")
    @ResponseStatus(code= HttpStatus.CREATED)
    @ResponseBody
    public MyUser create_user(@RequestParam String username, @RequestParam String password) {

        MyUser user = new MyUser(username, password);

        return userService.create_user(user);
    }
}
