package com.apex.coder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CoderApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoderApplication.class, args);
	}

}
