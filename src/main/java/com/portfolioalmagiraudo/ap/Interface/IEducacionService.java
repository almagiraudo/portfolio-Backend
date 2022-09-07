package com.portfolioalmagiraudo.ap.Interface;

import com.portfolioalmagiraudo.ap.Entity.Educacion;
import java.util.List;


public interface IEducacionService {
    //Traer Lista de Educacion  
    public List<Educacion> getEducacion();
    
    //Guardar un Objeto de tipo Educacion
    public void saveEducacion(Educacion educacion);
    
    //Eliminar un objeto buscado por Id
    public void deleteEducacion(Long id);
    
    //Buscar una Educacion
    public Educacion findEducacion(Long id);
}
