package br.cin.ufpe.simulacaoservice.simulacao;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.cin.ufpe.simulacaoservice.profissional.Profissional;
import br.cin.ufpe.simulacaoservice.util.TipoServico;

@Entity
public class ServicoSimulacao implements IServicoSimulacao {
    @Id @GeneratedValue(strategy=GenerationType.AUTO) private Long id;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @OneToOne(targetEntity=TipoServico.class,cascade = CascadeType.ALL )
    private TipoServico tipoServico;
    private Float valorMinimo;
    private Float valorMaximo;
    @OneToOne(targetEntity=Profissional.class,cascade = CascadeType.ALL)
    private Profissional profissional;

    @Override
    public Profissional getProfissional() {
        return profissional;
    }
    @Override
    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }
    @Override
    public TipoServico getTipoServico() {
        return tipoServico;
    }
    @Override
    public void setTipoServico(TipoServico tipoServico) {
        this.tipoServico = tipoServico;
    }
    
    public Float getValorMinimo() {
        return valorMinimo;
    }
    public void setValorMinimo(Float valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

    public Float getValorMaximo() {
        return valorMaximo;
    }
    public void setValorMaximo(Float valorMaximo) {
        this.valorMaximo = valorMaximo;
    }
    

    ServicoSimulacao(){};

    ServicoSimulacao(TipoServico tipoServico, Float valorMinimo, Float valorMaximo){
        this.tipoServico = tipoServico;
        this.valorMaximo = valorMaximo;
        this.valorMinimo = valorMinimo;
        this.profissional = null;
    };
    
    ServicoSimulacao(TipoServico tipoServico, Float valorMinimo, Float valorMaximo, Profissional profissional){
        this.tipoServico = tipoServico;
        this.valorMaximo = valorMaximo;
        this.valorMinimo = valorMinimo;
        this.profissional = profissional;
    };

}