package com.codecups.app;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Copyright CodeCups
 * Created by Niko on 14 April 2021
 */

@SpringBootApplication
@EnableEncryptableProperties
@EnableAsync
public class CodeCupsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeCupsApplication.class, args);
	}
}
