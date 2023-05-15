package com.example.booksManager.repository;

import com.example.booksManager.entity.ThemeSettings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThemeSettingsRepository extends JpaRepository<ThemeSettings, Long> {
}
