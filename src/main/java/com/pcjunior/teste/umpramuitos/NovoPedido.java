package com.pcjunior.teste.umpramuitos;

import java.math.BigDecimal;

import com.pcjunior.infra.DAO;
import com.pcjunior.modelo.basico.Produto;
import com.pcjunior.modelo.umpramuitos.ItemPedido;
import com.pcjunior.modelo.umpramuitos.Pedido;

public class NovoPedido {
    
    public static void main(String[] args) {
        DAO<Object> dao = new DAO<>();

        Produto produto = new Produto("Geladeira", new BigDecimal("2789.99"));
        Pedido pedido = new Pedido();
        ItemPedido item = new ItemPedido(pedido, produto, 10);

        dao.incluir(produto).incluir(pedido).incluir(item);
        dao.fecharDAO();
    }
}
