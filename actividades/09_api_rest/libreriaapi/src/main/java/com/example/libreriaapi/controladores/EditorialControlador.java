package com.example.libreriaapi.controladores;

import com.example.libreriaapi.entidades.Editorial;
import com.example.libreriaapi.entidades.Editorial;
import com.example.libreriaapi.modelos.EditoriaCreatelDTO;
import com.example.libreriaapi.modelos.EditorialDTO;
import com.example.libreriaapi.servicios.EditorialServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("editorial")
@RequiredArgsConstructor
public class EditorialControlador {

  private final EditorialServicio editorialServicio;

  @PostMapping("crear")
  public ResponseEntity<Object> crearEditorial(@RequestBody EditoriaCreatelDTO editorial){
    try {
          editorialServicio.crearEditorial(editorial);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("listar")
  public ResponseEntity<List<Editorial>> getAll() {
    try {
      List<Editorial> editoriales = editorialServicio.obtenerTodasEditoriales();
      return new ResponseEntity<>(editoriales, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("listar-activas")
  public ResponseEntity<List<Editorial>> getActive() {
    try {
      List<Editorial> editoriales = editorialServicio.obtenerEditorialesActivas();
      return new ResponseEntity<>(editoriales, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("listar-inactivas")
  public ResponseEntity<List<Editorial>> getInactive() {
    try {
      List<Editorial> editoriales = editorialServicio.obtenerEditorialesInactivas();
      return new ResponseEntity<>(editoriales, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PatchMapping("/modificar")
  public ResponseEntity<Void> modificarEditorial(@RequestParam String nombre, @RequestParam UUID id) {
    try {
      editorialServicio.modificarEditorial(nombre, id);
      return ResponseEntity.ok().build();
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @DeleteMapping("delete")
  public ResponseEntity<Void> eliminarEditorial(@RequestParam UUID id) {
    try {
      editorialServicio.darBajaEditorial(id);
      return ResponseEntity.ok().build();
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @GetMapping("/{id}")
  public ResponseEntity<EditorialDTO> consultarEditorial(@PathVariable UUID id){
    try {
     EditorialDTO editorialDTO = editorialServicio.obtenerEditorial(id);
      return ResponseEntity.ok(editorialDTO);
    } catch (Exception e){
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }
}
