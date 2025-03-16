package com.egg.biblioteca.controladores;

import com.egg.biblioteca.entidades.Usuario;
import com.egg.biblioteca.excepciones.MiException;
import com.egg.biblioteca.servicios.UsuarioServicio;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.UUID;

@Controller
@RequestMapping("/")
public class PortalControlador {
  @Autowired
  UsuarioServicio usuarioServicio;

  @GetMapping("/")  // Se realiza el mapeo
  public String index() {
    return "index.html";
  }

  @GetMapping("/registro")
  public String registrar() {
    return "registro.html";
  }

  @PostMapping("/registro")
  public String registro(@RequestParam String nombre,
                         @RequestParam String email,
                         @RequestParam String password,
                         @RequestParam String password2,
                         ModelMap modelo,
                         MultipartFile archivo) {
    try {
      usuarioServicio.registrar(nombre, email, password, password2, archivo);
      modelo.put("exito", "Usuario registrado correctamente");
      return "index.html";
    } catch (MiException e) {
      modelo.put("error", e.getMessage());
      modelo.put("nombre", nombre);
      modelo.put("email", email);
      return "registro.html";
    }
  }

  @GetMapping("/login")
  public String login(@RequestParam(required = false) String error,  ModelMap modelo){
    if (error!=null){
      modelo.put("error", "Error en el login: Usuario o contraseña incorrecto");
    }
      return "login.html";
  }

  @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
  @GetMapping("/inicio")
  public String inicio(HttpSession session) {
    Usuario logueado = (Usuario) session.getAttribute("usuariosession");
    if (logueado.getRol().toString().equals("ADMIN")){
      return "redirect:/admin/dashboard";
    }
    return "inicio.html";
  }

  @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
  @GetMapping("/perfil")
  public String perfil(ModelMap modelo, HttpSession session){
    Usuario usuario = (Usuario) session.getAttribute("usuariosession");
    modelo.put("usuario", usuario);
    return "usuario_modificar.html";

  }

  @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
  @PostMapping("/perfil/{id}")
  public String actualizar(@PathVariable("id") UUID id,
                           @RequestParam String nombre,
                           String email,
                           String password,
                           String password2,
                           MultipartFile archivo,
                           ModelMap modelo,
                           HttpSession session) {
    try {
      Usuario usuario = usuarioServicio.actualizarUsuario(id, nombre, email, password, password2, archivo);
      modelo.put("exito", "Usuario actualizado correctamente!");
      return "redirect:/inicio";
    } catch (MiException e) {
      modelo.put("error", e.getMessage());
      modelo.put("nombre", nombre);
      modelo.put("email", email);
      return "usuario_modificar.html";
    }
  }
}
