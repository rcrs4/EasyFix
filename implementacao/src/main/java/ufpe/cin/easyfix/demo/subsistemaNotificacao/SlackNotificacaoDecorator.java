package ufpe.cin.easyfix.demo.subsistemaNotificacao;

public class SlackNotificacaoDecorator extends NotificacaoDecorator {

    public SlackNotificacaoDecorator(ISubsistemaNotificacao wrapee) {
        super(wrapee);
    }
    @Override
    public void enviarNotificacao(Notificacao notificacao) {
        System.out.println("Notificacao enviada através do slack para " + notificacao.getDestino() + " com mensagem:\n" + notificacao.getMensagem());
        super.enviarNotificacao(notificacao);
    }
}
