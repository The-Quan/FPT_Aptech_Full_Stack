package org.example.doanki2.controller;


import jakarta.validation.Valid;
import org.example.doanki2.entity.Users;
import org.example.doanki2.model.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/v1/")
@CrossOrigin(origins = "http://localhost:3000")

public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<Users>> getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getByIdUser(@PathVariable Integer id){
        return userService.getByIdUser(id);
    }
    @PostMapping
    public ResponseEntity<Users> postUser(@RequestBody @Valid Users users){
        return userService.postUser(users);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Users> putUser(@PathVariable Integer id, @RequestBody Users users){
        return userService.putUsers(id, users);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Users> deleteUser (@PathVariable Integer id){
        return userService.deleteUser(id);
    }
}
