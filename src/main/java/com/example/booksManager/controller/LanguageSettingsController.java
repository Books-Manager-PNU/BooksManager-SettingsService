package com.example.booksManager.controller;

import com.example.booksManager.dto.languageSettings.LanguageSettingsRequestDto;
import com.example.booksManager.dto.languageSettings.LanguageSettingsResponseDto;
import com.example.booksManager.service.LanguageSettingsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/language-settings")
public class LanguageSettingsController {
    private final LanguageSettingsService languageSettingsService;

    @PostMapping
    public ResponseEntity<LanguageSettingsResponseDto> add(
            @Valid @RequestBody LanguageSettingsRequestDto requestDto
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(languageSettingsService.save(requestDto));
    }

    @GetMapping
    public ResponseEntity<List<LanguageSettingsResponseDto>> getAll() {
        return ResponseEntity.ok(languageSettingsService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LanguageSettingsResponseDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(languageSettingsService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LanguageSettingsResponseDto> update(
            @PathVariable Long id,
            @Valid @RequestBody LanguageSettingsRequestDto requestDto
    ) {
        return ResponseEntity.accepted()
                .body(languageSettingsService.update(id, requestDto));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        languageSettingsService.remove(id);
        return ResponseEntity.noContent().build();
    }
}

