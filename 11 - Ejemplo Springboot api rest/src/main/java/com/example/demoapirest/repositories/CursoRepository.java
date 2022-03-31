package com.example.demoapirest.repositories;

import com.example.demoapirest.models.Curso;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends CrudRepository<Curso, Integer>{
    
}
