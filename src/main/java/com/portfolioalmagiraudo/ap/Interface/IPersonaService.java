package com.portfolioalmagiraudo.ap.Interface;
 
import java.util.List;
import com.portfolioalmagiraudo.ap.Entity.Persona;

public interface IPersonaService {
  //Traer Lista de Personas  
    public List<Persona> getPersona();
    
  //Guardar un Objeto de tipo Persona
    public void savePersona(Persona persona);
    
    //Eliminar un objeto buscado por Id
    public void deletePersona(Long id);
    
    //Buscar una persona
    public Persona findPersona(Long id);
}