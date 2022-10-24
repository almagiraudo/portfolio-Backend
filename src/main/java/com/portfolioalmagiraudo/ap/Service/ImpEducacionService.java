package com.portfolioalmagiraudo.ap.Service;

import com.portfolioalmagiraudo.ap.Entity.Educacion;
import com.portfolioalmagiraudo.ap.Repository.IEducacionRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
@Transactional
public class ImpEducacionService {

    @Autowired
    IEducacionRepository iEducacionRepository;
    
    public List<Educacion> list() {
        return iEducacionRepository.findAll();  
    
    }
    
    public Optional<Educacion> getOne(long id){
        return iEducacionRepository.findById(id);
    }
    
    public Optional<Educacion>getByNombreE(String nombreE){
        return iEducacionRepository.findByNombreE(nombreE);
    }
    
    
    public void saveEducacion(Educacion educacion) {
        iEducacionRepository.save(educacion);
    }

    public void deleteEducacion(Long id) {
        iEducacionRepository.deleteById(id);
    }

    public boolean existById(Long id) {
        return iEducacionRepository.existsById(id);
    }

    public boolean existsByNombreE(String nombreE){
     return iEducacionRepository.existsByNombreE(nombreE);
    }

   
}
