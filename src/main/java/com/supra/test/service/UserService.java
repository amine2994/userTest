package com.supra.test.service;

import com.supra.test.model.User;
import com.supra.test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service layer that handles business logic related to user registration and retrieval.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Registers a new user in the system.
     * Validates that the user is an adult and resides in France.
     *
     * @param user the user to be registered
     * @return the registered user
     * @throws IllegalArgumentException if the user does not meet the age or residency requirements
     */
    public User registerUser(User user) {
        // Validate age > 18 and country is France
        if (user.getAge() < 18 || !"France".equalsIgnoreCase(user.getCountry())) {
            throw new IllegalArgumentException("Only adults (age > 18) living in France can register.");
        }
        return userRepository.save(user);
    }

    /**
     * Retrieves a user's details by their ID.
     *
     * @param id the ID of the user
     * @return the user details
     * @throws IllegalArgumentException if the user is not found
     */
    public User getUserDetails(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
    }
}

