/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Disney.explorer.service;

import Disney.explorer.entity.Foto;
import Disney.explorer.repository.FotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author groxa
 */
@Service
public class FotoService {
    @Autowired
    private FotoRepository fotoRepositorio;

    public Foto guardar(MultipartFile file) throws Exception {

        if (file != null) {
            try {
                Foto f = new Foto();
                f.setName(file.getName());
                f.setMime(file.getContentType());
                f.setContenido(file.getBytes());

                return fotoRepositorio.save(f);
                
            } catch (Exception e) {
                throw new Exception("No se pudo guardar");
            }
        } else {
            return null;
        }

    }

}
