package ufpe.cin.easyfix.demo.subsistemaNotificacao;

public class FachadaSubsistemaNotificacao implements ISubsistemaNotificacao {

    @Override
    public void enviarNotificacao(String email, String message) {
        System.out.println("Notificacao enviada para " + email + " com mensagem:\n" + message);
    }
    
}
