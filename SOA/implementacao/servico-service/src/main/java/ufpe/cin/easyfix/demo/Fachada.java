package ufpe.cin.easyfix.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ufpe.cin.easyfix.demo.controladores.ControladorServico;
import ufpe.cin.easyfix.demo.profissional.Profissional;
import ufpe.cin.easyfix.demo.servico.Servico;
import ufpe.cin.easyfix.demo.servico.Status;
import ufpe.cin.easyfix.demo.util.Data;

@Component
public class Fachada {

    @Autowired private ControladorServico controladorServico;

    public Long iniciaServicos(){
        return controladorServico.iniciaServicos();
    }

    public Servico verInformacaoServico(Long id){
        return controladorServico.verInformacaoServico(id);
    }

    public Servico mudarStatusServico(Status status, Long idServico){
        return controladorServico.mudarStatusServico(status, idServico);
    }

    public List<Data> iniciarContratacao(Long id){
        return controladorServico.iniciarContratacao(id);
    }

    public Profissional buscaProfissionalSimulacao(Long id){
        return controladorServico.buscaProfissionalSimulacao(id);
    }

    public Servico criarServico(Servico servico){
        return controladorServico.criarServico(servico);
    }

    public List<Servico> listarServicos() {
        return controladorServico.listarServicos();
    }
}
