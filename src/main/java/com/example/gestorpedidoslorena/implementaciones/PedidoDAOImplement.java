package com.example.gestorpedidoslorena.implementaciones;

import com.example.gestorpedidoslorena.clases.Pedido;
import com.example.gestorpedidoslorena.clases.Usuario;
import com.example.gestorpedidoslorena.dao.PedidoDAO;
import com.example.gestorpedidoslorena.utils.MYSQLConnection;

import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAOImplement implements PedidoDAO {

    private final Connection connection = MYSQLConnection.getConexion();

    public PedidoDAOImplement() {
    }

    private final String GETALLPEDIDOS= "select * from pedidos";

    private final String GETPEDIDOBYID= "select * from pedido where id=?";

    private final String GETPEDIDOBYUSUARIO= "select * from pedido where usuario_id = ?";

    @Override
    public ArrayList<Pedido> getAll() {

        ArrayList<Pedido> pedidos = new ArrayList<Pedido>();

        try {

            PreparedStatement st = connection.prepareStatement(GETALLPEDIDOS);


            ResultSet rs = st.executeQuery();
            while(rs.next()){

                Pedido pedido = new Pedido();

                pedido.setId(rs.getLong("id_pedido"));
                pedido.setCodigo(rs.getString("codigo"));
                pedido.setFecha(rs.getString("fecha"));
                pedido.setIdUsuario(rs.getLong("usuario_id"));
                pedido.setTotal(rs.getLong("total"));
                pedidos.add(pedido);



                pedidos.add(pedido);

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return pedidos;
    }

    @Override
    public Pedido getPedidoById(Long id) {
        return null;
    }

    @Override
    public ArrayList<Pedido> pedidosByUsuario(Usuario usuario) {

        ArrayList<Pedido> pedidos = new ArrayList<>();
        try (PreparedStatement pst = connection.prepareStatement(GETPEDIDOBYUSUARIO)) {
            pst.setLong(1, usuario.getId());

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                Pedido pedido = new Pedido();

                pedido.setId(rs.getLong("id_pedido"));
                pedido.setCodigo(rs.getString("codigo"));
                pedido.setFecha(rs.getString("fecha"));
                pedido.setIdUsuario(rs.getLong("usuario_id"));
                pedido.setTotal(rs.getLong("total"));
                pedidos.add(pedido);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pedidos;

    }



}
