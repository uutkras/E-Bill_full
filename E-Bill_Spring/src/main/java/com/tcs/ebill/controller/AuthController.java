package com.tcs.ebill.controller;

import com.tcs.ebill.dto.LoginRequestDto;
import com.tcs.ebill.dto.LoginResponseDto;
import com.tcs.ebill.dto.UserRegistrationDto;
import com.tcs.ebill.entity.User;
import com.tcs.ebill.service.UserService;
import com.tcs.ebill.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody UserRegistrationDto registrationDto) {
        User user = userService.registerUser(registrationDto);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto loginRequest) {
        try {
            User user = userService.findByUserId(loginRequest.getUserId());
            
            if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid credentials");
            }
            
            String token = jwtService.generateToken(user);
            
            return ResponseEntity.ok(LoginResponseDto.builder()
                .userId(user.getUserId())
                .role(user.getRole().name())
                .token(token)
                .build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body("Login failed: " + e.getMessage());
        }
    }
} 