package ufpe.cin.easyfix.demo.profissional;

import java.util.Map;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import ufpe.cin.easyfix.demo.util.TipoServico;

@Entity
public class Profissional {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String nome;
    private String email;

    @OneToOne(targetEntity=TipoServico.class,cascade = CascadeType.ALL)
    private TipoServico tipoServico;
    
    private Float valorCobrado;

    Profissional (){

    }

    public Profissional (String nome, String email, TipoServico tipoServico, Float valorCobrado){
        this.nome = nome;
        this.email = email;
        this.tipoServico = tipoServico;
        this.valorCobrado = valorCobrado;
    }

    public static Profissional fromJson(Map mapProfissional){
        return new Profissional(mapProfissional.get("nome").toString(), mapProfissional.get("email").toString(), TipoServico.fromJson((Map) mapProfissional.get("tipoServico")), Float.parseFloat(mapProfissional.get("valorCobrado").toString()));
    }

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
