package com.egg.biblioteca.controladores;
import com.egg.biblioteca.entidades.Usuario;
import com.egg.biblioteca.excepciones.MiException;
import com.egg.biblioteca.servicios.ImagenServicio;
import com.egg.biblioteca.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/imagen")
public class ImagenControlador {

  @Autowired
  private UsuarioServicio usuarioServicio;

  @Autowired
  private ImagenServicio imagenServicio;

  @GetMapping("/perfil/{id}")
  public ResponseEntity<byte[]> imagenUsuario(@PathVariable UUID id){
    Usuario usuario = usuarioServicio.getOne(id);
    byte[] imagen = usuario.getImagen().getContenido();
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.parseMediaType(usuario.getImagen().getMime()));
    return new ResponseEntity<>(imagen, headers, HttpStatus.OK);
  }
}
