package ufpe.cin.easyfix.demo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ufpe.cin.easyfix.demo.profissional.CadastroProfissional;
import ufpe.cin.easyfix.demo.profissional.Profissional;
import ufpe.cin.easyfix.demo.simulacao.CadastroServicoSimulacao;
import ufpe.cin.easyfix.demo.simulacao.ServicoSimulacao;

@Component
public class ControladorSimulacao {
    @Autowired private CadastroProfissional cadastroProfissional;
    @Autowired private CadastroServicoSimulacao cadastroServicoSimulacao;

    public ServicoSimulacao escolherProfissional(Profissional profissional) {
        return null;
    }

    public List<Profissional> buscarProfissionais(ServicoSimulacao servicoSimulacao) {
        List<Profissional> profissionais = cadastroProfissional.buscarProfissionais(servicoSimulacao);
        profissionais.removeIf((profissional) -> profissional.getTipoServico() != servicoSimulacao.getTipoServico() && 
                                profissional.getValorCobrado() > servicoSimulacao.getValorMaximo() && 
                                profissional.getValorCobrado() < servicoSimulacao.getValorMinimo());
        return profissionais;
    }

    public void criarSimulacao(ServicoSimulacao servicoSimulacao) {
        cadastroServicoSimulacao.armazenarSimulacao(servicoSimulacao);
    }
    
    public List<ServicoSimulacao> listarSimulacoes() {
        return cadastroServicoSimulacao.listarSimulacoes();
    }
}
