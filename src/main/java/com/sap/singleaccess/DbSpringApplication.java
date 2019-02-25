package com.sap.singleaccess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan

@SpringBootApplication(
	       exclude = {org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration.class})
public class DbSpringApplication extends SpringBootServletInitializer{

	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
	    {
	        return application.sources(DbSpringApplication.class);
	    }
	 
	public static void main(String[] args) {
		SpringApplication.run(DbSpringApplication.class, args);
	}

}
