package com.pcjunior.modelo.composicao;

import javax.persistence.Embeddable;

@Embeddable
public class Endereco {

    private String logradouro;
    private String complemento;
    



    public Endereco() {
    }
    
    public String getLogradouro() {
        return logradouro;
    }
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    public String getComplemento() {
        return complemento;
    }
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    
}
