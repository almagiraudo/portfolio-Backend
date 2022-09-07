package com.portfolioalmagiraudo.ap.Service;

import com.portfolioalmagiraudo.ap.Entity.Educacion;
import com.portfolioalmagiraudo.ap.Repository.IEducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class ImpEducacionService {

    @Autowired
    IEducacionRepository ieducacionRepository;

    public List<Educacion> getEducacion() {
        List<Educacion> educacion = ieducacionRepository.findAll();
        return educacion;
    }

    public void saveEducacion(Educacion educacion) {
        ieducacionRepository.save(educacion);
    }

    public void deleteEducacion(Long id) {
        ieducacionRepository.deleteById(id);
    }

    public Educacion findEducacion(Long id) {
        Educacion educacion = ieducacionRepository.findById(id).orElse(null);
        return educacion;
    }
}
