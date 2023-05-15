package com.example.booksManager.mapper;

import com.example.booksManager.dto.themeSettings.ThemeSettingsRequestDto;
import com.example.booksManager.dto.themeSettings.ThemeSettingsResponseDto;
import com.example.booksManager.entity.ThemeSettings;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ThemeSettingsMapper {
    ThemeSettingsResponseDto toResponseDto(ThemeSettings settings);
    ThemeSettings toEntity(ThemeSettingsRequestDto requestDto);

    @Mapping(target = "id", ignore = true)
    void updateEntity(ThemeSettingsRequestDto requestDto, @MappingTarget ThemeSettings settings);
}
