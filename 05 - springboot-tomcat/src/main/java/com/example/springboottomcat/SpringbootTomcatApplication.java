package com.example.springboottomcat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
public class SpringbootTomcatApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootTomcatApplication.class, args);
		System.out.println("Hola Mundo Springboot"); 	//Esto sale impreso en la consola del server
		/*
			Este proyecto contiene mvn-wraper instalado - no es necesario instalar maven
			para ejecutar desde windows usar el comando de consola mvnw.cmd
			para ejecutar desde linux o mac usar mvnw

			ejemplo desde linux sh mvnw spring-boot:run

			importante spring-boot, no es el artifact-id de este proyecto, es el plugin que inicia este proyecto

			desde el browser ingresar al raiz del server http://localhost:8080/

			Hola.Java ubica un servicio spring-rest en el raiz del server

			Ctrol - C en la terminal para detener el server

			La Clase Hola contiene un ejemplo de una API Rest

		*/
	}

}
