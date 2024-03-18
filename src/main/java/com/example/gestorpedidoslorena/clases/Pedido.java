package com.example.gestorpedidoslorena.clases;


import java.sql.Date;
import java.util.ArrayList;

public class Pedido {

  private Long id;
  private String codigo;
  private String fecha;
  private Long id_usuario;
  private Long total;

  private Usuario usuario;

  private ArrayList<Item> items = new ArrayList<>();


  public Pedido() {
  }

  public Pedido(String codigo, String fecha, Long id_usuario, Long total) {
    this.codigo = codigo;
    this.fecha = fecha;
    this.id_usuario = id_usuario;
    this.total = total;
  }


  public Pedido(Long id, String codigo, String fecha, Long id_usuario, Long total) {
    this.id = id;
    this.codigo = codigo;
    this.fecha = fecha;
    this.id_usuario = id_usuario;
    this.total = total;
  }

  public Long getId_usuario() {
    return id_usuario;
  }

  public void setId_usuario(Long id_usuario) {
    this.id_usuario = id_usuario;
  }

  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

  public ArrayList<Item> getItems() {
    return items;
  }

  public void setItems(ArrayList<Item> items) {
    this.items = items;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }


  public String getFecha() {
    return fecha;
  }

  public void setFecha(String fecha) {
    this.fecha = fecha;
  }


  public Long getIdUsuario() {
    return id_usuario;
  }

  public void setIdUsuario(Long id_usuario) {
    this.id_usuario = id_usuario;
  }


  public Long getTotal() {
    return total;
  }

  public void setTotal(Long total) {
    this.total = total;
  }

  @Override
  public String toString() {
    return "Pedido{" +
            "id=" + id +
            ", codigo='" + codigo + '\'' +
            ", fecha='" + fecha + '\'' +
            ", id_usuario=" + id_usuario +
            ", total=" + total +
            ", usuario=" + usuario +
            ", items=" + items +
            '}';
  }
}
