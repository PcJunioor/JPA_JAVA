package com.pcjunior.teste.basico;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import com.pcjunior.infra.DAOProduto;
import com.pcjunior.modelo.basico.Produto;

public class ObterProdutos {
    public static void main(String[] args) {
        DAOProduto dao = new DAOProduto();
        Scanner entrada = new Scanner(System.in);
        // OBTER LISTA DE PRODUTOS
        List<Produto> produtos = dao.obterTodos();
        for(Produto produto: produtos){
            System.out.printf(produto.getId() + ": " + produto.getNome() + " - R$ " + produto.getPreco() + "\n");
        }

        System.out.print("% de desconto (0 a 100): ");
        // PORCENTAGEM DE DESCONTO        
        BigDecimal desconto = entrada.nextBigDecimal().divide(BigDecimal.valueOf(100)); 
        BigDecimal valorTotal = produtos.stream()
            .map(Produto::getPreco) // equivale a p -> p.getPreco()
            .map(p -> p.subtract(p.multiply(desconto))) // Calcular % de desconto
            .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.printf("Total com %.0f%% de desconto: R$ %.2f",
            desconto.multiply(BigDecimal.valueOf(100)), valorTotal);

        dao.fecharDAO();
        entrada.close();
    }
    
}
