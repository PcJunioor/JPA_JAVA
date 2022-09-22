package com.pcjunior.teste.basico;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.pcjunior.infra.DAOProduto;
import com.pcjunior.modelo.basico.Produto;

public class AlterarProduto {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        DAOProduto dao = new DAOProduto();
        List<Produto> produtos = new ArrayList<>();
        Produto prod = new Produto();

        produtos = dao.obterTodos();
        for(Produto produto : produtos){
            System.out.println(produto.getId() + ": " + produto.getNome() + " - R$" + produto.getPreco());
        }

        
        do{
            System.out.print("Digite o id que deseja alterar: ");
            Long id = entrada.nextLong();
            entrada.nextLine();
            prod = dao.obterPorID(id);

            if(prod != null){               
                System.out.print("Nome: ");
                String nome = entrada.nextLine();
                System.out.print("Preço: ");
                BigDecimal preco = new BigDecimal(entrada.next().replace(",", "."));

                dao.alterarProduto(id, nome, preco);
                System.out.println("Produto " + prod.getId() 
                    + ": " + prod.getNome() 
                    + " - R$"  + prod.getPreco() + " atualizado com sucesso");
                
            } else{
                System.out.println("Digite um id válido!!");
            }
        } while(prod == null);

        dao.fecharDAO();
        entrada.close();

    }
}
