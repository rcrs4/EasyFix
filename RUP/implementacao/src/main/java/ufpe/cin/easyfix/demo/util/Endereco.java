package ufpe.cin.easyfix.demo.util;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Endereco {

    @Id @GeneratedValue(strategy=GenerationType.AUTO) private Long id;
    
    private String logradouro;
    private int number;
    private String cidade;
    private String bairro;
    private String estado;

    

    public Endereco(String logradouro, int number, String cidade, String bairro, String estado) {
        this.logradouro = logradouro;
        this.number = number;
        this.cidade = cidade;
        this.bairro = bairro;
        this.estado = estado;
    }

    public Endereco() {
    }

    public String getLogradouro() {
        return logradouro;
    }
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String formatEndereco(){
        return this.logradouro + ", " + String.valueOf(this.number) + " - " +
                this.bairro + " - " + this.cidade + " - " + this.estado;
    }
}
