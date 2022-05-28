/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Disney.explorer.entity;

import javax.persistence.OneToMany;

/**
 *
 * @author groxa
 */
public class Genero {
    private String nombre;
    private Foto imagen;
    
    @OneToMany
    private PeliculasOSeries peliculaOserie;
}
