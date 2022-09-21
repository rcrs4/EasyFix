package br.cin.ufpe.simulacaoservice.simulacao;

import br.cin.ufpe.simulacaoservice.profissional.Profissional;
import br.cin.ufpe.simulacaoservice.util.TipoServico;

public abstract class Creator {
    public abstract ServicoSimulacao createServicoSimulacao(TipoServico tipoServico, Float valorMinimo, Float valorMaximo);
    public abstract ServicoSimulacao createServicoSimulacao(TipoServico tipoServico, Float valorMinimo, Float valorMaximo, Profissional profissional);
}
