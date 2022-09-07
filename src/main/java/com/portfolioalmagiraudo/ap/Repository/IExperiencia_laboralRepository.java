
package com.portfolioalmagiraudo.ap.Repository;

import com.portfolioalmagiraudo.ap.Entity.Experiencia_laboral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExperiencia_laboralRepository extends JpaRepository <Experiencia_laboral,Long> {
    
}
