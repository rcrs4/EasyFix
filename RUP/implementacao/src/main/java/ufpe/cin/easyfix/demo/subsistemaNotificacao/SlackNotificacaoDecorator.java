package ufpe.cin.easyfix.demo.subsistemaNotificacao;
import org.springframework.beans.factory.annotation.Autowired;

public class SlackNotificacaoDecorator implements ISubsistemaNotificacao {
    private ISubsistemaNotificacao wrapee;

    public SlackNotificacaoDecorator(@Autowired ISubsistemaNotificacao wrapee) {
        this.wrapee = wrapee;
    }

    @Override
    public void enviarNotificacao(Notificacao notificacao) {
        System.out.println("Notificacao enviada através do slack para " + notificacao.getDestino() + " com mensagem:\n" + notificacao.getMensagem());
        wrapee.enviarNotificacao(notificacao);
    }
}
