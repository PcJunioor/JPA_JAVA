package com.pcjunior.teste.umpraum;

import com.pcjunior.infra.DAO;
import com.pcjunior.modelo.umpraum.Assento;
import com.pcjunior.modelo.umpraum.Cliente;

public class ObterClienteAssento {
    public static void main(String[] args) {
        DAO<Cliente> daoCliente = new DAO<>(Cliente.class);
        Cliente cliente = daoCliente.obterPorID(2L);
        System.out.println(cliente.getAssento().getNome());
        daoCliente.fecharDAO();
        // RELAÇÃO BIDIRECIONAL
        DAO<Assento> daoAssento = new DAO<>(Assento.class);
        Assento assento = daoAssento.obterPorID(2L);
        System.out.println(assento.getCliente().getNome());
        daoAssento.fecharDAO();
    }
}
