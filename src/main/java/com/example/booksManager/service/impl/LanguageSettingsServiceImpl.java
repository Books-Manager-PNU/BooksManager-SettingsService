package com.example.booksManager.service.impl;

import com.example.booksManager.dto.languageSettings.LanguageSettingsRequestDto;
import com.example.booksManager.dto.languageSettings.LanguageSettingsResponseDto;
import com.example.booksManager.entity.LanguageSettings;
import com.example.booksManager.exception.WebException;
import com.example.booksManager.mapper.LanguageSettingsMapper;
import com.example.booksManager.repository.LanguageSettingsRepository;
import com.example.booksManager.service.LanguageSettingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LanguageSettingsServiceImpl implements LanguageSettingsService {
    private final LanguageSettingsMapper languageSettingsMapper;
    private final LanguageSettingsRepository languageSettingsRepository;

    @Override
    public LanguageSettingsResponseDto save(LanguageSettingsRequestDto request) {
        LanguageSettings entity = languageSettingsMapper.toEntity(request);
        return languageSettingsMapper.toResponseDto(languageSettingsRepository.save(entity));
    }

    @Override
    public List<LanguageSettingsResponseDto> findAll() {
        return languageSettingsRepository.findAll()
                .stream()
                .map(languageSettingsMapper::toResponseDto)
                .toList();
    }

    @Override
    public LanguageSettingsResponseDto findById(Long id) {
        LanguageSettings entity = getExistingEntityById(id);
        return languageSettingsMapper.toResponseDto(languageSettingsRepository.save(entity));
    }

    @Override
    public LanguageSettingsResponseDto update(Long id, LanguageSettingsRequestDto request) {
        LanguageSettings entity = getExistingEntityById(id);
        languageSettingsMapper.updateEntity(request, entity);
        languageSettingsRepository.save(entity);
        return languageSettingsMapper.toResponseDto(entity);
    }

    @Override
    public void remove(Long id) {
        LanguageSettings entity = getExistingEntityById(id);
        languageSettingsRepository.delete(entity);
    }

    private LanguageSettings getExistingEntityById(Long id) {
        return languageSettingsRepository.findById(id)
                .orElseThrow(() -> new WebException(HttpStatus.NOT_FOUND, "LanguageSettings not found"));
    }
}
