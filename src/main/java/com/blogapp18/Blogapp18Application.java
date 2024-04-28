package com.blogapp18;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Blogapp18Application {

	public static void main(String[] args) {
		SpringApplication.run(Blogapp18Application.class, args);
	}



	@Bean
	public ModelMapper getModelMapper(){
		return  new  ModelMapper();
	}

}
