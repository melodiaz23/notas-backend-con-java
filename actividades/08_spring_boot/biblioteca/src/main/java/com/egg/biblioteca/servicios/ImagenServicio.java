package com.egg.biblioteca.servicios;

import com.egg.biblioteca.entidades.Imagen;
import com.egg.biblioteca.excepciones.MiException;
import com.egg.biblioteca.repositorios.ImagenRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Service
public class ImagenServicio {

  @Autowired
  private ImagenRepositorio imagenRepositorio;

  @Transactional // Asegura que las operaciones de bases de datos se manejen correctamente
  public Imagen guardar(MultipartFile archivo) throws MiException {
    if (archivo != null && !archivo.isEmpty()) { // Validación del archivo antes de procesarlo
      try {
        Imagen imagen = new Imagen();
        imagen.setMime(archivo.getContentType());
        imagen.setNombre(archivo.getOriginalFilename());
        imagen.setContenido(archivo.getBytes()); // Arroja IOException
        return imagenRepositorio.save(imagen);
      } catch (IOException e) {
        throw new MiException("Error al guardar la imagen");
      }
    } else {
      throw new MiException("El archivo está vacío o es nulo");
    }
  }


  public Imagen actualizar(MultipartFile archivo, UUID idImagen) throws IOException, MiException {
    if (archivo != null){
        Imagen imagen = new Imagen();
        if (idImagen != null) {
          Optional<Imagen> respuesta = imagenRepositorio.findById(idImagen);
          if(respuesta.isPresent()) {
            imagen = respuesta.get();
          } else {
            throw new MiException("Error al actualizar imagen.");
          }
        }
        imagen.setMime(archivo.getContentType());
        imagen.setNombre(archivo.getName());
        imagen.setContenido((archivo.getBytes()));
        return imagenRepositorio.save(imagen);
      }
    return null;

  }

}
