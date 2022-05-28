/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Disney.explorer.repository;

import Disney.explorer.entity.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author groxa
 */
@Repository
public interface GeneroRepository  extends JpaRepository<Genero, String>{
    
}
