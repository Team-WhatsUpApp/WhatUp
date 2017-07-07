package com.whatsup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@ComponentScan
@EnableJpaRepositories
@EnableAutoConfiguration
@PropertySource("application.properties")
@SpringBootApplication
public class WhatsUpApplication {

	public static void main(String[] args) {
		SpringApplication.run(WhatsUpApplication.class, args);
	}
}
