package com.pcjunior.teste.muitospramuitos;

import com.pcjunior.infra.DAO;
import com.pcjunior.modelo.muitospramuitos.Sobrinho;
import com.pcjunior.modelo.muitospramuitos.Tio;

public class NovoTioSobrinho {
    public static void main(String[] args) {
        Tio tio1 = new Tio("Luiz");
        Tio tia2 = new Tio("Maria");

        Sobrinho sobrinho1 = new Sobrinho("Davi");
        Sobrinho sobrinha2 = new Sobrinho("Larissa");

        tio1.getSobrinhos().add(sobrinho1);
        sobrinho1.getTios().add(tio1);

        tio1.getSobrinhos().add(sobrinha2);
        sobrinha2.getTios().add(tio1);

        tia2.getSobrinhos().add(sobrinho1);
        sobrinho1.getTios().add(tia2);

        tia2.getSobrinhos().add(sobrinha2);
        sobrinha2.getTios().add(tia2);

        DAO<Object> dao = new DAO<>();
        
        // dao.abrirTransacao().incluir(tio1).incluir(tia2)
        //     .incluir(sobrinho1).incluir(sobrinha2)
        //     .fecharTransacao().fecharDAO();


        // AO FAZER DESSA FORMA TEM QUE INCLUIR NA RELAÇÃO(MANYToONE O "CASCADETYPE")
        // PARA PERSISTIR UM OJETO QUE FAZ REFERÊNCIA A OUTRO QUE AINDA NÃO ESTÁ PERSISTIDO.
        dao.incluirFull(tio1).incluirFull(tia2)
            .incluirFull(sobrinho1).incluirFull(sobrinha2);


        dao.fecharDAO();   
       
    }
    
}
