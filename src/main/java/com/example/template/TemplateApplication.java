package com.example.template;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.template.repo.TemplateRepository;


@SpringBootApplication(exclude = {MongoAutoConfiguration.class})
public class TemplateApplication extends SpringBootServletInitializer {
	@Override  
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application)   
	{  
	return application.sources(TemplateApplication.class);  
	}  

	public static void main(String[] args) {
		SpringApplication.run(TemplateApplication.class, args);
	}

}
