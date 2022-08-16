package ufpe.cin.easyfix.demo.commandNotificacao;

import ufpe.cin.easyfix.demo.subsistemaNotificacao.ISubsistemaNotificacao;
import ufpe.cin.easyfix.demo.subsistemaNotificacao.Notificacao;

public class NotificacaoCommand implements Command{
    private ISubsistemaNotificacao subsistemaNotificacao;
    
    public NotificacaoCommand(ISubsistemaNotificacao subsistemaNotificacao) {
        this.subsistemaNotificacao = subsistemaNotificacao;
    }

    @Override
    public void execute(Notificacao notificacao) {
        this.subsistemaNotificacao.enviarNotificacao(notificacao);
    }
    
}
