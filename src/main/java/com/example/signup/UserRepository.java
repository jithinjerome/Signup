package com.example.signup;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users , Long> {
    Optional<Users> findByEmailAndPassword(String email, String password);
}
