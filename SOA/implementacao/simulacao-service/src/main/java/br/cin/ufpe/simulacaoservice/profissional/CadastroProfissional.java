package br.cin.ufpe.simulacaoservice.profissional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.cin.ufpe.simulacaoservice.simulacao.ServicoSimulacao;
import br.cin.ufpe.simulacaoservice.util.TipoServico;

@Component
public class CadastroProfissional {
    @Autowired private IRepositorioProfissional repositorioProfissional;

    public void initProfissionais(){
        ArrayList<Profissional> profissionais = new ArrayList<Profissional>();
        profissionais.add(new Profissional("João", "rcrs4@cin.ufpe.br", new TipoServico("Encanador"), new Float(160.9)));
        profissionais.add(new Profissional("Alberto", "rcrs5@cin.ufpe.br", new TipoServico("Pintor"), new Float(260)));
        profissionais.add(new Profissional("Emerson", "rcrs6@cin.ufpe.br", new TipoServico("Eletricista"), new Float(150.9)));
        profissionais.add(new Profissional("Victor", "rcrs7@cin.ufpe.br", new TipoServico("Encanador"), new Float(199.7)));
        profissionais.add(new Profissional("José", "rcrs8@cin.ufpe.br", new TipoServico("Encanador"), new Float(100.9)));
        for(Profissional profissional : profissionais){
            repositorioProfissional.save(profissional);
        }
    }

    public Optional<Profissional> buscaProfissional(String email){
        return repositorioProfissional.findById(email);

    }

    public List<Profissional> buscarProfissionais(ServicoSimulacao servicoSimulacao){
        return repositorioProfissional.findAll();
    }
}
