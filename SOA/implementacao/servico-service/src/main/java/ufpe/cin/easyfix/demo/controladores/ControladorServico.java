package ufpe.cin.easyfix.demo.controladores;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ufpe.cin.easyfix.demo.profissional.Profissional;
import ufpe.cin.easyfix.demo.servico.CadastroServico;
import ufpe.cin.easyfix.demo.servico.Servico;
import ufpe.cin.easyfix.demo.servico.Status;
import ufpe.cin.easyfix.demo.simulacaoService.ISimulacaoService;
import ufpe.cin.easyfix.demo.subsistemaNotificacao.FachadaSubsistemaNotificacao;
import ufpe.cin.easyfix.demo.subsistemaNotificacao.ISubsistemaNotificacao;
import ufpe.cin.easyfix.demo.subsistemaNotificacao.Notificacao;
import ufpe.cin.easyfix.demo.subsistemaNotificacao.SlackNotificacaoDecorator;
import ufpe.cin.easyfix.demo.util.Data;

@Component
public class ControladorServico {

    @Autowired private CadastroServico cadastroServico;
    @Autowired private FachadaSubsistemaNotificacao fachadaNotificacao;
    @Autowired private ISimulacaoService simulacaoServiceAPI;

    public Servico verInformacaoServico(Long id) {
        return cadastroServico.buscarServico(id);
    }

    public Long iniciaServicos() {
        return cadastroServico.initServicos();
    }

    public Servico mudarStatusServico(Status status, Long idServico) {
        ISubsistemaNotificacao subsistemaNotificacao = new SlackNotificacaoDecorator(fachadaNotificacao);
        Servico servico = cadastroServico.atualizarServico(status, idServico);
        Notificacao notificacao = new Notificacao(servico.getCliente().getEmail(), servico.getStatusServico().getStatusMessage(), "Retorno da contratação");
        subsistemaNotificacao.enviarNotificacao(notificacao);
        return servico;
    }

    public List<Data> iniciarContratacao(Long id) {
        List<Servico> servicos = cadastroServico.buscarServicoPorProfissional(buscaProfissionalSimulacao(id));
        List<Data> datas = filtrarDatasDisponiveis(servicos);
        return datas;
    }

    public Profissional buscaProfissionalSimulacao(Long id){
        Map simulacao = simulacaoServiceAPI.getSimulacao(id);
        return Profissional.fromJson((Map) simulacao.get("profissional"));
    }
    
    public List<Data> filtrarDatasDisponiveis(List<Servico> servicos){
        List<Data> datasDisponiveis = Arrays.asList(new Data(18, 9, 2022), new Data(19, 9, 2022),new Data(20, 9, 2022),new Data(21, 9, 2022),new Data(22, 9, 2022),new Data(23, 9, 2022),new Data(24, 9, 2022),new Data(25, 9, 2022));
        
        for(Servico servico: servicos){

            datasDisponiveis = datasDisponiveis.stream().filter(data -> !(servico.getData().getAno() == data.getAno() && servico.getData().getMes() == data.getMes() && servico.getData().getDia() == data.getDia())).collect(Collectors.toList());
        
        }
        return datasDisponiveis;
    }

    public Servico criarServico(Servico servico) {
        cadastroServico.armazenarServico(servico);
        //Notificacao notificacao = new Notificacao(servico.getProfissional().getEmail(), servico.getStatusServico().getStatusMessage(), "Pedido de contratação");
        //enviarNotificacao(notificacao);
        return servico;
    }

    public void enviarNotificacao(Notificacao notificacao){
        fachadaNotificacao.enviarNotificacao(notificacao);
    }

    public List<Servico> listarServicos() {
        return cadastroServico.listarServicos();
    }
}
