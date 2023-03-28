package com.example.spirngword;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpirngwordApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpirngwordApplication.class, args);
	}

}
