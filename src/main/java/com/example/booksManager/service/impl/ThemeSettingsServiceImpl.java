package com.example.booksManager.service.impl;

import com.example.booksManager.dto.themeSettings.ThemeSettingsRequestDto;
import com.example.booksManager.dto.themeSettings.ThemeSettingsResponseDto;
import com.example.booksManager.entity.ThemeSettings;
import com.example.booksManager.exception.WebException;
import com.example.booksManager.mapper.ThemeSettingsMapper;
import com.example.booksManager.repository.ThemeSettingsRepository;
import com.example.booksManager.service.ThemeSettingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ThemeSettingsServiceImpl implements ThemeSettingsService {
    private final ThemeSettingsMapper themeSettingsMapper;
    private final ThemeSettingsRepository themeSettingsRepository;

    @Override
    public ThemeSettingsResponseDto save(ThemeSettingsRequestDto request) {
        ThemeSettings entity = themeSettingsMapper.toEntity(request);
        return themeSettingsMapper.toResponseDto(themeSettingsRepository.save(entity));
    }

    @Override
    public List<ThemeSettingsResponseDto> findAll() {
        return themeSettingsRepository.findAll()
                .stream()
                .map(themeSettingsMapper::toResponseDto)
                .toList();
    }

    @Override
    public ThemeSettingsResponseDto findById(Long id) {
        ThemeSettings entity = getExistingEntityById(id);
        return themeSettingsMapper.toResponseDto(themeSettingsRepository.save(entity));
    }

    @Override
    public ThemeSettingsResponseDto update(Long id, ThemeSettingsRequestDto request) {
        ThemeSettings entity = getExistingEntityById(id);
        themeSettingsMapper.updateEntity(request, entity);
        themeSettingsRepository.save(entity);
        return themeSettingsMapper.toResponseDto(entity);
    }

    @Override
    public void remove(Long id) {
        ThemeSettings entity = getExistingEntityById(id);
        themeSettingsRepository.delete(entity);
    }

    private ThemeSettings getExistingEntityById(Long id) {
        return themeSettingsRepository.findById(id)
                .orElseThrow(() -> new WebException(HttpStatus.NOT_FOUND, "ThemeSettings not found"));
    }
}
