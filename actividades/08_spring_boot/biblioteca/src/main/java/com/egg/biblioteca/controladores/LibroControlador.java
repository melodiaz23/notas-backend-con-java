package com.egg.biblioteca.controladores;

import com.egg.biblioteca.entidades.Autor;
import com.egg.biblioteca.entidades.Editorial;
import com.egg.biblioteca.entidades.Libro;
import com.egg.biblioteca.excepciones.MiException;
import com.egg.biblioteca.servicios.AutorServicio;
import com.egg.biblioteca.servicios.EditorialServicio;
import com.egg.biblioteca.servicios.LibroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/libro")
public class LibroControlador {
  @Autowired
  private LibroServicio libroServicio;
  @Autowired
  private AutorServicio autorServicio;
  @Autowired
  private EditorialServicio editorialServicio;

  @GetMapping("/registrar")
  public String registrar(ModelMap modelo){
    List<Autor> autores = autorServicio.listarAutores();
    List<Editorial> editoriales = editorialServicio.listarEditoriales();
    modelo.addAttribute("autores", autores);
    modelo.addAttribute("editoriales", editoriales);
    return "libro_form.html";
  }

  @PostMapping("/registro")
  public String registro(@RequestParam(required = false) Long isbn, @RequestParam String titulo,
                         @RequestParam(required = false) Integer ejemplares,
                         @RequestParam String idAutor,
                         @RequestParam String idEditorial, ModelMap modelo) {
    try {
      UUID autorUUID = (idAutor != null && !idAutor.isEmpty()) ? UUID.fromString(idAutor) : null; // Conversión manual de String a UUID
      UUID editorialUUID = (idEditorial != null && !idEditorial.isEmpty()) ? UUID.fromString(idEditorial) : null;
      libroServicio.crearLibro(isbn, titulo, ejemplares, autorUUID, editorialUUID);
      modelo.put("exito", "El libro fue cargado correctamente.");

    } catch (MiException ex) {
      modelo.put("error", ex.getMessage());

      return "libro_form.html";
    }
    return "index.html";
  }

  @GetMapping("/lista")
  public String listar(ModelMap modelo){
    List<Libro> libros = libroServicio.listarLibros();
    modelo.addAttribute("libros", libros);
    return "libro_list.html";
  }


}
