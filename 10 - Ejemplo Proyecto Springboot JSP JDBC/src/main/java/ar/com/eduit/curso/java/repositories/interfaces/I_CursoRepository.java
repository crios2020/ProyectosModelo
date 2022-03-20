package ar.com.eduit.curso.java.repositories.interfaces;

import ar.com.eduit.curso.java.entities.Curso;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface I_CursoRepository {
    void save(Curso curso);
    void remove(Curso curso);
    void update(Curso curso);
    default Curso getById(int id){
        return getAll()
                .stream()
                .filter(c->c.getId()==id)
                .findFirst()
                .orElse(new Curso());
    }
    List<Curso>getAll();
    default List<Curso>getLikeTitulo(String titulo){
        
        // select * from cursos where titulo like '%titulo%'
        
        //List<Curso>list=new ArrayList();
        //if(titulo==null) return list;
        //for(Curso c:getAll()){
        //    if(c.getTitulo()!=null && c.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
        //        list.add(c);
        //}
        //return list;
        
        //Api Stream
        if(titulo==null) return new ArrayList();
        return getAll()
                .stream()
                .filter(c->c.getTitulo()!=null && c.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
                .collect(Collectors.toList());       
    }
    default List<Curso>getLikeProfesor(String profesor){
        if(profesor==null) return new ArrayList();
        return getAll()
                .stream()
                .filter(c->c.getProfesor()!=null && c.getProfesor().toLowerCase().contains(profesor.toLowerCase()))
                .collect(Collectors.toList());
    }
}
