package com.pcjunior.teste.basico;

import java.math.BigDecimal;

import com.pcjunior.infra.DAOProduto;
import com.pcjunior.modelo.basico.Produto;

public class NovoProduto {
    public static void main(String[] args) {
        
        DAOProduto dao = new DAOProduto();
        Produto produto = new Produto("Jogo Ps5", new BigDecimal("300"));

        dao.incluir(produto);
        // OU
        //dao.incluirFull(produto).fecharDAO();
        System.out.println("Id incluído: " + produto.getId());
        dao.fecharDAO();
    }
    
}
