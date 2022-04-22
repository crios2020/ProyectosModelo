package com.example.demothymeleaf.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demothymeleaf.enums.Dia;
import com.example.demothymeleaf.enums.Turno;

@Entity
@Table(name="cursos")
public class Curso implements Comparable<Curso>{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;
    private String titulo;
    private String profesor;
    @Enumerated(value = EnumType.STRING)
    private Dia dia;
    @Enumerated(value = EnumType.STRING)
    private Turno turno;

    public Curso() {
    }

    public Curso(String titulo, String profesor, Dia dia, Turno turno) {
        this.titulo = titulo;
        this.profesor = profesor;
        this.dia = dia;
        this.turno = turno;
    }

    public Curso(int id, String titulo, String profesor, Dia dia, Turno turno) {
        this.id = id;
        this.titulo = titulo;
        this.profesor = profesor;
        this.dia = dia;
        this.turno = turno;
    }

    @Override
    public String toString() {
        return id + ", " + titulo + ", " + profesor + ", " + dia + ", " + turno;
    }

    @Override
    public int compareTo(Curso para) {
        String thisCurso = this.getTitulo()+","+this.getProfesor()+","+this.getDia()+","+this.getTurno();
        String paraCurso = para.getTitulo()+","+para.getProfesor()+","+para.getDia()+","+para.getTurno();
        return thisCurso.compareTo(paraCurso);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public Dia getDia() {
        return dia;
    }

    public void setDia(Dia dia) {
        this.dia = dia;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }
   
}
