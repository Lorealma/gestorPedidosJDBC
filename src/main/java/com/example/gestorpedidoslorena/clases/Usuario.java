package com.example.gestorpedidoslorena.clases;


import java.util.ArrayList;

public class Usuario {

  private Long id;
  private String nombre;
  private String contrasenia;
  private String email;

  private ArrayList<Pedido> pedidos;


  public Usuario() {
  }

  public Usuario(String nombre, String contrasenia, String email) {
    this.nombre = nombre;
    this.contrasenia = contrasenia;
    this.email = email;
  }

  public Usuario(Long id, String nombre, String contrasenia, String email) {
    this.id = id;
    this.nombre = nombre;
    this.contrasenia = contrasenia;
    this.email = email;
    this.pedidos = new ArrayList<Pedido>();
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


  public String getContrasenia() {
    return contrasenia;
  }

  public void setContrasenia(String contrasenia) {
    this.contrasenia = contrasenia;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "Usuario{" +
            "id=" + id +
            ", nombre='" + nombre + '\'' +
            ", contrasenia='" + contrasenia + '\'' +
            ", email='" + email + '\'' +
            ", pedidos=" + pedidos +
            '}';
  }
}
