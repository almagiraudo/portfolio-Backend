package com.portfolioalmagiraudo.ap.Controller;

import com.portfolioalmagiraudo.ap.Interface.IProyectosService;
import com.portfolioalmagiraudo.ap.entity.Proyectos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProyectosController {

    @Autowired
    IProyectosService iproyectosService;
    @GetMapping("proyectos/traer")
    public List<Proyectos> getProyectos() {
        return iproyectosService.getProyectos();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/proyectos/crear")
    public String createProyectos(@RequestBody Proyectos proyectos) {
        iproyectosService.saveProyectos(proyectos);
        return "El proyecto fue creado correctamente";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/proyectos/borrar/{id}")
    public String deleteProyectos(@PathVariable Long id) {
        iproyectosService.deleteProyectos(id);
        return "El proyecto fue eliminado correctamente";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/proyectos/editar/{id}")
    public Proyectos editProyectos(@PathVariable Long id,
            @RequestParam("nombre") String nuevoNombre,
            @RequestParam("descripcion") String nuevoDescripcion,
            @RequestParam("img") String nuevoImg) {
        Proyectos proyectos = iproyectosService.findProyectos(id);
        proyectos.setNombre(nuevoNombre);
        proyectos.setDescripcion(nuevoDescripcion);
        proyectos.setImg(nuevoImg);
        iproyectosService.saveProyectos(proyectos);
        return proyectos;
    }

    @GetMapping("proyectos/traer/proyecto")
    public Proyectos findProyectos() {
        return iproyectosService.findProyectos((long) 1);
    }
}
