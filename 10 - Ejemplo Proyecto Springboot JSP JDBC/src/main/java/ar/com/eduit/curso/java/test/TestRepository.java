package ar.com.eduit.curso.java.test;

import ar.com.eduit.curso.java.connectors.Connector;
import ar.com.eduit.curso.java.entities.Curso;
import ar.com.eduit.curso.java.enums.Dia;
import ar.com.eduit.curso.java.enums.Turno;
import ar.com.eduit.curso.java.repositories.interfaces.I_AlumnoRepository;
import ar.com.eduit.curso.java.repositories.interfaces.I_CursoRepository;
import ar.com.eduit.curso.java.repositories.jdbc.AlumnoRepository;
import ar.com.eduit.curso.java.repositories.jdbc.CursoRepository;
import java.sql.Connection;

public class TestRepository {
    public static void main(String[] args) {
        try (Connection conn=Connector.getConnection()){
            I_CursoRepository cr=new CursoRepository(conn);
            Curso curso=new Curso("javascript", "Mendoza", Dia.LUNES, Turno.NOCHE);
            cr.save(curso);
            System.out.println(curso);
            cr.remove(cr.getById(4));
            curso=cr.getById(5);
            curso.setProfesor("Hernandez");
            //cr.update(curso);
            System.out.println("************************************************");
            cr.getAll().forEach(System.out::println);
            System.out.println("************************************************");
            cr.getLikeTitulo("ja").forEach(System.out::println);
            
            I_AlumnoRepository ar=new AlumnoRepository(conn);
            
            System.out.println("************************************************");
            ar.getAll().forEach(System.out::println);
            System.out.println("************************************************");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
