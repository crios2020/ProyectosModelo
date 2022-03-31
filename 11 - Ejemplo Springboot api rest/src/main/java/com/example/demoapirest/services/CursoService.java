package com.example.demoapirest.services;

import java.util.List;

import com.example.demoapirest.models.Curso;
import com.example.demoapirest.repositories.CursoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    public void save(Curso curso){
        cursoRepository.save(curso);
    }

    public List<Curso>getAll(){
        return (List<Curso>)cursoRepository.findAll();
    }
}
