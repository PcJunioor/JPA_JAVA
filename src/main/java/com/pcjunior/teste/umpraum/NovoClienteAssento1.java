package com.pcjunior.teste.umpraum;

import com.pcjunior.infra.DAO;
import com.pcjunior.modelo.umpraum.Assento;
import com.pcjunior.modelo.umpraum.Cliente;

public class NovoClienteAssento1 {
    public static void main(String[] args) {
        Assento assento = new Assento("22C");
        Cliente cliente = new Cliente("Ana", assento );
        DAO<Object> dao = new DAO<>();
        dao.abrirTransacao().incluir(assento).incluir(cliente).fecharTransacao().fecharDAO();



         
    }
    
}
