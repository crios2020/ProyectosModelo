package com.example.demothymeleaf;

import java.util.List;

import com.example.demothymeleaf.enums.Dia;
import com.example.demothymeleaf.enums.Turno;
import com.example.demothymeleaf.models.Curso;
import com.example.demothymeleaf.services.CursoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControllerWeb{

	@Autowired
	private CursoService cursoService;


	@GetMapping("/main")
	public String greeting(Model model){
		return "main";
	}

	@GetMapping("/cursos")
	public String cursos(Model model){
		model.addAttribute("dias", List.of(Dia.values()));
		model.addAttribute("turnos", List.of(Turno.values()));
		model.addAttribute("all", cursoService.getAll());
		model.addAttribute("curso", new Curso());
		return "cursos";
	}

	@GetMapping("/alumnos")
	public String alumnos(Model model){
		return "alumnos";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute Curso curso, Model model){
		
		System.out.println("*************************************************************************");
		System.out.println(curso);
		System.out.println("*************************************************************************");
		cursoService.save(curso);
		return "redirect:cursos";
	}
	
}
