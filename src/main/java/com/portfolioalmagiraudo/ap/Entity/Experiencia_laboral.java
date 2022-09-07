package com.portfolioalmagiraudo.ap.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class Experiencia_laboral {
       @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @NotNull
  @Size(min = 1, max = 50,message = "No cumple con la longitud")
  private String descripcion;
  
   
  @Size(min = 1, max = 50,message = "No cumple con la longitud")
  private String fechaInicio;
  
  @Size(min = 1, max = 50,message = "No cumple con la longitud")
  private String fechaFin;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }
  
}
