package com.egg.servicios;
import com.egg.entidades.Editorial;
import com.egg.persistencia.EditorialDAO;

import java.util.List;

public class EditorialServicio {
  EditorialDAO editorialDAO = new EditorialDAO();

  public void adicionarEditorial(Editorial editorial){
    editorialDAO.adicionarEditorial(editorial);
  }

  public void actualizarEditorial(Editorial editorial){
    editorialDAO.actualizarEditorial(editorial);
  }

  public Editorial buscarEditorial(Integer id){
    return editorialDAO.buscarEditorial(id);
  }

  public List<Editorial> listarTodasLosEditoriales(){
    return editorialDAO.listarTodosLasEditoriales();
  }




}
