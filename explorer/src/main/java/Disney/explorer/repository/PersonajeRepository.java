/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Disney.explorer.repository;


import Disney.explorer.entity.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author groxa
 */
public interface PersonajeRepository extends JpaRepository<Personaje, String>{
     @Query("select a from Personaje a where a.nombre = :nombre")
    public Personaje buscarPersonajePorNombre(@Param("nombre") String nombre);
}
