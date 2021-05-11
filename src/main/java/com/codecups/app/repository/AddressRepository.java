package com.codecups.app.repository;

import com.codecups.app.model.Address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Copyright CodeCups
 * Created by Niko on 15 April 2021
 */

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
