package com.egg.biblioteca.servicios;

import com.egg.biblioteca.entidades.Usuario;
import com.egg.biblioteca.enumeraciones.Rol;
import com.egg.biblioteca.excepciones.MiException;
import com.egg.biblioteca.repositorios.UsuarioRepositorio;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioServicio implements UserDetailsService {

  @Autowired
  private UsuarioRepositorio usuarioRepositorio;

  @Transactional
  public void registrar(String nombre, String email, String password, String password2) throws MiException {
    validar(nombre, email, password, password2);
    Usuario usuario = new Usuario();
    usuario.setNombre(nombre);
    usuario.setEmail(email);
    usuario.setPassword(new BCryptPasswordEncoder().encode(password));
    usuario.setRol(Rol.USER);
    usuarioRepositorio.save(usuario);
  }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    Usuario usuario = usuarioRepositorio.buscarPorEmail(email);
    if (usuario!=null){
      List<GrantedAuthority> permisos = new ArrayList<>(); // Contiene todos los permisos
      GrantedAuthority p = new SimpleGrantedAuthority("ROLE_" + usuario.getRol());
      permisos.add(p);
      ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
      HttpSession session = attr.getRequest().getSession(true);
      session.setAttribute("usuariosession", usuario);


      return new User(usuario.getEmail(), usuario.getPassword(), permisos);
    } else {
      return null;
    }
  }

  private void validar(String nombre, String email, String password, String password2) throws MiException {
    if ( nombre == null || nombre.isEmpty()) {
      throw new MiException("El nombre no puede ser nulo o estar vacío");
    }
    if (email == null || email.isEmpty()) {
      throw new MiException("El email no puede ser nulo o estar vacío");
    }
    if ( password == null || password.length() <= 5) {
      throw new MiException("La contraseña no puede estar vacía, y debe tener más de 5 dígitos");
    }
    if (!password.equals(password2)) {
      throw new MiException("Las contraseñas ingresadas deben ser iguales");
    }
  }

}
