package com.portfolioalmagiraudo.ap.Controller;


import com.portfolioalmagiraudo.ap.Entity.Experiencia_laboral;
import com.portfolioalmagiraudo.ap.Interface.IExperiencia_laboralService;
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
public class Experiencia_laboralController {

    @Autowired
    IExperiencia_laboralService iexperiencia_laboralService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("experiencia_laboral/traer")
    public List<Experiencia_laboral> getExperiencia_laboral() {
        return iexperiencia_laboralService.getExperiencia_laboral();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/experiencia_laboral/crear")
    public String createExperiencia_laboral(@RequestBody Experiencia_laboral experiencia_laboral) {
        iexperiencia_laboralService.saveExperiencia_laboral(experiencia_laboral);
        return "La experiencia laboral fue creada correctamente";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/experiencia_laboral/borrar/{id}")
    public String deleteExperiencia_laboral(@PathVariable Long id) {
        iexperiencia_laboralService.deleteExperiencia_laboral(id);
        return "La experiencia laboral fue eliminada correctamente";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/experiencia_laboral/editar/{id}")
    public Experiencia_laboral editExperiencia_laboral(@PathVariable Long id,
            @RequestParam("descripcion") String nuevoDescripcion,
            @RequestParam("fechaInicio") String nuevoFechaInicio,
            @RequestParam("fechaFin") String nuevoFechaFin) {
        Experiencia_laboral experiencia_laboral = iexperiencia_laboralService
                .findExperiencia_laboral(id);
        experiencia_laboral.setDescripcion(nuevoDescripcion);
        experiencia_laboral.setFechaInicio(nuevoFechaInicio);
        experiencia_laboral.setFechaFin(nuevoFechaFin);
        iexperiencia_laboralService.saveExperiencia_laboral(experiencia_laboral);
        return experiencia_laboral;
    }

    @GetMapping("experiencia_laboral/traer")
    public Experiencia_laboral findExperiencia_laboral() {
        return iexperiencia_laboralService.findExperiencia_laboral((long) 1);
    }
}


