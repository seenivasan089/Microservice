package com.question.question;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
 
@SpringBootApplication//(exclude={DataSourceAutoConfiguration.class})
@ComponentScan({"com.question.question","com.question.question.service", "com.question.question.dao", "com.question.question.data"})
//@EntityScan("com.question.question.data")
@EnableJpaRepositories
@FeignClient(name="QUESTION")
public class QuestionApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuestionApplication.class, args);
	}

}
