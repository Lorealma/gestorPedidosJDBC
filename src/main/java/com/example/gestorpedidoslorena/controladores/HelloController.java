package com.example.gestorpedidoslorena.controladores;

import com.example.gestorpedidoslorena.HelloApplication;
import com.example.gestorpedidoslorena.dao.UsuarioDAO;
import com.example.gestorpedidoslorena.implementaciones.UsuarioDAOImplement;
import com.example.gestorpedidoslorena.sesion.Sesion;
import com.example.gestorpedidoslorena.utils.MYSQLConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private TextField tf_usuario;
    @FXML
    private Button btn_entrar;
    @FXML
    private Label lbl_info;
    @FXML
    private TextField tf_contrasenia;


    @FXML
    public void entrar(ActionEvent actionEvent) {

        String email=tf_usuario.getText();
        String contraseña=tf_contrasenia.getText();
        UsuarioDAOImplement consulta=new UsuarioDAOImplement(MYSQLConnection.getConexion());
        Sesion.setUsuario(consulta.consultaUsuario(email));
        Alert alerta=new Alert(Alert.AlertType.ERROR);
        if(Sesion.getUsuario()==null){
            alerta.setTitle("Error");
            alerta.setHeaderText("");
            alerta.setContentText("Usuario incorrecto");
            alerta.showAndWait();


        }else if(!Sesion.getUsuario().getContrasenia().equals(contraseña)){
            alerta.setTitle("Error");
            alerta.setHeaderText("");
            alerta.setContentText("Contraseña incorrecta");
            alerta.showAndWait();

        }else{
            HelloApplication.cambioVentana("ventana-principal.fxml");
        }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}