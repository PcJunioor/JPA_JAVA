package com.pcjunior.infra;

import java.math.BigDecimal;

import com.pcjunior.modelo.basico.Produto;

public class DAOProduto extends DAO<Produto>{

    public DAOProduto() {
        super(Produto.class);
    }

    public DAO<Produto> alterarProduto(Long id, String nome, BigDecimal preco) {            
       
        Produto prod = super.obterPorID(id);
        
        abrirTransacao();
        prod.setNome(nome);
        prod.setPreco(preco);
        fecharTransacao();       

        return this;        
    }
    
    
}
