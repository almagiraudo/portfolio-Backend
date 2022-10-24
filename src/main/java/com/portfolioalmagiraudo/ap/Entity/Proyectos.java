package com.portfolioalmagiraudo.ap.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Proyectos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud")
    private String descripcion;

    @Size(min = 1, max = 50, message = "No cumple con la longitud")
    private String img;

    @Size(min = 1, max = 50, message = "No cumple con la longitud")
    private String nombre;

    //Constuctores

    public Proyectos() {
    }

    public Proyectos(String descripcion, String img, String nombre) {
        this.descripcion = descripcion;
        this.img = img;
        this.nombre = nombre;
    }
    //Getters & Setters
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

}
