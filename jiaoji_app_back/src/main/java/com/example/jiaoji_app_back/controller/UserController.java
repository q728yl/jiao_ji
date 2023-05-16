package com.example.jiaoji_app_back.controller;

import com.example.jiaoji_app_back.entity.User;
import com.example.jiaoji_app_back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("getUserByUserId")
    public User getUserByUserId(@RequestParam("userId") Integer userId) {
        User user = userService.getUserByUserId(userId);
        return user;
    }

}