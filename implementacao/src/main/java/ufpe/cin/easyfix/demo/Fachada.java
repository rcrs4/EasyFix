package ufpe.cin.easyfix.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ufpe.cin.easyfix.demo.controladores.ControladorServicoNotificado;
import ufpe.cin.easyfix.demo.controladores.ControladorSimulacao;
import ufpe.cin.easyfix.demo.profissional.Profissional;
import ufpe.cin.easyfix.demo.servico.Servico;
import ufpe.cin.easyfix.demo.servico.Status;
import ufpe.cin.easyfix.demo.simulacao.ServicoSimulacao;

@Component
public class Fachada {
    @Autowired private ControladorSimulacao controladorSimulacao;
    @Autowired private ControladorServicoNotificado controladorServicoNotificado;

    public List<Profissional> buscarProfissionais(ServicoSimulacao servicoSimulacao){
        return controladorSimulacao.buscarProfissionais(servicoSimulacao);
    }
   
    public Optional<Profissional> buscaProfissional(String email){
        return controladorSimulacao.buscarProfissional(email);
    }

    public void iniciaProfissionais(){
        controladorSimulacao.iniciaProfissionais();
    }

    public Long iniciaServicos(){
        return controladorServicoNotificado.iniciaServicos();
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

    public Servico verInformacaoServico(Long id){
        return controladorServicoNotificado.verInformacaoServico(id);
    }

    public Servico mudarStatusServico(Status status, Long idServico){
        return controladorServicoNotificado.mudarStatusServico(status, idServico);
    }
}
