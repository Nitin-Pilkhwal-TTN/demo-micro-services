package com.question.questionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class QuestionserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuestionserviceApplication.class, args);
	}

}
