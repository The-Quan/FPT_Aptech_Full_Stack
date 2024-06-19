package org.example.doanki2.Controller;

import org.example.doanki2.Entity.Users;
import org.example.doanki2.Model.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/v1/")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<Users> getUser() {
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public Users getUserById(@PathVariable Integer id) {
        Users user = userService.getUserById(id);
        if (user == null || !id.equals(user.getUser_id())) {
            throw new IllegalArgumentException("id not match or user not found");
        }
        return user;
    }
    @PostMapping
    public Users postUser(@RequestBody Users user) {
        return userService.postUser(user);
    }
    @DeleteMapping("/{id}")
    public Users deleteUser(@PathVariable Integer id, @RequestBody Users user) {
        if (!id.equals(user.getUser_id())){
            throw new IllegalArgumentException("id not match");
        }
        return userService.deleteUser(id);
    }
    @PutMapping("/{id}")
    public Users updateUser(@PathVariable Integer id, @RequestBody Users user) {
        if (!id.equals(user.getUser_id())) {
            throw new IllegalArgumentException("user ID in path and in body do not match");
        }
        return userService.updateUser(user);
    }
}
