package ufpe.cin.easyfix.demo.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ufpe.cin.easyfix.demo.cliente.Cliente;
import ufpe.cin.easyfix.demo.profissional.Profissional;
import ufpe.cin.easyfix.demo.util.Data;
import ufpe.cin.easyfix.demo.util.Endereco;
import ufpe.cin.easyfix.demo.util.TipoServico;

@Component
public class CadastroServico {

    @Autowired private IRepositorioServico repositorioServico;

    public Long initServicos(){
        List<Servico> listServico;
        listServico = repositorioServico.findAll();
        if(listServico.isEmpty()){
            Profissional profissional = new Profissional("João", "joao@email.com", new TipoServico("Eletricista"), new Float(160.9));
            Servico servico = new Servico(new Cliente("Thalisson", "thalisson@email.com"), profissional, new Status("desaprovado"), new TipoServico("Eletricista"), new Data(20, 8, 2022),
            new Endereco("Rua dois", 2, "Recife", "Gracas", "Pernambuco"), profissional.getValorCobrado());
            repositorioServico.save(servico);
            
            return servico.getId();
        }
        return listServico.get(0).getId();
    }

    public Servico buscarServico(Long id){
        return repositorioServico.getReferenceById(id);
    }

    public void armazenarServico(Servico servico){
        repositorioServico.save(servico);
    }

    public Servico atualizarServico(Status status, Long idServico){
        Servico servico = buscarServico(idServico);
        servico.setStatusServico(status);
        return servico;
    }
}
