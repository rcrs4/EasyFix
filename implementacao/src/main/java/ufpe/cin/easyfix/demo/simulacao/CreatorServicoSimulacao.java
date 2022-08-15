package ufpe.cin.easyfix.demo.simulacao;

import ufpe.cin.easyfix.demo.profissional.Profissional;
import ufpe.cin.easyfix.demo.util.TipoServico;

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
