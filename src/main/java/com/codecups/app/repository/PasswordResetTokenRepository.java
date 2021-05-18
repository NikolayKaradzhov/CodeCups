package com.codecups.app.repository;

import com.codecups.app.model.PasswordResetToken;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Copyright CodeCups
 * Created by Niko on 16 May 2021
 */

@Repository
public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {
}
