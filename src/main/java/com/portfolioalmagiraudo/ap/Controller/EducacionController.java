package com.portfolioalmagiraudo.ap.Controller;

import org.apache.commons.lang3.StringUtils;
import com.portfolioalmagiraudo.ap.Security.Dto.dtoEducacion;
import com.portfolioalmagiraudo.ap.Entity.Educacion;
import com.portfolioalmagiraudo.ap.Security.Controller.Mensaje;
import com.portfolioalmagiraudo.ap.Service.ImpEducacionService;
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
@RequestMapping("/educacion")
@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "https://almagiraudo-portfolio-frontend.web.app")
public class EducacionController {

    @Autowired
    ImpEducacionService impEducacionService;

    @GetMapping(("/list"))
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = impEducacionService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping(("/detail/{id}"))
    public ResponseEntity<Educacion> getById(@PathVariable("id")long id){
        if(!impEducacionService.existById(id)){
            return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.BAD_REQUEST);
        }
        Educacion educacion = impEducacionService.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")long id){
        if (!impEducacionService.existById(id)){
            return new ResponseEntity(new Mensaje("No existe el id"),HttpStatus.NOT_FOUND);
        }
        impEducacionService.deleteEducacion(id);
        return new ResponseEntity(new Mensaje("Fue borrado correctamente."), HttpStatus.OK);
    }
    
    
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoeducacion){
        if(StringUtils.isBlank(dtoeducacion.getNombreE())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (impEducacionService.existsByNombreE(dtoeducacion.getNombreE())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        Educacion educacion = new Educacion(
        dtoeducacion.getNombreE(), dtoeducacion.getDescripcionE()
        );
        impEducacionService.saveEducacion(educacion);
        return new ResponseEntity(new Mensaje("Educacion creada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update (@PathVariable("id") long id, @RequestBody dtoEducacion dtoeducacion){
        if(!impEducacionService.existById(id)){
            return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.NOT_FOUND);
        }
        if(impEducacionService.existsByNombreE(dtoeducacion.getNombreE())&& impEducacionService.getByNombreE(dtoeducacion.getNombreE()).get().getId() != id){
         return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);   
        }
        if (StringUtils.isBlank(dtoeducacion.getNombreE())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        Educacion educacion= impEducacionService.getOne(id).get();
        
        educacion.setNombreE(dtoeducacion.getNombreE());
        educacion.setDescripcionE(dtoeducacion.getDescripcionE());
        
        impEducacionService.saveEducacion(educacion);
        
        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
    }
    
    
   

   
}
