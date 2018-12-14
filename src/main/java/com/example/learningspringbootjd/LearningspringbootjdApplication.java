package com.example.learningspringbootjd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"simplecontrollers"})
@EnableAutoConfiguration
public class LearningspringbootjdApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningspringbootjdApplication.class, args);
	}
}
