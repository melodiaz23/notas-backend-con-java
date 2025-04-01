package com.example.libreriaapi.controladores;

import com.example.libreriaapi.entidades.Editorial;
import com.example.libreriaapi.servicios.EditorialServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("editorial")
@RequiredArgsConstructor
public class EditorialControlador {

  private final EditorialServicio editorialServicio;

  @PostMapping("crear")
  public ResponseEntity<Object> crearEditorial(String nombre){
    try {
      Editorial editorial = new Editorial();
      editorial.setNombreEditorial(nombre);
      editorialServicio.crearEditorial(editorial);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
