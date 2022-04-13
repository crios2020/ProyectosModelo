package com.example.demoapirest.services;

import java.util.List;

import com.example.demoapirest.models.Alumno;
import com.example.demoapirest.repositories.AlumnoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnoService {
    @Autowired
    private AlumnoRepository alumnoRepository;

    public void save(Alumno alumno){
        alumnoRepository.save(alumno);
    }

    public void delete(Integer id){
        alumnoRepository.delete(alumnoRepository.findById(id).get());
    }

    public List<Alumno>getAll(){
        return (List<Alumno>)alumnoRepository.findAll();
    }

    public Alumno getById(Integer id){
        return alumnoRepository.findById(id).get();
    }

    public List<Alumno>getByApellido(String apellido){
        return alumnoRepository.findByApellido(apellido);
    }

    public List<Alumno>getLikeApellido(String apellido){
        return alumnoRepository.findByApellidoContainingIgnoreCase(apellido);
    }
}
