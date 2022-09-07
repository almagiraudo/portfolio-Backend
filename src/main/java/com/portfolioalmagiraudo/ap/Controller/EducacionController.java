
package com.portfolioalmagiraudo.ap.Controller;

import com.portfolioalmagiraudo.ap.Entity.Educacion;
import com.portfolioalmagiraudo.ap.Interface.IEducacionService;
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
@CrossOrigin (origins = "http://localhost:4200")
public class EducacionController {
  @Autowired IEducacionService ieducacionService;
  @GetMapping("educacion/traer")
  public List<Educacion> getEducacion(){
      return ieducacionService.getEducacion();
  }
  
 @PreAuthorize("hasRole('ADMIN')") 
 @PostMapping("/educacion/crear")
  public String createEducacion(@RequestBody Educacion educacion){
   ieducacionService.saveEducacion(educacion);
    return "La educacion fue creada correctamente";
  }
 
 @PreAuthorize("hasRole('ADMIN')") 
 @DeleteMapping("/educacion/borrar/{id}")
 public String deleteEducacion(@PathVariable Long id){
     ieducacionService.deleteEducacion(id);
     return "La educacion fue eliminada correctamente";
 }
 
 @PreAuthorize("hasRole('ADMIN')") 
 @PutMapping("/educacion/editar/{id}")
 public Educacion editEducacion(@PathVariable Long id, 
                            @RequestParam("descripcion")String nuevoDescripcion,
                            @RequestParam("fechaInicio")String nuevoFechaInicio,
                            @RequestParam("fechaFin")String nuevoFechaFin){
    Educacion educacion = ieducacionService.findEducacion(id);
     educacion.setDescripcion(nuevoDescripcion);
     educacion.setFechaInicio(nuevoFechaInicio);
     educacion.setFechaFin(nuevoFechaFin);
     ieducacionService.saveEducacion(educacion);
     return educacion;
 }
 @GetMapping("educacion/traer")
    public Educacion findEducacion(){
        return ieducacionService.findEducacion((long)1);
    }
}


