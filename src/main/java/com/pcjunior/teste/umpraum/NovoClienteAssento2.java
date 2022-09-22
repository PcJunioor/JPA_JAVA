package com.pcjunior.teste.umpraum;

import com.pcjunior.infra.DAO;
import com.pcjunior.modelo.umpraum.Assento;
import com.pcjunior.modelo.umpraum.Cliente;

public class NovoClienteAssento2 {
    public static void main(String[] args) {
        Assento assento = new Assento("4D");
        Cliente cliente = new Cliente("Maria", assento);

        DAO<Cliente> dao = new DAO<>(Cliente.class);
        dao.incluirFull(cliente);




        
    }
    
}
