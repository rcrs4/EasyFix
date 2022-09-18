package ufpe.cin.easyfix.demo.simulacao;

import ufpe.cin.easyfix.demo.profissional.Profissional;
import ufpe.cin.easyfix.demo.util.TipoServico;

public abstract class Creator {
    public abstract ServicoSimulacao createServicoSimulacao(TipoServico tipoServico, Float valorMinimo, Float valorMaximo);
    public abstract ServicoSimulacao createServicoSimulacao(TipoServico tipoServico, Float valorMinimo, Float valorMaximo, Profissional profissional);
}
