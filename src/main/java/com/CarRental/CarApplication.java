package com.CarRental;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class CarApplication {
	//One way
//	@Bean
//	ModelMapper modelMapper(){return  new ModelMapper();}

	public static void main(String[] args) {
		SpringApplication.run(CarApplication.class, args);
	}




}
