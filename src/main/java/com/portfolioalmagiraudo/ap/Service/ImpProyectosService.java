package com.portfolioalmagiraudo.ap.Service;


import com.portfolioalmagiraudo.ap.Interface.IProyectosService;
import com.portfolioalmagiraudo.ap.Repository.IProyectosRepository;
import com.portfolioalmagiraudo.ap.Security.Dto.dtoProyectos;
import com.portfolioalmagiraudo.ap.entity.Proyectos;
import java.util.List;
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

    @Override
    public void crearProyectos(dtoProyectos proy) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editarProyecto(Long id, dtoProyectos datosProy) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

