package com.example.demo11.repository;

import com.example.demo11.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    Optional<User> findByEmail(String emailId);
    Optional<User> findByPassword(String password);
}
