package ufpe.cin.easyfix.demo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ufpe.cin.easyfix.demo.Fachada;
import ufpe.cin.easyfix.demo.profissional.Profissional;
import ufpe.cin.easyfix.demo.simulacao.CreatorServicoSimulacao;
import ufpe.cin.easyfix.demo.simulacao.ServicoSimulacao;
import ufpe.cin.easyfix.demo.util.TipoServico;

@Controller
public class TelaSimulacaoController {
    @Autowired Fachada fachada;

    @GetMapping(path = "/simulacao")
    public String mostrarSimulacao(){
        fachada.iniciaProfissionais();
        return "simulacaoPagina";
    }

    @PostMapping(path = "/simulacao/criar")
    public String criarSimulacao(Model model, @RequestParam(name = "tservico") String tipoServico, @RequestParam(name = "vminimo") String valorMinimo, @RequestParam(name = "vmaximo") String valorMaximo){
        CreatorServicoSimulacao creatorServicoSimulacao = new CreatorServicoSimulacao();
        ServicoSimulacao servicoSimulacao = creatorServicoSimulacao.createServicoSimulacao(new TipoServico(tipoServico),  Float.parseFloat(valorMinimo), Float.parseFloat(valorMaximo));
        fachada.criarSimulacao(servicoSimulacao);
        model.addAttribute("profissionais", fachada.buscarProfissionais(servicoSimulacao));
        model.addAttribute("simulacao", servicoSimulacao);
        return "escolherProfissional";
    }

    @PostMapping(path = "/simulacao/enviar")
    public String escolherProfissional(Model model, @RequestParam(name="eprofissional") String email, @RequestParam(name="idSimulacao") String id){
        Optional<Profissional> profissional = fachada.buscaProfissional(email);
        ServicoSimulacao servicoSimulacao = null;
        if(profissional.isPresent()){
            servicoSimulacao = fachada.escolherProfissional(profissional.get(), Long.parseLong(id));
        }
        model.addAttribute("simulacao", servicoSimulacao);
        return "mostrarSimulacao";
    }
}
