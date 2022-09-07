
package com.portfolioalmagiraudo.ap.Service;

import com.portfolioalmagiraudo.ap.Entity.Tipo_empleo;
import com.portfolioalmagiraudo.ap.Interface.ITipo_empleoService;
import com.portfolioalmagiraudo.ap.Repository.ITipo_empleoRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpTipo_empleoService implements ITipo_empleoService{
     @Autowired ITipo_empleoRepository itipo_empleoRepository;
    
    public List<Tipo_empleo> getTipo_empleo() {
    List<Tipo_empleo> tipo_empleo = itipo_empleoRepository.findAll();
    return tipo_empleo;
    }

    
    public void saveTipo_empleo(Tipo_empleo tipo_empleo) {
        itipo_empleoRepository.save(tipo_empleo);
    }

    
    public void deleteTipo_empleo(Long id) {
        itipo_empleoRepository.deleteById(id);
    }

    
    public Tipo_empleo findTipo_empleo(Long id) {
          Tipo_empleo tipo_empleo = itipo_empleoRepository.findById(id).orElse(null);
          return tipo_empleo;
    }
}
