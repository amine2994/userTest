package com.supra.test.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    /**
     * Primary key of the user.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Name of the user (required).
     */
    @Column(nullable = false)
    private String name;

    /**
     * Age of the user (required).
     */
    @Column(nullable = false)
    private int age;

    /**
     * Country where the user resides (required).
     */
    @Column(nullable = false)
    private String country;

    /**
     * Phone number of the user (not required).
     */
    @Column(nullable = true) // Make phone optional
    private String phoneNumber = "Not Provided"; // Default value


    /**
     * Custom constructor for test class (Lombok will not overwrite this)
     */
    public User(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
        this.phoneNumber = "Not Provided"; // Default phone number if not provided
    }
}

