package com.example.redisproj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RedisprojApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisprojApplication.class, args);
	}

}
