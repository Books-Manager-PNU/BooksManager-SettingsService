package com.example.booksManager.service.impl;

import com.example.booksManager.dto.securitySettings.SecuritySettingsRequestDto;
import com.example.booksManager.dto.securitySettings.SecuritySettingsResponseDto;
import com.example.booksManager.entity.SecuritySettings;
import com.example.booksManager.exception.WebException;
import com.example.booksManager.mapper.SecuritySettingsMapper;
import com.example.booksManager.repository.SecuritySettingsRepository;
import com.example.booksManager.service.SecuritySettingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SecuritySettingsServiceImpl implements SecuritySettingsService {
    private final SecuritySettingsMapper languageSettingsMapper;
    private final SecuritySettingsRepository languageSettingsRepository;

    @Override
    public SecuritySettingsResponseDto save(SecuritySettingsRequestDto request) {
        SecuritySettings entity = languageSettingsMapper.toEntity(request);
        return languageSettingsMapper.toResponseDto(languageSettingsRepository.save(entity));
    }

    @Override
    public List<SecuritySettingsResponseDto> findAll() {
        return languageSettingsRepository.findAll()
                .stream()
                .map(languageSettingsMapper::toResponseDto)
                .toList();
    }

    @Override
    public SecuritySettingsResponseDto findById(Long id) {
        SecuritySettings entity = getExistingEntityById(id);
        return languageSettingsMapper.toResponseDto(languageSettingsRepository.save(entity));
    }

    @Override
    public SecuritySettingsResponseDto update(Long id, SecuritySettingsRequestDto request) {
        SecuritySettings entity = getExistingEntityById(id);
        languageSettingsMapper.updateEntity(request, entity);
        languageSettingsRepository.save(entity);
        return languageSettingsMapper.toResponseDto(entity);
    }

    @Override
    public void remove(Long id) {
        SecuritySettings entity = getExistingEntityById(id);
        languageSettingsRepository.delete(entity);
    }

    private SecuritySettings getExistingEntityById(Long id) {
        return languageSettingsRepository.findById(id)
                .orElseThrow(() -> new WebException(HttpStatus.NOT_FOUND, "SecuritySettings not found"));
    }
}
