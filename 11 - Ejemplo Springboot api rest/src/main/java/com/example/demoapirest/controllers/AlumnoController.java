package com.example.demoapirest.controllers;

import java.util.List;

import com.example.demoapirest.models.Alumno;
import com.example.demoapirest.repositories.CursoRepository;
import com.example.demoapirest.services.AlumnoService;
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
@RequestMapping("/alumnos")
public class AlumnoController {
    
    @Autowired
    private AlumnoService alumnoService;

    @Autowired
    private CursoService cursoService;

    @GetMapping()
    public String info(){
        return "Servicio alumnos Activo";
    }

    @GetMapping("/all")
    public List<Alumno>getAll(){
        return alumnoService.getAll();
    }

    @GetMapping("/byId")
    public Alumno getById(@RequestParam("id") Integer id){
        return alumnoService.getById(id);
    }

    @GetMapping("/byApellido")
    public List<Alumno>getByApellido(@RequestParam("apellido") String apellido){
        return alumnoService.getByApellido(apellido);
    }

    @GetMapping("/likeApellido")
    public List<Alumno>getLikeApellido(@RequestParam("apellido") String apellido){
        return alumnoService.getLikeApellido(apellido);
    }

    //@PostMapping
    @GetMapping("/alta")
    public int guardar( @RequestParam("nombre") String nombre, @RequestParam("apellido") String apellido, 
                        @RequestParam("edad") Integer edad, @RequestParam("idCurso") Integer idCurso){

        //Los parametros son obligatorios, si no se ingresan parámetros, devuelve error 404                    
        Alumno alumno=new Alumno(
            nombre,
            apellido,
            edad,
            idCurso
        );
        System.out.println("***************************************************");
        System.out.println(alumno);
        System.out.println("***************************************************");
        alumnoService.save(alumno);
        return alumno.getId();
    }

    @DeleteMapping("/borrar")
    public boolean borrar(@RequestParam("id") Integer id){
        // @DeleteMapping solo bajo método Delete
        alumnoService.delete(id);
        return true;
    }
}
