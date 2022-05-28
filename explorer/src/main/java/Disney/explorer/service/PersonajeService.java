/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Disney.explorer.service;

import Disney.explorer.entity.Personaje;
import Disney.explorer.repository.PersonajeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author groxa
 */
@Service
public class PersonajeService {
    @Autowired
    PersonajeRepository personajeRepository;
    
    public Personaje creacionPersonaje(Personaje personaje) throws Exception {
	if (personaje.getNombre().isEmpty()) {
	    throw new Exception("El nombre del personaje no puede estar vacio");
	}
	return personajeRepository.save(personaje);
    }

    public Personaje edicionPersonaje(Personaje personaje, String nombre) throws Exception {
	if (nombre.isEmpty()) {
	    throw new Exception("el nombre no puede estar vacio");
	}
	personaje.setNombre(nombre);
	return personajeRepository.save(personaje);
    }
    

    public List<Personaje> listarPersonaje() {
	return personajeRepository.findAll();
    }

    public Personaje buscarPorNombre(String nombre) {
	return personajeRepository.buscarPersonajePorNombre(nombre);
    }
    public Personaje buscarPorId(String id) {
       return personajeRepository.getById(id);
    }
    public void borrarPersonaje(String id) throws Error {
	Optional<Personaje> respuesta = personajeRepository.findById(id);
	if (respuesta.isPresent()) {
	    Personaje personaje = respuesta.get();
	    personajeRepository.delete(personaje);
	} else {
	    throw new Error("no se encontro el personaje");
	}
    }
}
