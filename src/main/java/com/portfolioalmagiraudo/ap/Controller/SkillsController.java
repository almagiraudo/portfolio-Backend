package com.portfolioalmagiraudo.ap.Controller;

import com.portfolioalmagiraudo.ap.Entity.Skills;
import com.portfolioalmagiraudo.ap.Security.Controller.Mensaje;
import com.portfolioalmagiraudo.ap.Security.Dto.dtoSkills;
import com.portfolioalmagiraudo.ap.Service.ImpSkillsService;
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
@RequestMapping("/skills")
@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "https://almagiraudo-portfolio-frontend.web.app")
public class SkillsController {
    @Autowired
    ImpSkillsService impskillsService;
    
    @GetMapping("/list")
    public List<Skills> getSkills() {
        return impskillsService.list();
    }
    
    @PostMapping("/create")
     public ResponseEntity<?> create(@RequestBody dtoSkills dtoskills){
        if(StringUtils.isBlank(dtoskills.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (impskillsService.existsByNombre(dtoskills.getNombre())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        Skills skills = new Skills(
        dtoskills.getNombre(), dtoskills.getPorcentaje()
        );
        impskillsService.save(skills);
        return new ResponseEntity(new Mensaje("Skill creada"), HttpStatus.OK);
    }

    
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        impskillsService.delete(id);
        return "La skill fue eliminada correctamente";
    }

    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody dtoSkills dtoskills) {
        //Validamos si existe el ID
        if (!impskillsService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de skills
        if (impskillsService.existsByNombre(dtoskills.getNombre()) && impskillsService.getByNombre(dtoskills.getNombre()).get()
                .getId() != id) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtoskills.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Skills skills = impskillsService.getOne(id).get();
        skills.setNombre(dtoskills.getNombre());
        skills.setPorcentaje(dtoskills.getPorcentaje());

        impskillsService.save(skills);
        return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);

    }

    
     @GetMapping(("/detail/{id}"))
    public ResponseEntity<Skills> getById(@PathVariable("id")long id){
        if(!impskillsService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.BAD_REQUEST);
        }
        Skills skills = impskillsService.getOne(id).get();
        return new ResponseEntity(skills, HttpStatus.OK);
    }
}

