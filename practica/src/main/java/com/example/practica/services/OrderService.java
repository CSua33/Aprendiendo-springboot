package com.example.practica.services;

import com.example.practica.PracticaApplication;
import com.example.practica.models.Producto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class OrderService {
    private Logger logger = LoggerFactory.getLogger(OrderService.class);
    public void saveOrder(List<Producto> productos){
        System.out.println("Guardando en la base de datos");
        productos.forEach(producto ->
                logger.info("El nombre del producto: {} El precio es: {}", producto.nombre, producto.precio));

    }
}
