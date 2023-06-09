
package com.portfolio.backend.Controller;

import com.portfolio.backend.Dto.dtoSkills;
import com.portfolio.backend.Security.Controller.Mensaje;
import com.portfolio.backend.Services.SSkills;
import com.portfolio.backend.entity.Skills;
import io.micrometer.common.util.StringUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://frontendap4ndr30.web.app")
@RequestMapping("/skill")

public class CSkills {
    @Autowired
    SSkills sSkills;
    @GetMapping("/lista")
    public ResponseEntity<List<Skills>> list(){
      List<Skills> list =  sSkills.list();
      return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSkills dtoskills){
       if(StringUtils.isBlank(dtoskills.getNombre()))
           return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
       if (sSkills.existsByNombre(dtoskills.getNombre()))
               return new ResponseEntity(new Mensaje ("La Skill ya existe"), HttpStatus.BAD_REQUEST);
       Skills skills = new Skills(dtoskills.getNombre(), dtoskills.getPorcentaje());
       sSkills.save(skills);
       return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update (@PathVariable("id ") int id, @RequestBody dtoSkills dtoskills){
            if(!sSkills.existsById(id))
                return new ResponseEntity(new Mensaje ("El ID no existe"), HttpStatus.BAD_REQUEST);
            if(sSkills.existsByNombre(dtoskills.getNombre()) && sSkills.getByNombre(dtoskills.getNombre()).get().getId() != id)
                return new ResponseEntity (new Mensaje ("Esa Skill ya existe"), HttpStatus.BAD_REQUEST);
            if (StringUtils.isBlank(dtoskills.getNombre()))
                return new ResponseEntity (new Mensaje ("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
            Skills skills =  sSkills.getOne(id).get();
            skills.setNombre(dtoskills.getNombre());
            skills.setPorcentaje ((dtoskills.getPorcentaje()));
            
            sSkills.save(skills);
            return new ResponseEntity(new Mensaje ("Skill agregada"), HttpStatus.OK);
    }
    public ResponseEntity<?> delete(@PathVariable("id ") int id){
        if(!sSkills.existsById(id))
            return new ResponseEntity(new Mensaje ("El ID no existe"), HttpStatus.BAD_REQUEST);
        sSkills.delete(id);
        return new ResponseEntity(new Mensaje ("Skill Eliminada"), HttpStatus.OK);
        
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Skills> getById(@PathVariable("id") int id){
        if(!sSkills.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Skills skills = sSkills.getOne(id).get();
        return new ResponseEntity(skills, HttpStatus.OK);
    }
   
    
}
