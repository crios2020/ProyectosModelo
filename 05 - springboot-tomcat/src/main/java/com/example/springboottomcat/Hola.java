package com.example.springboottomcat;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@RestController
public class Hola {

    @RequestMapping(value = "/")
    public String hola(){
        return "Hola Mundo!";
    }

    @RequestMapping(value = "/saludar", method = RequestMethod.GET) //Ejemplo de seteo de metodo
    public String saludar(@RequestParam String nombre){ 
        //Ejemplo de metodos con parametros
        return "Hola "+nombre;
    }

    @RequestMapping(value = "/semana")
    @ResponseBody                               //@ResponseBody devuelve el resultado en JSon
    public List<String> semana(){
        List<String>list=List.of("Lunes","Martes","Miércoles","Jueves","Viernes","Sábado","Domingo");
        return list;
    }

    //El navegador logra renderizar pero la cabecera http es text/plain
    @RequestMapping(value = "/html")
    @Produces(MediaType.TEXT_HTML)              //Esta anotation no es leida aqui 
    public String html(){
        String html="<!DOCTYPE html>"+
                    "<html lang='es'>"+
                    "   <head>"+
                    "   <title>Primer Sitio</title>"+
                    "   </head>"+
                    "   <body>"+
                    "        <h1>Hola Mundo!</h1>"+
                    "   </body>"+
                    "</html>";
        return html;
    }
}
