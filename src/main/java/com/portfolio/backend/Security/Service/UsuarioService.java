
package com.portfolio.backend.Security.Service;

import com.portfolio.backend.Security.Entity.Usuario;
import com.portfolio.backend.Security.Repository.iUsuarioRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    iUsuarioRepository iusuarioRepository;
    
    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return iusuarioRepository.findByNombreUsuario(nombreUsuario);
    }
    public boolean existByNombreUsuario(String nombreUsuario){
        return iusuarioRepository.existsByNombreUsuario(nombreUsuario);
    }
    public boolean existByEmail(String email){
        return iusuarioRepository.existsByEmail(email);
    }
    public void save(Usuario usuario){
        iusuarioRepository.save(usuario);
    }
}
