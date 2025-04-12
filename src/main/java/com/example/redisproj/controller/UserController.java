package com.example.redisproj.controller;

import com.example.redisproj.dto.UserRequestDto;
import com.example.redisproj.entity.User;
import com.example.redisproj.handler.UserHandler;
import com.example.redisproj.repository.UserRepository;
import io.lettuce.core.dynamic.annotation.Param;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserController {

    @Autowired
    UserHandler userHandler;

    @PostMapping("/save/user")
    public UserRequestDto saveUser(@RequestBody UserRequestDto userRequestDto){
        return userHandler.createUser(userRequestDto);
    }

    @GetMapping("/get/user/{id}")
    public UserRequestDto  getUser(@PathVariable Long id){
        return userHandler.getUser(id);
    }

}
