package com.pocspringboot.demo.model;

public class Libro {

    String nombre, editorial;

    public Libro(String nombre, String editorial) {
        this.nombre = nombre;
        this.editorial = editorial;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEditorial() {
        return editorial;
    }
}
