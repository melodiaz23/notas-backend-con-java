package com.example.libreriaapi.controladores;

import com.example.libreriaapi.entidades.Autor;
import com.example.libreriaapi.servicios.AutorServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

  @GetMapping("listar")
  public ResponseEntity<List<Autor>> getAll(){
    try {
      List<Autor> autores = autorServicio.obtenerTodosAutores();
      return new ResponseEntity<>(autores, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PatchMapping("/modificar")
  public ResponseEntity<Void> modificarAutor(@RequestParam String nombre, @RequestParam UUID id){
    try {
      autorServicio.modificarAutor(nombre, id);
      return ResponseEntity.ok().build();
    } catch (Exception e){
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }


}
