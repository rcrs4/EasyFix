package br.cin.ufpe.simulacaoservice.util;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TipoServico {
    @Id @GeneratedValue(strategy=GenerationType.AUTO) private Long id;
    private String nomeServico;

    public String getNomeServico() {
        return nomeServico;
    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }

    public TipoServico(){};

    public TipoServico(String nome){
        this.nomeServico = nome;
    }
}
