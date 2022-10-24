package com.portfolioalmagiraudo.ap.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Experiencia_laboral {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud")
    private String descripcionEx;
    
    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud")
    private String nombreEx;

    
    //Constructores

    public Experiencia_laboral() {
    }

    public Experiencia_laboral(String descripcionEx, String nombreEx) {
        this.descripcionEx = descripcionEx;
        this.nombreEx = nombreEx;
    }

   //Getters & Setters

    public void setNombreEx(String nombreEx) {
        this.nombreEx = nombreEx;
    }

    public String getNombreEx() {
        return nombreEx;
    }

    public String getDescripcionEx() {
        return descripcionEx;
    }

    public void setDescripcionEx(String descripcionEx) {
        this.descripcionEx = descripcionEx;
    }

     public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }

}
