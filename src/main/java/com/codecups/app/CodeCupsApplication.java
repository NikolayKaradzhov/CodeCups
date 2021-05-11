package com.codecups.app;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Copyright CodeCups
 * Created by Niko on 14 April 2021
 */

@SpringBootApplication
@EnableEncryptableProperties
public class CodeCupsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeCupsApplication.class, args);
	}
}
