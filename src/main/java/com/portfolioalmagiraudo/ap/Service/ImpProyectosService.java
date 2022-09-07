package com.portfolioalmagiraudo.ap.Service;


import com.portfolioalmagiraudo.ap.Interface.IProyectosService;
import com.portfolioalmagiraudo.ap.Repository.IProyectosRepository;
import com.portfolioalmagiraudo.ap.entity.Proyectos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpProyectosService implements IProyectosService{
      @Autowired IProyectosRepository iproyectosRepository;
    
    public List<Proyectos> getProyectos() {
    List<Proyectos> proyectos = iproyectosRepository.findAll();
    return proyectos;
    }

    
    public void saveProyectos(Proyectos proyectos) {
        iproyectosRepository.save(proyectos);
    }

    
    public void deleteProyectos(Long id) {
        iproyectosRepository.deleteById(id);
    }

    
    public Proyectos findProyectos(Long id) {
          Proyectos proyectos = iproyectosRepository.findById(id).orElse(null);
          return proyectos;
    }
}

