package com.portfolioalmagiraudo.ap.Controller;

import com.portfolioalmagiraudo.ap.Entity.Skills;
import com.portfolioalmagiraudo.ap.Security.Controller.Mensaje;
import com.portfolioalmagiraudo.ap.Service.ImpSkillsService;
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
@RequestMapping("/skills")
@CrossOrigin(origins = "https://almagiraudo-portfolio-frontend.web.app")
public class SkillsController {
    @Autowired
    ImpSkillsService impskillsService;
    @GetMapping("/list")
    public List<Skills> getSkills() {
        return impskillsService.getSkills();
    }

    
    @PostMapping("/create")
    public String createSkills(@RequestBody Skills skills) {
        impskillsService.saveSkills(skills);
        return "La skill fue creada correctamente";
    }

    
    @DeleteMapping("/delete/{id}")
    public String deleteSkills(@PathVariable Long id) {
        impskillsService.deleteSkills(id);
        return "La skill fue eliminada correctamente";
    }

    
    @PutMapping("/update/{id}")
    public Skills editSkills(@PathVariable("id") Long id,
            @RequestBody Skills skills) {
        skills.setId(id);
        impskillsService.saveSkills(skills);
        return skills;
    }

    @GetMapping("/get/{id}")
    public Skills listId (@PathVariable Long id) {
        return impskillsService.findSkills(id);
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

