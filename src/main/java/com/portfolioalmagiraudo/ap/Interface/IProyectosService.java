
package com.portfolioalmagiraudo.ap.Interface;


import com.portfolioalmagiraudo.ap.entity.Proyectos;
import java.util.List;

public interface IProyectosService {
     //Traer Lista de Proyectos  
    public List<Proyectos> getProyectos();
    
    //Guardar un Objeto de tipo Proyectos
    public void saveProyectos(Proyectos proyectos);
    
    //Eliminar un objeto buscado por Id
    public void deleteProyectos(Long id);
    
    //Buscar una Proyectos
    public Proyectos findProyectos(Long id);
}
