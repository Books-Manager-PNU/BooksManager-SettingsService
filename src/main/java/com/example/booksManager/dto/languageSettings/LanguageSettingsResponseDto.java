package com.example.booksManager.dto.languageSettings;

public record LanguageSettingsResponseDto(
        Long id,
        String languageName,
        Long userId
) {
}
