package com.example.booksManager.controller;

import com.example.booksManager.dto.themeSettings.ThemeSettingsRequestDto;
import com.example.booksManager.dto.themeSettings.ThemeSettingsResponseDto;
import com.example.booksManager.service.ThemeSettingsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/theme-settings")
public class ThemeSettingsController {
    private final ThemeSettingsService themeSettingsService;

    @PostMapping
    public ResponseEntity<ThemeSettingsResponseDto> add(
            @Valid @RequestBody ThemeSettingsRequestDto requestDto
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(themeSettingsService.save(requestDto));
    }

    @GetMapping
    public ResponseEntity<List<ThemeSettingsResponseDto>> getAll() {
        return ResponseEntity.ok(themeSettingsService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ThemeSettingsResponseDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(themeSettingsService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ThemeSettingsResponseDto> update(
            @PathVariable Long id,
            @Valid @RequestBody ThemeSettingsRequestDto requestDto
    ) {
        return ResponseEntity.accepted()
                .body(themeSettingsService.update(id, requestDto));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        themeSettingsService.remove(id);
        return ResponseEntity.noContent().build();
    }
}

