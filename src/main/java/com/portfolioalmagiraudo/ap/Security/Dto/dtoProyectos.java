
package com.portfolioalmagiraudo.ap.Security.Dto;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class dtoProyectos {
    private Long id;
    private String descripcion;
    private String img;
    private String nombre;

    public dtoProyectos() {
    }

    public dtoProyectos(String descripcion, String img, String nombre) {
        this.descripcion = descripcion;
        this.img = img;
        this.nombre = nombre;
    }
    
    
}
