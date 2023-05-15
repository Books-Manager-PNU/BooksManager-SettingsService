package com.example.booksManager.dto.securitySettings;

import jakarta.validation.constraints.NotBlank;

public record SecuritySettingsRequestDto(
        @NotBlank(message = "Two-Factor Authentication cannot be empty")
        boolean twoFactorAuthentication,
        @NotBlank(message = "User ID cannot be empty")
        Long userId
) {
}
