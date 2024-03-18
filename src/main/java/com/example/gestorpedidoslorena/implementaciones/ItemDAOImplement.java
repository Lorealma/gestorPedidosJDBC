package com.example.gestorpedidoslorena.implementaciones;

import com.example.gestorpedidoslorena.clases.Item;
import com.example.gestorpedidoslorena.clases.Pedido;
import com.example.gestorpedidoslorena.dao.ItemDAO;
import com.example.gestorpedidoslorena.utils.MYSQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDAOImplement implements ItemDAO {

    private final Connection connection = MYSQLConnection.getConexion();

    public ItemDAOImplement(Connection conexion) {
    }

    private static final String GETITEMBYCODIGO = "select * from item where codigo_pedido=?";

    @Override
    public ArrayList<Item> getAll(Long pedidoid) {
        return null;
    }

    @Override
    public ArrayList<Item> getItemByCodigo(Pedido codigo) {


        ArrayList<Item> itemSalida = new ArrayList<>();

        try {
            PreparedStatement pst = connection.prepareStatement(GETITEMBYCODIGO);
            pst.setString(1, codigo.getCodigo());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Item item = new Item(

                        rs.getLong("id"),
                        rs.getString("codigo_pedido"),
                        rs.getLong("cantidad"),
                        rs.getLong("producto_id"));

                item.setProducto(new ProductoDAOImplement(connection).getProductoById(item.getProductoId()));
                itemSalida.add(item);

            }

        } catch (SQLException e) {

            throw new RuntimeException(e);

        }

        return itemSalida;

    }
}
