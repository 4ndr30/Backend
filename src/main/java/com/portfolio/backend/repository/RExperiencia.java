
package com.portfolio.backend.repository;

import com.portfolio.backend.entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RExperiencia extends JpaRepository<Experiencia, Integer> {
    public Optional<Experiencia> findByNombre(String nombreE);
    public boolean existsByNombreE (String NombreE);

    public Optional<Experiencia> findByNombreE(String nombreE);
    
}
