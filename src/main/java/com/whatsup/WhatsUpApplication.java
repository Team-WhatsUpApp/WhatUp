package com.whatsup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


/*
@Configuration
@ComponentScan
@EnableJpaRepositories
@EnableAutoConfiguration
*/
//@PropertySource("application.properties")
@SpringBootApplication
public class WhatsUpApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(WhatsUpApplication.class, args);
	}

    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WhatsUpApplication.class);
    }
}
