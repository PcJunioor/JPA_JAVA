package com.pcjunior.modelo.consulta;

import javax.persistence.Transient;


public class NotaFilme {

    @Transient
    private double media;

    
    

    public NotaFilme() {
    }

    public NotaFilme(double media) {
        this.media = media;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }
    
    
}
