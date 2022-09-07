
package com.portfolioalmagiraudo.ap.Interface;

import com.portfolioalmagiraudo.ap.Entity.Experiencia_laboral;
import java.util.List;

public interface IExperiencia_laboralService {
     //Traer Lista de Experiencia_laboral  
    public List<Experiencia_laboral> getExperiencia_laboral();
    
    //Guardar un Objeto de tipo Experiencia_laboral
    public void saveExperiencia_laboral(Experiencia_laboral experiencia_laboral);
    
    //Eliminar un objeto buscado por Id
    public void deleteExperiencia_laboral(Long id);
    
    //Buscar una EExperiencia_laboral
    public Experiencia_laboral findExperiencia_laboral(Long id);
    
}
