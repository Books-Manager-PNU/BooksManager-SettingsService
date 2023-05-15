package com.example.booksManager.dto.themeSettings;

public record ThemeSettingsResponseDto(
        Long id,
        String themeName,
        Long userId
) {
}
