package com.portfolioalmagiraudo.ap.Controller;

import com.portfolioalmagiraudo.ap.Entity.Tipo_empleo;
import com.portfolioalmagiraudo.ap.Interface.ITipo_empleoService;

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
public class Tipo_empleoController {

    @Autowired
    ITipo_empleoService itipo_empleoService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("tipo_empleo/traer")
    public List<Tipo_empleo> getTipo_empleo() {
        return itipo_empleoService.getTipo_empleo();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/tipo_empleo/crear")
    public String createTipo_empleo(@RequestBody Tipo_empleo tipo_empleo) {
        itipo_empleoService.saveTipo_empleo(tipo_empleo);
        return "El tipo de empleo fue creado correctamente";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/tipo_empleo/borrar/{id}")
    public String deleteTipo_empleo(@PathVariable Long id) {
        itipo_empleoService.deleteTipo_empleo(id);
        return "El tipo de empleo fue eliminado correctamente";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/tipo_empleo/editar/{id}")
    public Tipo_empleo editTipo_empleo(@PathVariable Long id,
            @RequestParam("tipo") String nuevoTipo){
        Tipo_empleo tipo_empleo = itipo_empleoService.findTipo_empleo(id);
        tipo_empleo.setTipo(nuevoTipo);
        return tipo_empleo;
    }

    @GetMapping("tipo_empleo/traer/tipo")
    public Tipo_empleo findTipo_empleo() {
        return itipo_empleoService.findTipo_empleo((long) 1);
    }
}
