package com.example.booksManager.dto.themeSettings;

import jakarta.validation.constraints.NotBlank;

public record ThemeSettingsRequestDto(
        @NotBlank(message = "Theme name cannot be empty")
        String themeName,
        @NotBlank(message = "User ID cannot be empty")
        Long userId
) {
}
