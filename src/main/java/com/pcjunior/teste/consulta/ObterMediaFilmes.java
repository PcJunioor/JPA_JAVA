package com.pcjunior.teste.consulta;

import java.util.ArrayList;
import java.util.List;

import com.pcjunior.infra.DAO;
import com.pcjunior.modelo.consulta.NotaFilme;

public class ObterMediaFilmes {
    public static void main(String[] args) {
        DAO<NotaFilme> dao = new DAO<>(NotaFilme.class);
        List<NotaFilme> media = new ArrayList<>(); 
        media = dao.consultar("obterMediaGeralDosFilmes");
        System.out.println(media);
    }
}
