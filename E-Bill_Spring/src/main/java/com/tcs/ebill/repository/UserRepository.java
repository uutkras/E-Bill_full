package com.tcs.ebill.repository;

import com.tcs.ebill.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserId(String userId);
    Optional<User> findByEmail(String email);
    Optional<User> findByConsumerId(String consumerId);
    boolean existsByUserId(String userId);
    boolean existsByEmail(String email);
} 