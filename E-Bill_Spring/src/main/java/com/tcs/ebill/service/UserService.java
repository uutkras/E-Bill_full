package com.tcs.ebill.service;

import com.tcs.ebill.dto.UserRegistrationDto;
import com.tcs.ebill.entity.User;
import com.tcs.ebill.entity.UserRole;
import com.tcs.ebill.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    
    public User registerUser(UserRegistrationDto registrationDto) {
        if (userRepository.existsByUserId(registrationDto.getUserId())) {
            throw new RuntimeException("User ID already exists");
        }
        if (userRepository.existsByEmail(registrationDto.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();
        user.setUserId(registrationDto.getUserId());
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        user.setConsumerId(registrationDto.getConsumerId());
        user.setCustomerName(registrationDto.getCustomerName());
        user.setEmail(registrationDto.getEmail());
        user.setCountryCode(registrationDto.getCountryCode());
        user.setMobile(registrationDto.getMobile());
        user.setRole(UserRole.CUSTOMER);
        user.setRegisteredAt(LocalDateTime.now());

        return userRepository.save(user);
    }

    public User findByUserId(String userId) {
        return userRepository.findByUserId(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));
    }
} 