package com.example.gestorpedidoslorena.dao;

import com.example.gestorpedidoslorena.clases.Pedido;
import com.example.gestorpedidoslorena.clases.Usuario;

import java.util.ArrayList;

public interface PedidoDAO {

    public Pedido getPedidoById(Long id);

    public ArrayList<Pedido> getAll();

    public ArrayList<Pedido> pedidosByUsuario(Usuario user);

}
