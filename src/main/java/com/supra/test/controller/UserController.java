package com.supra.test.controller;

import com.supra.test.model.User;
import com.supra.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller that provides endpoints for registering and retrieving user details.
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Endpoint to register a new user via JSON request body.
     *
     * @param user the user object sent in the request body
     * @return the registered user, or an error message if the registration fails
     */
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        try {
            if (user.getPhoneNumber() == null || user.getPhoneNumber().isEmpty()) {
                user.setPhoneNumber("Not Provided");
            }
            return ResponseEntity.ok(userService.registerUser(user));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * Endpoint to retrieve details of a registered user by their ID.
     *
     * @param id the ID of the user
     * @return the user details, or an error message if the user is not found
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserDetails(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userService.getUserDetails(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

