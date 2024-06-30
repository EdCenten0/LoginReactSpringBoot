package com.webLogin.demo.dao;

import com.webLogin.demo.models.Usuario;

import java.util.List;

public interface UsuarioDao {

    List<Usuario> getUsuarios();

    void registrar(Usuario usuario);

    Usuario checkCredentials(Usuario usuario);
}
