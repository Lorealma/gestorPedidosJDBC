package com.example.gestorpedidoslorena.controladores;

import com.example.gestorpedidoslorena.HelloApplication;
import com.example.gestorpedidoslorena.clases.Item;
import com.example.gestorpedidoslorena.clases.Pedido;
import com.example.gestorpedidoslorena.clases.Producto;
import com.example.gestorpedidoslorena.implementaciones.ItemDAOImplement;
import com.example.gestorpedidoslorena.implementaciones.PedidoDAOImplement;
import com.example.gestorpedidoslorena.sesion.Sesion;
import com.example.gestorpedidoslorena.utils.MYSQLConnection;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Detalles implements Initializable {
    @javafx.fxml.FXML
    private Button btn_volver;
    @javafx.fxml.FXML
    private Button btn_salir;
    @javafx.fxml.FXML
    private TableView<Producto> tv_tablaProductos;
    @javafx.fxml.FXML
    private TableColumn col_id;
    @javafx.fxml.FXML
    private TableColumn col_codigoProducto;
    @javafx.fxml.FXML
    private TableColumn col_cantidad;
    @javafx.fxml.FXML
    private TableColumn col_productoID;


    @javafx.fxml.FXML
    public void volver(ActionEvent actionEvent) {

        HelloApplication.cambioVentana("ventana-principal.fxml");

    }

    @javafx.fxml.FXML
    public void salir(ActionEvent actionEvent) {

        Sesion.setUsuario(null);
        Sesion.setPedido(null);
        HelloApplication.cambioVentana("login-view.fxml");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ItemDAOImplement dao = new ItemDAOImplement(MYSQLConnection.getConexion());
        ArrayList<Item> items = dao.getItemByCodigo(Sesion.getPedido());


   /*     col_id.setCellValueFactory( (fila) -> {
            Long id = fila.getValue().getId();
            return new SimpleStringProperty(Integer.toString(Math.toIntExact(id)));
        });
        col_codigoProducto.setCellValueFactory( (fila) -> {
            String codigo = fila.getValue().getCodigoPedido();
            return new SimpleStringProperty(codigo);
        });
        col_cantidad.setCellValueFactory( (fila) -> {
            Long cantidad = fila.getValue().getCantidad();
            return new SimpleStringProperty(Integer.toString(Math.toIntExact(cantidad)));
        });
        col_productoID.setCellValueFactory( (fila) -> {
            Long id = fila.getValue().getProductoid();
            return new SimpleStringProperty(Double.toString(id));
        });

        tv_tablaProductos.getItems().addAll(items);
    */

    }
}