/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Disney.explorer.controller;


import Disney.explorer.entity.Foto;
import Disney.explorer.entity.Personaje;
import Disney.explorer.service.FotoService;
import Disney.explorer.service.PersonajeService;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author groxa
 */


@Controller
@RequestMapping("/personaje")
public class PersonajeController {
    @Autowired
    private FotoService fotoServicio;
    
    @Autowired
    private PersonajeService PersonajeService;
    @GetMapping("")
    public String formulario(Model modelo){
    Personaje personaje = new Personaje();
    modelo.addAttribute("personaje", personaje);
    return "personaje";
    
    }
    @GetMapping("/modificar")
    public String formulario(@RequestParam(name = "id", required = true) String id, Model modelo) {
	Personaje personaje = PersonajeService.buscarPorId(id);
	modelo.addAttribute("Personaje", personaje);
	return "personaje";
    }
    @PostMapping("/save")
    public String formularioData(@RequestParam("nombre") String nombre, @RequestParam("id") String id, Model modelo, @RequestParam("archivo") MultipartFile archivo) {
	  Personaje personaje = new Personaje();
        
	try {
            if (archivo!= null){
            Foto foto = fotoServicio.guardar(archivo);
            personaje.setImagen(foto);
            }
	    personaje.setNombre(nombre);
            
            if(id!=null && !id.isEmpty()){
           personaje.setId(id);
           } 
          
	  PersonajeService.creacionPersonaje(personaje);
	    modelo.addAttribute("personaje", personaje);
	    return "personaje";
	} catch (Exception ex) {
	    ex.printStackTrace();
	    modelo.addAttribute("personaje", personaje);
	    modelo.addAttribute("error", ex.getMessage());
	    return "personaje";
	}
    }
    @GetMapping("/list")
    public String listAll(Model modelo) {
	List<Personaje> personaje = PersonajeService.listarPersonaje();
	modelo.addAttribute("listaDePersonajes", personaje);
	return "personaje-listar";
    }



    @GetMapping("/delete")
    public String delete(@RequestParam("id") String id) {
	try {
	    PersonajeService.borrarPersonaje(id);
	    return "redirect:/personaje/list";
	} catch (Exception e) {
	    e.printStackTrace();
	    return "redirect:/personaje/list";
	}
    }
    
}