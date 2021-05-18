package com.codecups.app.repository;

import com.codecups.app.model.User;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Copyright CodeCups
 * Created by Niko on 15 April 2021
 */

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByUserId(String id);
}
