package com.portfolioalmagiraudo.ap.Repository;

import com.portfolioalmagiraudo.ap.Entity.Skills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISkillsRepository extends JpaRepository <Skills, Long>{
     public Optional<Skills> findByNombre(String nombre);
   public boolean existsByNombre(String nombre);
}
