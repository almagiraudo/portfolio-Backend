
package com.portfolioalmagiraudo.ap.Interface;


import com.portfolioalmagiraudo.ap.Security.Dto.dtoProyectos;
import com.portfolioalmagiraudo.ap.entity.Proyectos;
import java.util.List;

public interface IProyectosService {
    //Crear un Proyecto
    public void crearProyectos(dtoProyectos proy);
    
    //Editar un Proyecto
    public void editarProyecto(Long id, dtoProyectos datosProy );
    
     //Traer Lista de Proyectos  
    public List<Proyectos> getProyectos();
    
    //Guardar un Objeto de tipo Proyectos
    public void saveProyectos(Proyectos proyectos);
    
    //Eliminar un objeto buscado por Id
    public void deleteProyectos(Long id);
    
    //Buscar un Proyectos
    public Proyectos findProyectos(Long id);
}
