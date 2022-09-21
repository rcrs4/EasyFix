package br.cin.ufpe.simulacaoservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.cin.ufpe.simulacaoservice.controladores.ControladorSimulacao;
import br.cin.ufpe.simulacaoservice.profissional.Profissional;
import br.cin.ufpe.simulacaoservice.simulacao.ServicoSimulacao;

@Component
public class Fachada {
    @Autowired private ControladorSimulacao controladorSimulacao;

    public List<Profissional> buscarProfissionais(ServicoSimulacao servicoSimulacao){
        return controladorSimulacao.buscarProfissionais(servicoSimulacao);
    }
   
    public Optional<Profissional> buscaProfissional(String email){
        return controladorSimulacao.buscarProfissional(email);
    }

    public void iniciaProfissionais(){
        controladorSimulacao.iniciaProfissionais();
    }

    public List<ServicoSimulacao> listarSimulacoes(){
        return controladorSimulacao.listarSimulacoes();
    }

    public void criarSimulacao(ServicoSimulacao servicoSimulacao) {
        controladorSimulacao.criarSimulacao(servicoSimulacao);
    }

    public ServicoSimulacao escolherProfissional(Profissional profissional, Long id) {
        return controladorSimulacao.escolherProfissional(profissional, id);
    }
    
    public ServicoSimulacao getSimulacao(Long id){
        return controladorSimulacao.getSimulacao(id);
    }

}
