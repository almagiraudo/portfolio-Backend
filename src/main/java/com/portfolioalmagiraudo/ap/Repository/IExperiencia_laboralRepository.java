
package com.portfolioalmagiraudo.ap.Repository;

import com.portfolioalmagiraudo.ap.Entity.Experiencia_laboral;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExperiencia_laboralRepository extends JpaRepository<Experiencia_laboral,Long> {
   public Optional<Experiencia_laboral> findByNombreEx(String nombreEx);
   public boolean existsByNombreEx(String nombreEx);
    
}
