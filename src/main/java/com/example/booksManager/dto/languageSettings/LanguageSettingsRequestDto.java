package com.example.booksManager.dto.languageSettings;

import jakarta.validation.constraints.NotBlank;

public record LanguageSettingsRequestDto(
        @NotBlank(message = "Language name cannot be empty")
        String languageName,
        @NotBlank(message = "User ID cannot be empty")
        Long userId
) {
}
