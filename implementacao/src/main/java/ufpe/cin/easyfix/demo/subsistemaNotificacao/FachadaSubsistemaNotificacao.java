package ufpe.cin.easyfix.demo.subsistemaNotificacao;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FachadaSubsistemaNotificacao implements ISubsistemaNotificacao { 
    @Autowired private JavaMailSender javaMailSender;
	
    @Override
    public void enviarNotificacao(Notificacao notificacao) {
        System.out.println("Notificacao enviada através do e-mail para " + notificacao.getDestino() + " com mensagem:\n" + notificacao.getMensagem());

        SimpleMailMessage msg = new SimpleMailMessage();
        
        msg.setSubject(notificacao.getAssunto());
        msg.setTo(notificacao.getDestino());
        msg.setText(notificacao.getMensagem());

        javaMailSender.send(msg);
    }
}
