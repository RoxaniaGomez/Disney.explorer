/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Disney.explorer.entity;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author groxa
 */
@Data
@Entity
public class PeliculasOSeries {
     @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private Foto imagen;
    private String titulo;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(style = "yyyy-mm-dd")
    private Date fechaDeCreacion;
    
    private Integer calificacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invoice")
    private Personaje personajesAsociados;
}
