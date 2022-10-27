
package com.portfolioalmagiraudo.ap.Service;

import com.portfolioalmagiraudo.ap.Entity.Skills;
import com.portfolioalmagiraudo.ap.Repository.ISkillsRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpSkillsService  {
    @Autowired
        ISkillsRepository iskillsRepository;
    public List<Skills> list(){
        return iskillsRepository.findAll();
    }
    
    public Optional<Skills> getOne(long id){
        return iskillsRepository.findById(id);
    }
    
    public Optional<Skills> getByNombre(String nombre){
        return iskillsRepository.findByNombre(nombre);
    }
    
    public void save(Skills skills){
        iskillsRepository.save(skills);
    }
    
    public void delete(long id){
        iskillsRepository.deleteById(id);
    }
    
    public boolean existsById(long id){
        return iskillsRepository.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return iskillsRepository.existsByNombre(nombre);
    }
    
}
