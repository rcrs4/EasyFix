package ufpe.cin.easyfix.demo.servico;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Status {
    @Id @GeneratedValue(strategy=GenerationType.AUTO) private Long id;
    
    private String statusServico;

    public Status(String statusServico) {
        this.statusServico = statusServico;
    }

    public Status() {
    }

    public String getStatusServico() {
        return statusServico;
    }

    public void setStatusServico(String statusServico) {
        this.statusServico = statusServico;
    }

    public String getStatusMessage(){
        return "Seu serviço foi atualizado, o novo estado é: " + this.getStatusServico();
    }
}
