package ufpe.cin.easyfix.demo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ufpe.cin.easyfix.demo.servico.CadastroServico;
import ufpe.cin.easyfix.demo.servico.Servico;
import ufpe.cin.easyfix.demo.servico.Status;
import ufpe.cin.easyfix.demo.subsistemaNotificacao.FachadaSubsistemaNotificacao;
import ufpe.cin.easyfix.demo.subsistemaNotificacao.ISubsistemaNotificacao;

@Component
public class ControladorServicoNotificado {

    @Autowired private CadastroServico cadastroServico;
    private ISubsistemaNotificacao subsistemaNotificacao = new FachadaSubsistemaNotificacao();

    public Servico verInformacaoServico(Long id) {
        return cadastroServico.buscarServico(id);
    }

    public Long iniciaServicos() {
        return cadastroServico.initServicos();
    }

    public Servico mudarStatusServico(Status status, Long idServico) {
        Servico servico = cadastroServico.atualizarServico(status, idServico);
        subsistemaNotificacao.enviarNotificacao(servico.getCliente().getEmail(), servico.getStatusServico().getStatusMessage());
        return servico;
    }
    
}
