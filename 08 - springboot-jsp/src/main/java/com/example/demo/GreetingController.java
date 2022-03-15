package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GreetingController{

	@RequestMapping("/mensaje")
	public String mensaje(){
		return "mensaje";
	}
}
