package com.tcs.ebill.dto;

import lombok.Data;

@Data
public class UserRegistrationDto {
    private String userId;
    private String password;
    private String consumerId;
    private String customerName;
    private String email;
    private String countryCode;
    private String mobile;
} 