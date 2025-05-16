package com.alexrsnchz.mobelia.controller;

import com.alexrsnchz.mobelia.model.User;
import com.alexrsnchz.mobelia.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAll();

        return ResponseEntity.ok(users);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getById(id);

        return ResponseEntity.ok(user);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User userToCreate = userService.create(user);

        return ResponseEntity.status(201).body(userToCreate);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@Valid @RequestBody User user, @PathVariable Long id) {
        User userToUpdate = userService.update(user, id);

        return ResponseEntity.ok(userToUpdate);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}
