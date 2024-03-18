package com.example.gestorpedidoslorena.dao;

import com.example.gestorpedidoslorena.clases.Usuario;

import java.util.ArrayList;

public interface UsuarioDAO {
    public ArrayList<Usuario> getAll();

    public Usuario getUsuarioById(Long id);

    public Usuario consultaUsuario (String email);

    public Usuario cargarLogin(String user, String pass);
}
