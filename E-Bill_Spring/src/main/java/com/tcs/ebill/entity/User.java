package com.tcs.ebill.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String userId;

    @Column(nullable = false)
    private String password;

    @Column(unique = true)
    private String consumerId;

    private String customerName;

    @Column(unique = true)
    private String email;

    private String countryCode;
    private String mobile;
    private LocalDateTime registeredAt;

    @Enumerated(EnumType.STRING)
    private UserRole role;
} 