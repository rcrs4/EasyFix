package ufpe.cin.easyfix.demo.subsistemaNotificacao;

public class SlackNotificacaoDecorator implements ISubsistemaNotificacao {
    private ISubsistemaNotificacao wrapee;

    public SlackNotificacaoDecorator(ISubsistemaNotificacao wrapee) {
        this.wrapee = wrapee;
    }

    @Override
    public void enviarNotificacao(Notificacao notificacao) {
        System.out.println("Notificacao enviada através do slack para " + notificacao.getDestino() + " com mensagem:\n" + notificacao.getMensagem());
        wrapee.enviarNotificacao(notificacao);
    }
}
