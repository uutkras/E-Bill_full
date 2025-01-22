package com.tcs.ebill.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponseDto {
    private String userId;
    private String role;
    private String token;
} 