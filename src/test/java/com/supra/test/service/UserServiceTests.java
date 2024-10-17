package com.supra.test.service;

import com.supra.test.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserService userService;

    @Test
    public void testValidUserRegistration() {
        User user = new User("Toto", 30, "France");
        User registeredUser = userService.registerUser(user);
        Assertions.assertNotNull(registeredUser.getId());
    }

    @Test
    public void testUnderageUserRegistration() {
        User user = new User("Titi", 17, "Tunisie");
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> userService.registerUser(user));
        Assertions.assertEquals("Only adults (age > 18) living in France can register.", exception.getMessage());
    }
}
