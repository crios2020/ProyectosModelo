package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GreetingController{

	/*
		Solo es necesario agregar en el pom.xlm la dependencia tomcat-embed-jasper
		No es necesario ninguna configuración extra!.
		Se puede borrar este archivo y application.properties
	*/

	//Este RequestMapping no es necesario. solo evita que llamar al archivo jsp sin poner la extensión .jsp
	//Es Nesesario configurar archivo application.properties
	@RequestMapping("/mensaje")
	public String mensaje(){
		return "mensaje";
	}

	@RequestMapping("/welcome")
	public String welcome(){
		return "welcome";
	}
}
