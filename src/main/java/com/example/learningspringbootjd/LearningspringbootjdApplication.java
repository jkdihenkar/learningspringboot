package com.example.learningspringbootjd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan({"com/jdcomponents"})
@EnableAutoConfiguration
@EnableScheduling
public class LearningspringbootjdApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningspringbootjdApplication.class, args);
	}
}
