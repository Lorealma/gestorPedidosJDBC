package com.example.gestorpedidoslorena.implementaciones;

import com.example.gestorpedidoslorena.clases.Usuario;
import com.example.gestorpedidoslorena.dao.UsuarioDAO;
import com.example.gestorpedidoslorena.utils.MYSQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAOImplement implements UsuarioDAO {

    private final Connection connection = MYSQLConnection.getConexion();

    public UsuarioDAOImplement(Connection conexion) {
    }

    private final String GETALL = "select * from usuario";

    private final String GETUSUARIOBYID = "select * from usuario where id=?";

    private final String CARGAR = "select * from usuario where email = ?";

    @Override
    public ArrayList<Usuario> getAll() {

        ArrayList<Usuario> usuarios = new ArrayList<>();

        try{

            PreparedStatement statement = connection.prepareStatement(GETALL);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                Usuario usuario = new Usuario();
                usuario.setId(resultSet.getLong("id"));
                usuario.setNombre(resultSet.getString("nombre"));
                usuario.setContrasenia(resultSet.getString("contraseña"));
                usuario.setEmail(resultSet.getString("email"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarios;

    }

    @Override
    public Usuario getUsuarioById(Long id) {

        Usuario usuario = new Usuario();

        try (PreparedStatement statement = connection.prepareStatement(GETUSUARIOBYID)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                usuario.setNombre(resultSet.getString("nombre"));
                usuario.setContrasenia(resultSet.getString("constrasenia"));
                usuario.setEmail(resultSet.getString("email"));

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return usuario;

    }

    @Override
    public Usuario consultaUsuario(String email) {

        Usuario usuario = null;
        try {
            PreparedStatement pst = connection.prepareStatement(CARGAR);
            pst.setString(1, email);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                usuario = new Usuario(

                        rs.getLong("id"),
                        rs.getString("nombre"),
                        rs.getString("contrasenia"),
                        rs.getString("email"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuario;


    }

    @Override
    public Usuario cargarLogin(String user, String pass) {
        return null;
    }


}
