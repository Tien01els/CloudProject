package com.example.springbootcloud.controller;

import com.example.springbootcloud.entity.User;
import com.example.springbootcloud.model.dto.UserDto;
import com.example.springbootcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("")
    public ResponseEntity<?> getListUser() {
        return ResponseEntity.ok(userService.getListUser());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable int id) {
        return null;
    }
    @PostMapping("")
    public ResponseEntity<?> createUser(@RequestBody UserDto req) {
        UserDto result = userService.createUser(req);
        return ResponseEntity.ok(req);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser() {
        return null;
    }
    @DeleteMapping ("/{id}")
    public ResponseEntity<?> deleteUser() {
        return null;
    }

}
