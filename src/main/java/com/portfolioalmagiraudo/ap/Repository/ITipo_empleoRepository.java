
package com.portfolioalmagiraudo.ap.Repository;


import com.portfolioalmagiraudo.ap.Entity.Tipo_empleo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipo_empleoRepository extends JpaRepository <Tipo_empleo,Long> {
    
}
