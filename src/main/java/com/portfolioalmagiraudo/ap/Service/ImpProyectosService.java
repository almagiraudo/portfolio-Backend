package com.portfolioalmagiraudo.ap.Service;


import com.portfolioalmagiraudo.ap.Interface.IProyectosService;
import com.portfolioalmagiraudo.ap.Repository.IProyectosRepository;
import com.portfolioalmagiraudo.ap.entity.Proyectos;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpProyectosService implements IProyectosService{
      @Autowired IProyectosRepository iproyectosRepository;
    
      @Override
    public List<Proyectos> getProyectos() {
    List<Proyectos> proyectos = iproyectosRepository.findAll();
    return proyectos;
    }

    
      @Override
    public void saveProyectos(Proyectos proyectos) {
        iproyectosRepository.save(proyectos);
    }

    
      @Override
    public void deleteProyectos(Long id) {
        iproyectosRepository.deleteById(id);
    }

    
      @Override
    public Proyectos findProyectos(Long id) {
          Proyectos proyectos = iproyectosRepository.findById(id).orElse(null);
          return proyectos;
    }
    
     public boolean existsById(Long id) {
        return iproyectosRepository.existsById(id);
    }
    public Optional<Proyectos> getOne(long id){
        return iproyectosRepository.findById(id);
    }
}

