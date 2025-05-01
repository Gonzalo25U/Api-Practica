package com.apirestpractica.miapi.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api")
public class ReseñaController {
    @GetMapping("/productos/{productoId}/reseñas")
    public String listarReseñasProducto(
        @PathVariable long productoId,
        @RequestParam(defaultValue = "1") int calificacionMin,
        @RequestParam(defaultValue = "5") int calificacionMax,
        @RequestParam(defaultValue = "false") boolean mostrarVerificados
    ) {
        return "Reseñas del producto ID: "+ productoId +
                ", con calificacion entre " + calificacionMin +
                " y " + calificacionMax +(mostrarVerificados ? ", mostrando solo reseñas verificadas" : ",mostrando todas las reseñas");
    }
    
}
