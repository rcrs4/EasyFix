package br.cin.ufpe.simulacaoservice.controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.cin.ufpe.simulacaoservice.profissional.CadastroProfissional;
import br.cin.ufpe.simulacaoservice.profissional.Profissional;
import br.cin.ufpe.simulacaoservice.simulacao.CadastroServicoSimulacao;
import br.cin.ufpe.simulacaoservice.simulacao.ServicoSimulacao;

@Component
public class ControladorSimulacao {
    @Autowired private CadastroProfissional cadastroProfissional;
    @Autowired private CadastroServicoSimulacao cadastroServicoSimulacao;

    public ServicoSimulacao escolherProfissional(Profissional profissional, Long id) {
        ServicoSimulacao servicoSimulacao = cadastroServicoSimulacao.buscaSimulacao(id);
        servicoSimulacao.setProfissional(profissional);
        cadastroServicoSimulacao.armazenarSimulacao(servicoSimulacao);
        return servicoSimulacao;
    }

    public void iniciaProfissionais(){
        cadastroProfissional.initProfissionais();
    }

    public List<Profissional> buscarProfissionais(ServicoSimulacao servicoSimulacao) {
        List<Profissional> profissionais = cadastroProfissional.buscarProfissionais(servicoSimulacao);
        profissionais.removeIf((profissional) -> (profissional.getValorCobrado() > servicoSimulacao.getValorMaximo()) || (!profissional.getTipoServico().getNomeServico().equals(servicoSimulacao.getTipoServico().getNomeServico())));
        return profissionais;
    }

    public void criarSimulacao(ServicoSimulacao servicoSimulacao) {
        cadastroServicoSimulacao.armazenarSimulacao(servicoSimulacao);
    }
    
    public List<ServicoSimulacao> listarSimulacoes() {
        return cadastroServicoSimulacao.listarSimulacoes();
    }

    public Optional<Profissional> buscarProfissional(String email) {
        return cadastroProfissional.buscaProfissional(email);
    }

    public ServicoSimulacao getSimulacao(Long id){
        return cadastroServicoSimulacao.buscaSimulacao(id);
    }
}
