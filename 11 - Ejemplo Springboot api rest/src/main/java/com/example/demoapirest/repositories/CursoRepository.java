package com.example.demoapirest.repositories;

import java.util.List;

import com.example.demoapirest.models.Curso;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends CrudRepository<Curso, Integer>{
    
    //La implementación de la query es automatica en el autowired
    public abstract List<Curso>findByTitulo(String titulo);

    //@Query("select c from cursos c where c.titulo like  %?1%")
    public abstract List<Curso>findByTituloContainingIgnoreCase(String titulo);

    /*

        Diferencias entre extender desde CrudRepository o JpaRepository
        https://www.geeksforgeeks.org/spring-boot-difference-between-crudrepository-and-jparepository/

        formas de escribir las queries en el nombre del método
        https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation

    */


}
