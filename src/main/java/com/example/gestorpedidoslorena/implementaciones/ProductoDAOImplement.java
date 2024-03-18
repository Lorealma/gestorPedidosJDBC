package com.example.gestorpedidoslorena.implementaciones;

import com.example.gestorpedidoslorena.clases.Producto;
import com.example.gestorpedidoslorena.dao.ProductoDAO;
import com.example.gestorpedidoslorena.utils.MYSQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductoDAOImplement implements ProductoDAO {

    private final Connection connection = MYSQLConnection.getConexion();

    public ProductoDAOImplement(Connection connection) {

    }

    private static final String GETPRODUCTOBYID = "select * from producto where id=?";


    @Override
    public Producto getProductoById(Long id) {

        Producto producto = new Producto();
        try {
            PreparedStatement pst = connection.prepareStatement(GETPRODUCTOBYID);
            pst.setLong(1, id);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                producto.setId(rs.getLong("id"));
                producto.setNombre(rs.getString("nombre"));
                producto.setCantidad(rs.getLong("cantidad"));
                producto.setPrecio(rs.getLong("precio"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return producto;


    }

}
