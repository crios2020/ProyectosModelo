package com.example.demothymeleaf.test;

import com.example.demothymeleaf.enums.Dia;
import com.example.demothymeleaf.enums.Turno;
import com.example.demothymeleaf.models.Alumno;
import com.example.demothymeleaf.models.Curso;
import com.example.demothymeleaf.services.AlumnoService;
import com.example.demothymeleaf.services.CursoService;

import org.springframework.beans.factory.annotation.Autowired;


public class TestServices {
    public static void main(String[] args) {
        
        CursoService cursoService=new CursoService();
        AlumnoService alumnoService = new AlumnoService();

        Curso curso=new Curso("Java","Jerez",Dia.LUNES,Turno.MAÑANA);
        Alumno alumno=new Alumno("Geronimo","Garcia",23,1);

        cursoService.save(curso);
        alumnoService.save(alumno);

        System.out.println(curso);
        System.out.println(alumno);


    }
}
