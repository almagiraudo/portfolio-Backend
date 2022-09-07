package com.portfolioalmagiraudo.ap.Service;

import com.portfolioalmagiraudo.ap.Entity.Experiencia_laboral;
import com.portfolioalmagiraudo.ap.Interface.IExperiencia_laboralService;
import com.portfolioalmagiraudo.ap.Repository.IExperiencia_laboralRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpExperiencia_laboralService implements IExperiencia_laboralService {

    @Autowired
    IExperiencia_laboralRepository iexperiencia_laboralRepository;

    @Override
    public List<Experiencia_laboral> getExperiencia_laboral() {
        List<Experiencia_laboral> experiencia_laboral = iexperiencia_laboralRepository.findAll();
        return experiencia_laboral;
    }

    @Override
    public void saveExperiencia_laboral(Experiencia_laboral experiencia_laboral) {
        iexperiencia_laboralRepository.save(experiencia_laboral);
    }

    @Override
    public void deleteExperiencia_laboral(Long id) {
        iexperiencia_laboralRepository.deleteById(id);
    }

    @Override
    public Experiencia_laboral findExperiencia_laboral(Long id) {
        Experiencia_laboral experiencia_laboral = iexperiencia_laboralRepository.findById(id).orElse(null);
        return experiencia_laboral;
    }
}
