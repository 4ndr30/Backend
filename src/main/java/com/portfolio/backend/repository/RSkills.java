/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.backend.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.portfolio.backend.entity.Skills;

/**
 *
 * @author invitado1
 */
public interface RSkills extends JpaRepository<Skills, Integer>{
    Optional <Skills> findByNombre (String nombre);
    public boolean existsByNombre(String nombre);
    
}
