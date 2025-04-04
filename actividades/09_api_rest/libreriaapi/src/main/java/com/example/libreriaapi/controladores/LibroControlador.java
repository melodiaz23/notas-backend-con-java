package com.example.libreriaapi.controladores;

import com.example.libreriaapi.entidades.Libro;
import com.example.libreriaapi.modelos.LibroCreateDTO;
import com.example.libreriaapi.modelos.LibroDTO;
import com.example.libreriaapi.modelos.LibroListarActivosDTO;
import com.example.libreriaapi.servicios.LibroServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/libro")
public class LibroControlador {

  private final LibroServicio libroServicio;

  @PostMapping("/crear")
  public ResponseEntity<Object> crearLibro(@RequestBody LibroCreateDTO libroDTO) {
    try {
      libroServicio.crearLibro(libroDTO);
      return ResponseEntity.status(HttpStatus.CREATED).body(libroDTO);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }

  @GetMapping("/listar")
  public ResponseEntity<List<LibroListarActivosDTO>> listarLibrosActivos() {
    try {
      List<LibroListarActivosDTO> libros = libroServicio.obtenerLibrosActivos();
      return ResponseEntity.status(HttpStatus.CREATED).body(libros);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/{id}")
  public ResponseEntity<LibroDTO> obtenerLibro(@PathVariable Long id){
    try {
      LibroDTO libro = libroServicio.obtenerLibroPorIsbn(id);
      return ResponseEntity.ok(libro);
    } catch (Exception e){
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }


}