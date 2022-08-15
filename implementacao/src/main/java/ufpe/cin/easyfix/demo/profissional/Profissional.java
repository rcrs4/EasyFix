package ufpe.cin.easyfix.demo.profissional;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import ufpe.cin.easyfix.demo.util.TipoServico;

@Entity
public class Profissional {
    private String nome;
    @Id private String email;

    @OneToOne(targetEntity=TipoServico.class,cascade = CascadeType.ALL)
    private TipoServico tipoServico;
    
    private Float valorCobrado;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public TipoServico getTipoServico() {
        return tipoServico;
    }
    public void setTipoServico(TipoServico tipoServico) {
        this.tipoServico = tipoServico;
    }

    public Float getValorCobrado() {
        return valorCobrado;
    }
    public void setValorCobrado(Float valorCobrado) {
        this.valorCobrado = valorCobrado;
    }
}
