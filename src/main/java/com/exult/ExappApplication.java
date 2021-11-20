package com.exult;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import com.exult.api.PatientAPI;

@SpringBootApplication
public class ExappApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExappApplication.class, args);
	}

}
