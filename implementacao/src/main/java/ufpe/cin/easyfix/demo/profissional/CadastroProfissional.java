package ufpe.cin.easyfix.demo.profissional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ufpe.cin.easyfix.demo.simulacao.ServicoSimulacao;

@Component
public class CadastroProfissional {
    @Autowired private IRepositorioProfissional repositorioProfissional;

    
    public List<Profissional> buscarProfissionais(ServicoSimulacao servicoSimulacao){
        return repositorioProfissional.findAll();
    }
}
