
package com.portfolio.backend.Services;

import com.portfolio.backend.entity.Skills;
import com.portfolio.backend.repository.RSkills;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author invitado1
 */

@Transactional
@Service
public class SSkills {
    @Autowired
    RSkills rSkills;
    
    public List<Skills> list(){
        return rSkills.findAll();
    }
    public Optional<Skills> getOne(int id){
        return rSkills.findById(id);
    }
    public Optional<Skills> getByNombre(String nombre){
        return rSkills.findByNombre(nombre);
    }
    public void save (Skills skill){
        rSkills.save(skill);
    }
    public void delete (int id){
        rSkills.deleteById(id);
    }
    public boolean existsById(int id){
        return rSkills.existsById(id);
    }
    public boolean existsByNombre(String nombre){
        return rSkills.existsByNombre(nombre);
    }
}
