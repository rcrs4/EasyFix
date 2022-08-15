package ufpe.cin.easyfix.demo.simulacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CadastroServicoSimulacao {
    @Autowired private IRepositorioServicoSimulacao repositorioServicoSimulacao;

    public List<ServicoSimulacao> listarSimulacoes() {
        return repositorioServicoSimulacao.findAll();
    }

    public ServicoSimulacao armazenarSimulacao(ServicoSimulacao servicoSimulacao){
        repositorioServicoSimulacao.save(servicoSimulacao);
        return null;
    }
}
