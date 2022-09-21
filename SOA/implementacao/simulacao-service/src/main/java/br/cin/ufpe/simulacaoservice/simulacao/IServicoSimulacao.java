package br.cin.ufpe.simulacaoservice.simulacao;

import br.cin.ufpe.simulacaoservice.profissional.Profissional;
import br.cin.ufpe.simulacaoservice.util.TipoServico;

public interface IServicoSimulacao {
    public Profissional getProfissional();
    public void setProfissional(Profissional profissional);

    public TipoServico getTipoServico();
    public void setTipoServico(TipoServico tipoServico);
    
}
