package com.pocspringboot.demo.services;

import com.pocspringboot.demo.model.Producto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private static Logger logger = LoggerFactory.getLogger(OrderService.class);

        public void saveOrder(List<Producto> productos) {
            System.out.println("Guardando en la base de datos");
            productos.forEach(producto -> {logger.debug("El nombre del producto: {}", producto.nombre);});
        }
}
