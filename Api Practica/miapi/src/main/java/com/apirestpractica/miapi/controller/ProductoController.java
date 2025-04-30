package com.apirestpractica.miapi.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;






@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    @GetMapping
    public String listaDeProductos() {
        return "Listando todos los productos";
    }
    @GetMapping("/{id}")
    public String obtenerProductos(@PathVariable long id) {
        return "Este es el producto con id " + id;
    }
    @GetMapping("/filtrar")
    public String filtrarProducto(
        @RequestParam(required=false) String categoria,
        @RequestParam(defaultValue = "0")double precioMin,
        @RequestParam(defaultValue = "10000")double precioMax) 
        {
        return "Filtrar Productos con: "+
                " Categoria = "+(categoria != null ? categoria : " todas ")+
                ", Precio minimo "+ precioMin +
                ", Precio maximo "+ precioMax;
    }
    
    @GetMapping("/buscar")
    public String buscarProductos(
        @RequestParam String termino,
        @RequestParam(defaultValue = "nombre") String ordenadoPor,
        @RequestParam(defaultValue = "asc")String orden,
        @RequestParam(defaultValue = "10") int limite
    ) {
        return "Busqueda de productos con: "+
                "termino = "+ termino + "'"+
                ", ordenados por = " + ordenadoPor+
                ", orden = "+ orden +
                ", limite de resultados = " + limite
                ;
    }
    
}
