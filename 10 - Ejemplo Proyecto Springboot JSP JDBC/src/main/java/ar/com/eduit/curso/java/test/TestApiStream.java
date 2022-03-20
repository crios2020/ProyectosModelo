package ar.com.eduit.curso.java.test;

import ar.com.eduit.curso.java.connectors.Connector;
import ar.com.eduit.curso.java.entities.Alumno;
import ar.com.eduit.curso.java.entities.Curso;
import ar.com.eduit.curso.java.enums.Dia;
import ar.com.eduit.curso.java.enums.Turno;
import ar.com.eduit.curso.java.repositories.interfaces.I_AlumnoRepository;
import ar.com.eduit.curso.java.repositories.interfaces.I_CursoRepository;
import ar.com.eduit.curso.java.repositories.jdbc.AlumnoRepository;
import ar.com.eduit.curso.java.repositories.jdbc.CursoRepository;
import java.sql.Connection;
import java.util.Comparator;

public class TestApiStream {
    public static void main(String[] args) {
        try (Connection conn=Connector.getConnection()){
            I_AlumnoRepository ar=new AlumnoRepository(conn);
            I_CursoRepository cr=new CursoRepository(conn);
            
            ar.save(new Alumno("Cecilia","Oviedo",39,1));
            
            System.out.println("************************************************");
            ar.getAll().stream().sorted(Comparator.comparing(Alumno::getApellido)).forEach(System.out::println);
            System.out.println("************************************************");
            cr.getAll().stream().sorted(Comparator.comparing(Curso::getTitulo)).forEach(System.out::println);
            System.out.println("************************************************");
            
                        
            System.out.println("************************************************");
            ar
                    .getAll()
                    .stream()
                    .sorted(Comparator.comparing(Alumno::getApellido)
                            .thenComparing(Alumno::getNombre))
                    .forEach(System.out::println);
            System.out.println("************************************************");
            cr
                    .getAll()
                    .stream()
                    .sorted(Comparator.comparing(Curso::getTitulo).reversed())
                    .forEach(System.out::println);
            System.out.println("************************************************");
            
                        System.out.println("************************************************");
            ar
                    .getAll()
                    .stream()
                    .sorted()
                    .forEach(System.out::println);
            System.out.println("************************************************");
            cr
                    .getAll()
                    .stream()
                    .sorted()
                    .forEach(System.out::println);
            System.out.println("************************************************");
            
            System.out.println("Cantidad de Alumnos: "+ar.getAll().stream().count());
            System.out.println("Cantidad de Cursos: "+cr.getAll().stream().count());
            
            int edadMaxima=ar.getAll().stream().max(Comparator.comparingInt(Alumno::getEdad)).get().getEdad();
            System.out.println("Edad Máxima: "+edadMaxima);
            
            ar.getAll().stream().filter(a->a.getEdad()==edadMaxima).forEach(System.out::println);
            
            System.out.println("************************************************");
            System.out.println("Cursos de los días Lunes");
            cr.getAll().stream().filter(c->c.getDia()==Dia.LUNES).forEach(System.out::println);
            
            System.out.println("************************************************");
            System.out.println("Cursos de los días Lunes Mañana");
            cr.getAll().stream().filter(c->c.getDia()==Dia.LUNES && c.getTurno()==Turno.MAÑANA).forEach(System.out::println);
            
            System.out.println("************************************************");
            System.out.println("Curso id 5: "+cr.getAll().stream().filter(c->c.getId()==5).findFirst().orElse(null));
            
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
