
package com.portfolioalmagiraudo.ap.Security.Controller;


public class Mensaje {
     private String mensaje;    

     //Constuctor

    public Mensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Mensaje() {
    }
     //GEtters and Setters

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
