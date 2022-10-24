  package com.portfolioalmagiraudo.ap.Service;

import com.portfolioalmagiraudo.ap.Entity.Experiencia_laboral;
import com.portfolioalmagiraudo.ap.Repository.IExperiencia_laboralRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class ImpExperiencia_laboralService {

    @Autowired
    IExperiencia_laboralRepository iexperiencia_laboralRepository;

    public List<Experiencia_laboral> list() {
     return iexperiencia_laboralRepository.findAll();
    }
    
    public Optional<Experiencia_laboral> getOne(long id){
        return iexperiencia_laboralRepository.findById(id);
    }
    
    public Optional<Experiencia_laboral> getByNombreEx(String nombreEx){
        return iexperiencia_laboralRepository.findByNombreEx(nombreEx);
    }

    public void save(Experiencia_laboral expe) {
        iexperiencia_laboralRepository.save(expe);
    }

    public void delete(Long id) {
        iexperiencia_laboralRepository.deleteById(id);
    }

    public boolean  existById(long id){
        return iexperiencia_laboralRepository.existsById(id);
    }
    
    public boolean  existsByNombreEx(String nombreEx){
        return iexperiencia_laboralRepository.existsByNombreEx(nombreEx);
    }
    
}
