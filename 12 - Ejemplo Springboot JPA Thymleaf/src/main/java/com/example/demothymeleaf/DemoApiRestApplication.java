package com.example.demothymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApiRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApiRestApplication.class, args);
		//Se agrego en el POM la dependencia al driver de base de datos 
		//   y a spring-boot-starter-data-jpa.
	}

}
