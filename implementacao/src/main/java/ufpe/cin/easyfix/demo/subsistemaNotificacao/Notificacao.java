package ufpe.cin.easyfix.demo.subsistemaNotificacao;

public class Notificacao {
    private String destino;
    private String mensagem;

    

    public Notificacao(String destino, String mensagem) {
        this.destino = destino;
        this.mensagem = mensagem;
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
