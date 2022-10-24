package com.portfolioalmagiraudo.ap.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import com.portfolioalmagiraudo.ap.Entity.Persona;
import com.portfolioalmagiraudo.ap.Security.Controller.Mensaje;
import com.portfolioalmagiraudo.ap.Service.ImpPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = "https://almagiraudo-portfolio-frontend.web.app")
public class PersonaController {
    @Autowired
    ImpPersonaService imppersonaService;
    
    @GetMapping("/list")
    public List<Persona> getPersona() {
        return imppersonaService.getPersona();
    }

    
    @PostMapping("/create")
    public String createPersona(@RequestBody Persona persona) {
        imppersonaService.savePersona(persona);
        return "La persona fue creada correctamente";
    }

    
    @DeleteMapping("/delete/{id}")
    public String deletePersona(@PathVariable Long id) {
        imppersonaService.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }

    
    @PutMapping("/update/{id}")
    public Persona editPersona(@PathVariable("id")Long id,
            @RequestBody Persona persona) {
         persona.setId(id);
        imppersonaService.savePersona(persona);
        return persona;
    }

   @GetMapping(("/detail/{id}"))
    public ResponseEntity<Persona> getById(@PathVariable("id")long id){
        if(!imppersonaService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.BAD_REQUEST);
        }
        Persona persona = imppersonaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
}
