package com.example.booksManager.controller;

import com.example.booksManager.dto.securitySettings.SecuritySettingsRequestDto;
import com.example.booksManager.dto.securitySettings.SecuritySettingsResponseDto;
import com.example.booksManager.service.SecuritySettingsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/security-settings")
public class SecuritySettingsController {
    private final SecuritySettingsService securitySettingsService;

    @PostMapping
    public ResponseEntity<SecuritySettingsResponseDto> add(
            @Valid @RequestBody SecuritySettingsRequestDto requestDto
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(securitySettingsService.save(requestDto));
    }

    @GetMapping
    public ResponseEntity<List<SecuritySettingsResponseDto>> getAll() {
        return ResponseEntity.ok(securitySettingsService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SecuritySettingsResponseDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(securitySettingsService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SecuritySettingsResponseDto> update(
            @PathVariable Long id,
            @Valid @RequestBody SecuritySettingsRequestDto requestDto
    ) {
        return ResponseEntity.accepted()
                .body(securitySettingsService.update(id, requestDto));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        securitySettingsService.remove(id);
        return ResponseEntity.noContent().build();
    }
}

