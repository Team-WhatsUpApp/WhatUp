package com.whatsup;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import com.whatsup.models.Location;
import com.whatsup.models.User;
import com.whatsup.models.Vendor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
<<<<<<< HEAD
=======
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
>>>>>>> master
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


<<<<<<< HEAD
=======
/*
>>>>>>> master
@Configuration
@ComponentScan
@EnableJpaRepositories
@EnableAutoConfiguration
<<<<<<< HEAD
@PropertySource("application.properties")
=======
*/
//@PropertySource("application.properties")
>>>>>>> master
@SpringBootApplication
public class WhatsUpApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(WhatsUpApplication.class, args);
	}

    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WhatsUpApplication.class);
    }
}
