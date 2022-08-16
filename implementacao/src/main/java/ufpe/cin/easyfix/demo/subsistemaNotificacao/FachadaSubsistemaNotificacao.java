package ufpe.cin.easyfix.demo.subsistemaNotificacao;

public class FachadaSubsistemaNotificacao implements ISubsistemaNotificacao {

    @Override
    public void enviarNotificacao(Notificacao notificacao) {
        System.out.println("Notificacao enviada através do e-mail para " + notificacao.getDestino() + " com mensagem:\n" + notificacao.getMensagem());
    }
    
}
