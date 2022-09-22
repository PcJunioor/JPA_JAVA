package com.pcjunior.modelo.umpramuitos;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.pcjunior.modelo.basico.Produto;

@Entity
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Pedido pedido;


    // POR PADRÃO ToONE É EAGER(ANSIOSO)
    @ManyToOne(fetch = FetchType.EAGER)
    private Produto produto;

    @Column(nullable = false)
    private int qtde;

    @Column(nullable = false)
    private BigDecimal preco;

    

    public ItemPedido() {
    }

    

    public ItemPedido(Pedido pedido, Produto produto, int qtde) {
        
        this.setPedido(pedido);
        this.setProduto(produto);
        this.setQtde(qtde);
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
        if(produto != null && this.preco == null){
            this.setPreco(produto.getPreco());
        }
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    
}
