package com.example.gestorpedidoslorena.clases;


public class Producto {

  private Long id;
  private String nombre;
  private Long precio;
  private Long cantidad;


  public Producto() {
  }


  public Producto(String nombre, Long precio, Long cantidad) {
    this.nombre = nombre;
    this.precio = precio;
    this.cantidad = cantidad;
  }

  public Producto(Long id, String nombre, Long precio, Long cantidad) {
    this.id = id;
    this.nombre = nombre;
    this.precio = precio;
    this.cantidad = cantidad;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }


  public Long getPrecio() {
    return precio;
  }

  public void setPrecio(Long precio) {
    this.precio = precio;
  }


  public long getCantidad() {
    return cantidad;
  }

  public void setCantidad(long cantidad) {
    this.cantidad = cantidad;
  }

  @Override
  public String toString() {
    return "Producto{" +
            "id=" + id +
            ", nombre='" + nombre + '\'' +
            ", precio=" + precio +
            ", cantidad=" + cantidad +
            '}';
  }
}
