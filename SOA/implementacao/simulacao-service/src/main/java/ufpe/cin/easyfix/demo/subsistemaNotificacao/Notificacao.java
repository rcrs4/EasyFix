package ufpe.cin.easyfix.demo.subsistemaNotificacao;

public class Notificacao {
    private String assunto;
    private String destino;
    private String mensagem;

    

    public Notificacao(String destino, String mensagem) {
        this.assunto = "EasyFix";
        this.destino = destino;
        this.mensagem = mensagem;
    }
    
    public Notificacao(String destino, String mensagem, String assunto) {
        this.assunto = assunto;
        this.destino = destino;
        this.mensagem = mensagem;
    }
    
    public String getAssunto() {
        return assunto;
    }
    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }
    
    public String getDestino() {
        return destino;
    }
    public void setDestino(String destino) {
        this.destino = destino;
    }
    public String getMensagem() {
        return mensagem;
    }
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
}
