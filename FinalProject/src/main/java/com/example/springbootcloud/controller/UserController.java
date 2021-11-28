package com.example.springbootcloud.controller;

import com.example.springbootcloud.model.dto.UserDTO;
import com.example.springbootcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
//import javax.validation.Valid;


@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("")
    public ResponseEntity<?> createUser(@RequestBody UserDTO req) {
        UserDTO result = userService.createUser(req);
        return ResponseEntity.ok(req);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@RequestBody UserDTO req, @PathVariable("id") int id) {
        return ResponseEntity.ok(req);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<?> deleteUser() {
        return null;
    }

    @GetMapping("")
    public ResponseEntity<?> getListUser() {
        return ResponseEntity.ok(userService.getListUser());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable int id) {
        return null;
    }
}
