package com.pcjunior.teste.umpramuitos;

import com.pcjunior.infra.DAO;
import com.pcjunior.modelo.umpramuitos.ItemPedido;
import com.pcjunior.modelo.umpramuitos.Pedido;

public class ObterPedido {
    
    public static void main(String[] args) {
        DAO<Pedido> dao = new DAO<>(Pedido.class);

        Pedido pedido = dao.obterPorID(3L);
        
        
        for(ItemPedido item: pedido.getItens()) {
            System.out.printf(item.getId() + ": ");
            System.out.print("(" + item.getQtde() + ") ");
            System.out.printf(item.getProduto().getNome());
            //PREÇO DA COMPRA != DO PREÇO DO PRODUTO
            System.out.print(" - " + item.getPreco());
        }
        dao.fecharDAO();
    }
}
