package com.egg.biblioteca.controladores;

import com.egg.biblioteca.entidades.Editorial;
import com.egg.biblioteca.excepciones.MiException;
import com.egg.biblioteca.servicios.EditorialServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping("/editorial")
public class EditorialControlador {
  @Autowired
  EditorialServicio editorialServicio;

  @GetMapping("/registrar")
  public String registrar(){
    return "editorial_form.html";
  }

  @PostMapping("registro")
  public String registro(@RequestParam String nombre, ModelMap modelo){
    try {
      editorialServicio.crearEditorial(nombre);
      modelo.put("exito", "La editorial fue cargada correctamente.");
    } catch (MiException e) {
      modelo.put("error", e.getMessage());
      Logger.getLogger(AutorControlador.class.getName()).log(Level.SEVERE, null, e);
      return "editorial_form.html";
    }
    return "index.html";
  }

  @GetMapping("/lista")
  public String listar(ModelMap modelo){
    List<Editorial> editoriales = editorialServicio.listarEditoriales();
    modelo.addAttribute("editoriales", editoriales);
    return "editorial_list.html";
  }
}
