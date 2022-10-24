package com.portfolioalmagiraudo.ap.Controller;


import com.portfolioalmagiraudo.ap.Entity.Experiencia_laboral;
import com.portfolioalmagiraudo.ap.Security.Controller.Mensaje;
import com.portfolioalmagiraudo.ap.Security.Dto.dtoExperiencia;
import com.portfolioalmagiraudo.ap.Service.ImpExperiencia_laboralService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/experiencia")
@CrossOrigin(origins = "https://almagiraudo-portfolio-frontend.web.app")
public class Experiencia_laboralController {

    @Autowired
    ImpExperiencia_laboralService impexperiencia_laboralService;
    
    @GetMapping("/list")
    public ResponseEntity <List<Experiencia_laboral>> list() {
        List<Experiencia_laboral> list = impexperiencia_laboralService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    
    @PostMapping("/create")
    public ResponseEntity <?> create(@RequestBody dtoExperiencia dtoexp){
        if(StringUtils.isBlank(dtoexp.getNombreEx()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"),HttpStatus.BAD_REQUEST);
        if(impexperiencia_laboralService.existsByNombreEx(dtoexp.getNombreEx()))
            return new ResponseEntity(new Mensaje("Esa Experiencia existe"), HttpStatus.BAD_REQUEST);
        Experiencia_laboral experiencia = new Experiencia_laboral (dtoexp.getNombreEx(), dtoexp.getDescripcionEx());
        impexperiencia_laboralService.save(experiencia);
        return new ResponseEntity(new Mensaje("ExperienciaAgregada"), HttpStatus.OK);
    }
    
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete (@PathVariable("id")Long id){
        if (!impexperiencia_laboralService.existById(id))
        return new ResponseEntity(new Mensaje("La experiencia no existe"), 
                    HttpStatus.BAD_REQUEST);
                    
            impexperiencia_laboralService.delete(id);
            return new ResponseEntity(new Mensaje("La experiencia fue borrada"),HttpStatus.OK);
    }

   
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update (@PathVariable("id")Long id,
            @RequestBody dtoExperiencia dtoexp) {
        if(!impexperiencia_laboralService.existById(id))
            return new ResponseEntity(new Mensaje("La experiencia no existe"), 
                    HttpStatus.BAD_REQUEST);
        if(impexperiencia_laboralService.
                existsByNombreEx(dtoexp.getNombreEx())&& impexperiencia_laboralService.
                        getByNombreEx(dtoexp.getNombreEx()).get().getId() != id)
        return new ResponseEntity
        (new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(dtoexp.getNombreEx()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"),
                    HttpStatus.BAD_REQUEST);
        Experiencia_laboral experiencia = impexperiencia_laboralService.getOne(id).get();
        experiencia.setNombreEx(dtoexp.getNombreEx());
        experiencia.setDescripcionEx(dtoexp.getDescripcionEx());
        
        impexperiencia_laboralService.save(experiencia);
        return new ResponseEntity(new Mensaje("La experiencia fue guardada con exito"),HttpStatus.OK);
         
    }
    
    @GetMapping(("/detail/{id}"))
    public ResponseEntity<Experiencia_laboral> getById(@PathVariable("id")long id){
        if(!impexperiencia_laboralService.existById(id)){
            return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.BAD_REQUEST);
        }
        Experiencia_laboral experiencia = impexperiencia_laboralService.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    }


