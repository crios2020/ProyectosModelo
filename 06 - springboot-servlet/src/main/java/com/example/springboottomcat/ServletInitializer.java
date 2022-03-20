package com.example.springboottomcat;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringbootTomcatApplication.class);


		/*
			Este proyecto contiene mvn-wraper instalado - no es necesario instalar maven
			para ejecutar desde windows usar el comando de consola mvnw.cmd
			para ejecutar desde linux o mac usar mvnw

			ejemplo desde linux sh mvnw spring-boot:run

			importante spring-boot, no es el artifact-id de este proyecto, es el plugin que inicia este proyecto

			desde el browser ingresar al raiz del server http://localhost:8080/

			Hola.Java ubica un servicio spring-rest en el raiz del server

			Ctrol - C en la terminal para detener el server

			
			En algunas versiones de windows, fue necesario configurar las variables de entorno JAVA_HOME y JRE_HOME
			https://www.tecnicomo.com/windows/como-configurar-las-variables-de-entorno-java_home-y-jre_home-en-windows-10/
		*/
	}

}
