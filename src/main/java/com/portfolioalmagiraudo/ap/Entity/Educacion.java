package com.portfolioalmagiraudo.ap.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud")
    private String descripcionE;

    @Size(min = 1, max = 50, message = "No cumple con la longitud")
    private String nombreE;
//Constructor

    public Educacion() {
    }
    
    public Educacion(String descripcionE, String nombreE) {
        this.descripcionE = descripcionE;
        this.nombreE = nombreE;
    }
//Getters & Setters
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcionE() {
        return descripcionE;
    }
    public void setDescripcionE(String descripcionEs) {
        this.descripcionE = descripcionEs;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreEs) {
        this.nombreE = nombreEs;
    }
}
