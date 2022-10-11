package com.pcjunior.teste.heranca;

import com.pcjunior.infra.DAO;
import com.pcjunior.modelo.heranca.Aluno;
import com.pcjunior.modelo.heranca.AlunoBolsista;

public class NovoAluno {
    public static void main(String[] args) {
        DAO<Aluno> alunoDAO = new DAO<>();

        Aluno aluno1 = new Aluno(123L, "João");

        AlunoBolsista aluno2 = new AlunoBolsista(124L, "Maria", 1000);

        alunoDAO.incluirFull(aluno1);
        alunoDAO.incluirFull(aluno2);

        alunoDAO.fecharDAO();


    }
    
}
