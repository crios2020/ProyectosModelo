package com.example.mavenspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MavenSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MavenSpringbootApplication.class, args);
		System.out.println("Hola Mundo Maven SpringBoot!!");

		/*
			Este proyecto contiene mvn-wraper instalado - no es necesario instalar maven
			para ejecutar desde windows usar el comando de consola mvnw.cmd
			para ejecutar desde linux o mac usar mvnw

			ejemplo desde linux sh mvnw spring-boot:run

			importante spring-boot, no es el artifact-id de este proyecto, es el plugin que inicia este proyecto
		*/
	}

}
