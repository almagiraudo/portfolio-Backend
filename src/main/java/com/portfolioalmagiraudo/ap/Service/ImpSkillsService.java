
package com.portfolioalmagiraudo.ap.Service;

import com.portfolioalmagiraudo.ap.Entity.Skills;
import com.portfolioalmagiraudo.ap.Interface.ISkillsService;
import com.portfolioalmagiraudo.ap.Repository.ISkillsRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpSkillsService implements ISkillsService {
    @Autowired ISkillsRepository iskillsRepository;
    @Override
    public List<Skills> getSkills() {
    List<Skills> skills = iskillsRepository.findAll();
    return skills;
    }

    @Override
    public void saveSkills(Skills skills) {
        iskillsRepository.save(skills);
    }

    @Override
    public void deleteSkills(Long id) {
        iskillsRepository.deleteById(id);
    }

    @Override
    public Skills findSkills(Long id) {
          Skills skills = iskillsRepository.findById(id).orElse(null);
          return skills;
    }
     public boolean existsById(Long id) {
        return iskillsRepository.existsById(id);
    }
    public Optional<Skills> getOne(long id){
        return iskillsRepository.findById(id);
    }
    
}
