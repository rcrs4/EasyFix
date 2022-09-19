package br.cin.ufpe.simulacaoservice.util;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Data {
    @Id @GeneratedValue(strategy=GenerationType.AUTO) private Long id;

    private int dia;
    private int mes;
    private int ano;
    
    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
    
    public Data() {
    }

    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    public int getMes() {
        return mes;
    }
    public void setMes(int mes) {
        this.mes = mes;
    }
    
    public int getDia() {
        return dia;
    }
    public void setDia(int dia) {
        this.dia = dia;
    }

    public String toString(){
        return String.valueOf(this.dia) + '/' + String.valueOf(this.mes) + '/' + String.valueOf(this.ano);
    }
    
}
