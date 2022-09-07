
package com.portfolioalmagiraudo.ap.Interface;


import com.portfolioalmagiraudo.ap.Entity.Tipo_empleo;
import java.util.List;

public interface ITipo_empleoService {
       //Traer Lista de Tipo_empleo  
    public List<Tipo_empleo> getTipo_empleo();
    
    //Guardar un Objeto de tipo Tipo_empleo
    public void saveTipo_empleo(Tipo_empleo tipo_empleo);
    
    //Eliminar un objeto buscado por Id
    public void deleteTipo_empleo(Long id);
    
    //Buscar una Tipo_empleo
    public Tipo_empleo findTipo_empleo(Long id);
}
