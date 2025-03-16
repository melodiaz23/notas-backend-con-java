package com.egg.biblioteca.controladores;

import com.egg.biblioteca.entidades.Autor;
import com.egg.biblioteca.excepciones.MiException;
import com.egg.biblioteca.servicios.AutorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping("/autor")
public class AutorControlador {

  @Autowired
  private AutorServicio autorServicio;

  @GetMapping("/registrar")
  public String registrar() {
    return "autor_form.html";
  }

  @PostMapping("/registro") // Same as th:action
  public String registro(@RequestParam String nombre, ModelMap modelo) {
    try {
      autorServicio.crearAutor(nombre); // Persiste el autor
      modelo.put("exito", "El autor fue cargado correctamente.");
    } catch (Exception e) {
      modelo.put("error", e.getMessage());
      Logger.getLogger(AutorControlador.class.getName()).log(Level.SEVERE, null, e);
      return "autor_form.html";
    }
    return "index.html";
  }

  @GetMapping("/lista")
  public String listar(ModelMap modelo){
    List<Autor> autores = autorServicio.listarAutores();
    modelo.addAttribute("autores", autores);
    return "autor_list.html";
  }

  @GetMapping("/modificar/{id}") // Path variable
  public String modificar(@PathVariable UUID id, ModelMap modelo){
    modelo.put("autor", autorServicio.getOne(id));
    return "autor_modificar.html";
  }

  @PostMapping("/modificar/{id}")
  public String modificar(@PathVariable UUID id, String nombre, ModelMap modelo){
    try {
      autorServicio.modificarAutor(nombre, id);
      return "redirect:../lista";
    } catch (MiException e) {
      modelo.put("error", e.getMessage());
      return "autor_modificar.html";
    }
  }
}
