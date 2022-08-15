package ufpe.cin.easyfix.demo.subsistemaNotificacao;

public class NotificacaoDecorator implements ISubsistemaNotificacao {
    private ISubsistemaNotificacao wrapee;

    NotificacaoDecorator(ISubsistemaNotificacao wrapee){
        this.wrapee = wrapee;
    }

    @Override
    public void enviarNotificacao(Notificacao notificacao) {
        wrapee.enviarNotificacao(notificacao);
    }
    
}
