package com.example.demoapirest.controllers;

import java.util.List;

import com.example.demoapirest.enums.Dia;
import com.example.demoapirest.enums.Turno;
import com.example.demoapirest.models.Curso;
import com.example.demoapirest.services.CursoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @GetMapping()
    public String info(){
        return "Servicio Cursos Activo";
    }

    @GetMapping("/all")
    public List<Curso>getAll(){
        return cursoService.getAll();
    }

    @GetMapping("/byId")
    public Curso getById(@RequestParam("id") Integer id){
        return cursoService.getById(id);
    }

    @GetMapping("/byTitulo")
    public List<Curso>getByTitulo(@RequestParam("titulo") String titulo){
        return cursoService.getByTitulo(titulo);
    }

    @GetMapping("/likeTitulo")
    public List<Curso>getLikeTitulo(@RequestParam("titulo") String titulo){
        return cursoService.getLikeTitulo(titulo);
    }

    //@PostMapping
    @GetMapping("/alta")
    public int guardar( @RequestParam("titulo") String titulo, @RequestParam("profesor") String profesor, 
                        @RequestParam("dia") String dia, @RequestParam("turno") String turno){

        //Los parametros son obligatorios, si no se ingresan parámetros, devuelve error 404                    
        Curso curso=new Curso(
            titulo,
            profesor,
            Dia.valueOf(dia.toUpperCase()),
            Turno.valueOf(turno.toUpperCase())
        );
        cursoService.save(curso);
        return curso.getId();
    }

    @PostMapping("/alta2")
    public int guardar(@RequestBody Curso curso){

        /*
            Para enviar parametros por body, en postman cambie el método a POST
            luego solapa body y opcion raw tipo json, e ingrese:
            {    
                "titulo":"PHP",
                "profesor":"Sosa",
                "dia":"LUNES",
                "turno":"NOCHE"   
            }


            Ingresando un id existente se realiza un update
            {    
                "id":"5",
                "titulo":"PHP",
                "profesor":"Suarez",
                "dia":"LUNES",
                "turno":"NOCHE"   
            }
        */

        cursoService.save(curso);
        return curso.getId();
    }

    @DeleteMapping("/borrar")
    public boolean borrar(@RequestParam("id") Integer id){
        // @DeleteMapping solo bajo método Delete
        cursoService.delete(id);
        return true;
    }

}
