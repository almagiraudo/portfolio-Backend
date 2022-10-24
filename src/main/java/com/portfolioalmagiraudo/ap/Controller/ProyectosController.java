package com.portfolioalmagiraudo.ap.Controller;

import com.portfolioalmagiraudo.ap.Security.Controller.Mensaje;
import com.portfolioalmagiraudo.ap.Service.ImpProyectosService;
import com.portfolioalmagiraudo.ap.entity.Proyectos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proyectos")
@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "https://almagiraudo-portfolio-frontend.web.app")
public class ProyectosController {

    @Autowired
    ImpProyectosService impproyectosService;
    @GetMapping("/list")
    public List<Proyectos> getProyectos() {
        return impproyectosService.getProyectos();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public String createProyectos(@RequestBody Proyectos proyectos) {
        impproyectosService.saveProyectos(proyectos);
        return "El proyecto fue creado correctamente";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public String deleteProyectos(@PathVariable Long id) {
        impproyectosService.deleteProyectos(id);
        return "El proyecto fue eliminado correctamente";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public Proyectos editProyectos(@PathVariable Long id,
            @RequestBody Proyectos proyectos){
        proyectos.setId(id);
        impproyectosService.saveProyectos(proyectos);
        return proyectos;
    }

    @GetMapping(("/detail/{id}"))
    public ResponseEntity<Proyectos> getById(@PathVariable("id")long id){
        if(!impproyectosService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.BAD_REQUEST);
        }
        Proyectos proyectos = impproyectosService.getOne(id).get();
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }
}
