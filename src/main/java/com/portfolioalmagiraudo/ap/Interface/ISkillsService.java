package com.portfolioalmagiraudo.ap.Interface;

import com.portfolioalmagiraudo.ap.Entity.Skills;
import java.util.List;

public interface ISkillsService {
 //Traer Lista de Skills  
    public List<Skills> getSkills();
    
  //Guardar un Objeto de tipo Skills
    public void saveSkills(Skills skills);
    
    //Eliminar un objeto buscado por Id
    public void deleteSkills(Long id);
    
    //Buscar un Skill
    public Skills findSkills(Long id);    
}
