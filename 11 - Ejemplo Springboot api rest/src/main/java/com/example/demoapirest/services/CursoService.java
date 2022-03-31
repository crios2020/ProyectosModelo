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

    public void delete(Integer id){
        cursoRepository.delete(cursoRepository.findById(id).get());
    }

    public List<Curso>getAll(){
        return (List<Curso>)cursoRepository.findAll();
    }

    public Curso getById(Integer id){
        return cursoRepository.findById(id).get();
    }

    public List<Curso>getByTitulo(String titulo){
        return cursoRepository.findByTitulo(titulo);
    }

    public List<Curso>getLikeTitulo(String titulo){
        return cursoRepository.findByTituloContainingIgnoreCase(titulo);
    }

}
