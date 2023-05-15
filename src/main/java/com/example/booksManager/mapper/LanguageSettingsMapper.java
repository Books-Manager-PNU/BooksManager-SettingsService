package com.example.booksManager.mapper;

import com.example.booksManager.dto.languageSettings.LanguageSettingsRequestDto;
import com.example.booksManager.dto.languageSettings.LanguageSettingsResponseDto;
import com.example.booksManager.entity.LanguageSettings;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface LanguageSettingsMapper {
    LanguageSettingsResponseDto toResponseDto(LanguageSettings settings);
    LanguageSettings toEntity(LanguageSettingsRequestDto requestDto);

    @Mapping(target = "id", ignore = true)
    void updateEntity(LanguageSettingsRequestDto forumCommentRequest, @MappingTarget LanguageSettings settings);
}
