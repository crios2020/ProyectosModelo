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
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerWeb{
	private String mensaje ="Ingrese un nuevo curso!";
	@Autowired
	private CursoService cursoService;

	@GetMapping("/main")
	public String greeting(Model model){
		return "main";
	}

	@GetMapping("/cursos")
	public String cursos(@RequestParam(name="buscarTitulo", required=false, defaultValue="") String buscarTitulo, Model model){
		model.addAttribute("dias", List.of(Dia.values()));
		model.addAttribute("turnos", List.of(Turno.values()));
		model.addAttribute("all", cursoService.getAll());
		model.addAttribute("curso", new Curso());
		model.addAttribute("likeTitulo", cursoService.getLikeTitulo(buscarTitulo));
		model.addAttribute("mensajeInfo", mensaje);
		//model.addAttribute("mensajeError", "");
		return "cursos";
	}

	@GetMapping("/alumnos")
	public String alumnos(Model model){
		return "alumnos";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute Curso curso){
		System.out.println("*************************************************************************");
		System.out.println(curso);
		System.out.println("*************************************************************************");
		try{
			cursoService.save(curso);
			mensaje="Se ingreso un nuevo curso id: "+curso.getId();
		}catch(Exception e){
			mensaje="Ocurrio un error!";
		}
		return "redirect:cursos";
	}
	
}
