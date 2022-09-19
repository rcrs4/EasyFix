package ufpe.cin.easyfix.demo.profissional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ufpe.cin.easyfix.demo.util.TipoServico;

@Component
public class CadastroProfissional {
    @Autowired private IRepositorioProfissional repositorioProfissional;

    public void initProfissionais(){
        ArrayList<Profissional> profissionais = new ArrayList<Profissional>();
        profissionais.add(new Profissional("João", "joao@email.com", new TipoServico("Encanador"), new Float(160.9)));
        profissionais.add(new Profissional("Alberto", "alberto@email.com", new TipoServico("Pintor"), new Float(260)));
        profissionais.add(new Profissional("Emerson", "emerson@email.com", new TipoServico("Eletricista"), new Float(150.9)));
        profissionais.add(new Profissional("Victor", "victor@email.com", new TipoServico("Encanador"), new Float(199.7)));
        profissionais.add(new Profissional("José", "jose@email.com", new TipoServico("Encanador"), new Float(100.9)));
        for(Profissional profissional : profissionais){
            repositorioProfissional.save(profissional);
        }
    }

    public Optional<Profissional> buscaProfissional(String email){
        return repositorioProfissional.findById(email);

    }
}
