package com.example.booksManager.dto.securitySettings;

public record SecuritySettingsResponseDto(
        Long id,
        boolean twoFactorAuthentication,
        Long userId
) {
}
