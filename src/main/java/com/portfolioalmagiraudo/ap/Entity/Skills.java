package com.portfolioalmagiraudo.ap.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Skills {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud")
    private String nombre;

    @Size(min = 1, max = 50, message = "No cumple con la longitud")
    private String progreso;

    @Size(min = 1, max = 50, message = "No cumple con la longitud")
    private String img;

    //Constuctores

    public Skills() {
    }

    public Skills(String nombre, String progreso, String img) {
        this.nombre = nombre;
        this.progreso = progreso;
        this.img = img;
    }
    
    //Getters & Setters
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setProgreso(String progreso) {
        this.progreso = progreso;
    }

    public String getProgreso() {
        return progreso;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getImg() {
        return img;
    }

}
