package com.example.gestorpedidoslorena.clases;


public class Item {

  private Long id;
  private String codigo_pedido;
  private Long cantidad;
  private Long producto_id;

  private Producto producto;


    public Item() {
    }


    public Item(String codigo_pedido, Long cantidad, Long producto_id) {
        this.codigo_pedido = codigo_pedido;
        this.cantidad = cantidad;
        this.producto_id = producto_id;
    }


    public Item(Long id, String codigo_pedido, Long cantidad, Long producto_id) {
        this.id = id;
        this.codigo_pedido = codigo_pedido;
        this.cantidad = cantidad;
        this.producto_id = producto_id;
    }


  public String getCodigo_pedido() {
    return codigo_pedido;
  }

  public void setCodigo_pedido(String codigo_pedido) {
    this.codigo_pedido = codigo_pedido;
  }

  public Long getProducto_id() {
    return producto_id;
  }

  public void setProducto_id(Long producto_id) {
    this.producto_id = producto_id;
  }

  public Producto getProducto() {
    return producto;
  }

  public void setProducto(Producto producto) {
    this.producto = producto;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  public String getCodigoPedido() {
    return codigo_pedido;
  }

  public void setCodigoPedido(String codigo_pedido) {
    this.codigo_pedido = codigo_pedido;
  }


  public Long getCantidad() {
    return cantidad;
  }

  public void setCantidad(Long cantidad) {
    this.cantidad = cantidad;
  }


  public Long getProductoId() {
    return producto_id;
  }

  public void setProductoId(Long productoId) {
    this.producto_id = productoId;
  }

  @Override
  public String toString() {
    return "Item{" +
            "id=" + id +
            ", codigo_pedido='" + codigo_pedido + '\'' +
            ", cantidad=" + cantidad +
            ", producto_id=" + producto_id +
            ", producto=" + producto +
            '}';
  }
}
