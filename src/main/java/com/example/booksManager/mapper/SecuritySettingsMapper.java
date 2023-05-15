package com.example.booksManager.mapper;

import com.example.booksManager.dto.securitySettings.SecuritySettingsRequestDto;
import com.example.booksManager.dto.securitySettings.SecuritySettingsResponseDto;
import com.example.booksManager.entity.SecuritySettings;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface SecuritySettingsMapper {
    SecuritySettingsResponseDto toResponseDto(SecuritySettings settings);
    SecuritySettings toEntity(SecuritySettingsRequestDto requestDto);

    @Mapping(target = "id", ignore = true)
    void updateEntity(SecuritySettingsRequestDto requestDto, @MappingTarget SecuritySettings settings);
}
