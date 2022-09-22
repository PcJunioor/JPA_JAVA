package com.pcjunior.teste.basico;

import java.util.Scanner;

import com.pcjunior.infra.DAOProduto;
import com.pcjunior.modelo.basico.Produto;

public class RemoverProduto {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        DAOProduto dao = new DAOProduto();
        Produto produto = new Produto();
        
        
        do{
            System.out.print("Id: ");
            Long id = entrada.nextLong();
            produto = dao.obterPorID(id);

            if(produto != null){
                dao.removerPorID(id);
                System.out.println("id: " + produto.getId() + " - " + produto.getNome() + " Removido com sucesso!!");                
            } else{
                System.out.println("Produto não encontrado!! Digite um id válido!!!");
            }
        } while(produto == null);          
        
        dao.fecharDAO();
        entrada.close();      
       
    }
}
