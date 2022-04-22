package com.example.demothymeleaf.repositories;
import java.util.List;

import com.example.demothymeleaf.models.Alumno;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends CrudRepository<Alumno, Integer>{
        //La implementación de la query es automatica en el autowired
        public abstract List<Alumno>findByApellido(String apellido);

        //@Query("select c from alumnos c where c.apellido like  %?1%")
        public abstract List<Alumno>findByApellidoContainingIgnoreCase(String apellido);
    

        /*

            Diferencias entre extender desde CrudRepository o JpaRepository
            https://www.geeksforgeeks.org/spring-boot-difference-between-crudrepository-and-jparepository/

            formas de escribir las queries en el nombre del método
            https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation

        */

        
}
