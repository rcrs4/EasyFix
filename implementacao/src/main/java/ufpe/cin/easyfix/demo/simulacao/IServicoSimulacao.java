package ufpe.cin.easyfix.demo.simulacao;

import ufpe.cin.easyfix.demo.profissional.Profissional;
import ufpe.cin.easyfix.demo.util.TipoServico;

public interface IServicoSimulacao {
    public Profissional getProfissional();
    public void setProfissional(Profissional profissional);

    public TipoServico getTipoServico();
    public void setTipoServico(TipoServico tipoServico);
    
}
