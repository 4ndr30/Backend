
package com.portfolio.backend.Interface;

import com.portfolio.backend.entity.Persona;
import java.util.List;

public interface IPersonaService {
    public List<Persona> getPersona();
    
    //Guarda un objeto de tipo persona
    public void savePersona(Persona persona);
    
    //Eliminar objeto por ID
    public void deletePersona(Long id);
    
    //Buscar una persona por ID
    public Persona findPersona(Long id);
}
