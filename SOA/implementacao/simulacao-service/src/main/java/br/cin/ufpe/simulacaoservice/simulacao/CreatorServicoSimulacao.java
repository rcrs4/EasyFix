package br.cin.ufpe.simulacaoservice.simulacao;

import br.cin.ufpe.simulacaoservice.profissional.Profissional;
import br.cin.ufpe.simulacaoservice.util.TipoServico;

public class CreatorServicoSimulacao extends Creator {

    @Override
    public ServicoSimulacao createServicoSimulacao(TipoServico tipoServico, Float valorMinimo, Float valorMaximo) {
        return new ServicoSimulacao(
             tipoServico,
             valorMinimo,
             valorMaximo
        );
    }

    @Override
    public ServicoSimulacao createServicoSimulacao(TipoServico tipoServico, Float valorMinimo, Float valorMaximo, Profissional profissional) {
        return new ServicoSimulacao(
             tipoServico,
             valorMinimo,
             valorMaximo,
             profissional
        );
    }
    
}
