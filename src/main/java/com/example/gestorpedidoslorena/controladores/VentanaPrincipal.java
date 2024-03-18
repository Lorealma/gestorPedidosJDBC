package com.example.gestorpedidoslorena.controladores;

import com.example.gestorpedidoslorena.HelloApplication;
import com.example.gestorpedidoslorena.clases.Pedido;
import com.example.gestorpedidoslorena.clases.Usuario;
import com.example.gestorpedidoslorena.implementaciones.PedidoDAOImplement;
import com.example.gestorpedidoslorena.sesion.Sesion;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.List;


public class VentanaPrincipal
{
    @javafx.fxml.FXML
    private Button btn_salir;
    @javafx.fxml.FXML
    private TableView<Pedido> tv_tabla;
    @javafx.fxml.FXML
    private TableColumn<Pedido,String> col_id;
    @javafx.fxml.FXML
    private TableColumn<Pedido,String> col_codigo;
    @javafx.fxml.FXML
    private TableColumn<Pedido,String> col_fecha;
    @javafx.fxml.FXML
    private TableColumn<Pedido,String> col_usuario;
    @javafx.fxml.FXML
    private TableColumn<Pedido,String> col_total;

    @javafx.fxml.FXML
    public void initialize() {

        tv_tabla.getSelectionModel().selectedItemProperty().addListener((observableValue, vOld, vNew) -> {
            Sesion.setPedido(vNew);
            HelloApplication.cambioVentana("detallesPedido-view.fxml");
        });

        Usuario user = Sesion.getUsuario();
        PedidoDAOImplement dao = new PedidoDAOImplement();
        List<Pedido> pedidosUsuario = dao.pedidosByUsuario(user) ;


        /*col_id.setCellValueFactory( (fila) -> {
            Integer id = fila.getValue().getId();
            return new SimpleStringProperty(id.toString());
        });*/
        col_codigo.setCellValueFactory( (fila) ->{
            String codigo = String.valueOf(fila.getValue().getCodigo());
            return new SimpleStringProperty(codigo);
        });
        col_fecha.setCellValueFactory( (fila) ->{
            String fecha = String.valueOf(fila.getValue().getFecha());
            return new SimpleStringProperty(fecha);
        });
        col_usuario.setCellValueFactory( (fila) -> {
            String usuario = String.valueOf(fila.getValue().getUsuario());
            return new SimpleStringProperty(usuario);
        });
        col_total.setCellValueFactory( (fila) -> {
            String total = String.valueOf(fila.getValue().getTotal());
            return new SimpleStringProperty(total);
        });
        tv_tabla.getItems().addAll(pedidosUsuario);

    }


    @javafx.fxml.FXML
    public void salir(ActionEvent actionEvent) {

        Sesion.setUsuario(null);
        Sesion.setPedido(null);
        HelloApplication.cambioVentana("login-view.fxml");

    }


}

