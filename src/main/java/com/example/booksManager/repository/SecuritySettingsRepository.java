package com.example.booksManager.repository;

import com.example.booksManager.entity.SecuritySettings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecuritySettingsRepository extends JpaRepository<SecuritySettings, Long> {
}
