package com.example.demoapirest.controllers;

import java.util.List;

import com.example.demoapirest.enums.Dia;
import com.example.demoapirest.enums.Turno;
import com.example.demoapirest.models.Curso;
import com.example.demoapirest.services.CursoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @GetMapping
    public List<Curso>all(){
        return cursoService.getAll();
    }

    //@PostMapping
    // @GetMapping
    // public int guardar(@RequestBody String titulo, @RequestBody String profesor, @RequestBody String dia, @RequestBody String turno){
    //     Curso curso=new Curso(
    //         titulo,
    //         profesor,
    //         Dia.valueOf(dia),
    //         Turno.valueOf(turno)
    //     );
    //     cursoService.save(curso);
    //     return curso.getId();
    // }
}
