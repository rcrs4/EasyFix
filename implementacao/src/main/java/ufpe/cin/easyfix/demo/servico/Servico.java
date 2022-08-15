package ufpe.cin.easyfix.demo.servico;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import ufpe.cin.easyfix.demo.cliente.Cliente;
import ufpe.cin.easyfix.demo.profissional.Profissional;
import ufpe.cin.easyfix.demo.util.Data;
import ufpe.cin.easyfix.demo.util.Endereco;
import ufpe.cin.easyfix.demo.util.TipoServico;

@Entity
public class Servico {
    @Id @GeneratedValue(strategy=GenerationType.AUTO) private Long id;

    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }
    @OneToOne(targetEntity=Cliente.class,cascade = CascadeType.ALL)
    private Cliente cliente;
    
    @OneToOne(targetEntity=Profissional.class,cascade = CascadeType.ALL)
    private Profissional profissional;
    
    @OneToOne(targetEntity=Status.class,cascade = CascadeType.ALL)
    private Status statusServico;
    
    @OneToOne(targetEntity=TipoServico.class,cascade = CascadeType.ALL)
    private TipoServico tipoServico;
    
    @OneToOne(targetEntity=Data.class,cascade = CascadeType.ALL)
    private Data data;

    public Data getData() {
        return data;
    }



    public void setData(Data data) {
        this.data = data;
    }
    @OneToOne(targetEntity=Endereco.class,cascade = CascadeType.ALL)
    private Endereco endereco;

    public Endereco getEndereco() {
        return endereco;
    }



    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    private Float valor;

    public Servico(){}

    
    
    public Servico(Cliente cliente, Profissional profissional, Status statusServico, TipoServico tipoServico, Data data,
            Endereco endereco, Float valor) {
        this.cliente = cliente;
        this.profissional = profissional;
        this.statusServico = statusServico;
        this.tipoServico = tipoServico;
        this.data = data;
        this.endereco = endereco;
        this.valor = valor;
    }



    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public Status getStatusServico() {
        return statusServico;
    }
    public void setStatusServico(Status statusServico) {
        this.statusServico = statusServico;
    }
    
    public Profissional getProfissional() {
        return profissional;
    }
    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }
    
    public TipoServico getTipoServico() {
        return tipoServico;
    }
    public void setTipoServico(TipoServico tipoServico) {
        this.tipoServico = tipoServico;
    }
    
    public Float getValor() {
        return valor;
    }
    public void setValor(Float valor) {
        this.valor = valor;
    }
}
