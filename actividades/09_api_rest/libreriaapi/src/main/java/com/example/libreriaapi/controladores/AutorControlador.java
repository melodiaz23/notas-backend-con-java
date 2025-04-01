package com.example.libreriaapi.controladores;

import com.example.libreriaapi.entidades.Autor;
import com.example.libreriaapi.servicios.AutorServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/autor")
public class AutorControlador {

  private final AutorServicio autorServicio;

  @PostMapping("crear")
  public ResponseEntity<Object> crearAutor(@RequestBody Autor autor){
    try {
      autorServicio.crearAutor(autor);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
