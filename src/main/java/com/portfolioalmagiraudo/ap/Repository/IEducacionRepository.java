
package com.portfolioalmagiraudo.ap.Repository;

import com.portfolioalmagiraudo.ap.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducacionRepository extends JpaRepository <Educacion,Long> {
    public Optional<Educacion> findByNombreE(String nombreE);
    public boolean existsByNombreE(String nombreE); 
}
