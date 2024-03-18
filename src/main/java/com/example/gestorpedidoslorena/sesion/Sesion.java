package com.example.gestorpedidoslorena.sesion;

import com.example.gestorpedidoslorena.clases.Pedido;
import com.example.gestorpedidoslorena.clases.Usuario;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Sesion {

    @Setter
    @Getter
    private static Usuario usuario;


    @Setter
    @Getter
    private static Pedido pedido;


}
