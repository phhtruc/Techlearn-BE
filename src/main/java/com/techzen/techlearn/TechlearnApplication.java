package com.techzen.techlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TechlearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechlearnApplication.class, args);
	}

}
