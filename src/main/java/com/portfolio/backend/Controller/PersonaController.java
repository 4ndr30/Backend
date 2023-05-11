package com.portfolio.backend.Controller;

import com.portfolio.backend.Interface.IPersonaService;
import com.portfolio.backend.entity.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PersonaController {
    @Autowired
    IPersonaService ipersonaService;
    
    @GetMapping("/personas/traer")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Persona> getPersona(){
        return ipersonaService.getPersona();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/personas/crear")
    @CrossOrigin(origins = "http://localhost:4200")
    public String createPersona(@RequestBody Persona persona){
        ipersonaService.savePersona(persona);
        return "El usuario fue creado correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/personas/borrar/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public String deletePersona (@PathVariable Long id){
        ipersonaService.deletePersona(id);
        return "El usuario fue eliminado correctamente";
    } 
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/personas/editar/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Persona editPersona(@PathVariable Long id,
                               @RequestParam("nombre") String nuevoNombre,
                               @RequestParam("apellido") String nuevoApellido,
                               @RequestParam("img") String nuevoImg){
        Persona persona = ipersonaService.findPersona(id);
        
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevoImg);
        
        ipersonaService.savePersona(persona);
        return persona;
    }
    
    @GetMapping("/personas/perfil/{id}")
    public Persona findPersona() {
        return ipersonaService.findPersona((long)1);
    }
}