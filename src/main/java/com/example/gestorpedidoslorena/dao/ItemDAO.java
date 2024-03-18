package com.example.gestorpedidoslorena.dao;

import com.example.gestorpedidoslorena.clases.Item;
import com.example.gestorpedidoslorena.clases.Pedido;

import java.util.ArrayList;

public interface ItemDAO {

    ArrayList<Item> getAll(Long pedidoid);

    public ArrayList<Item> getItemByCodigo (Pedido codigo);

}
