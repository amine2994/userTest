package com.supra.test.repository;

import com.supra.test.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for User entity.
 * Extends JpaRepository to provide CRUD operations.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}

