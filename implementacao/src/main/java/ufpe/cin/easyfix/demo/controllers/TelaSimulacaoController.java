package ufpe.cin.easyfix.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ufpe.cin.easyfix.demo.Fachada;
import ufpe.cin.easyfix.demo.simulacao.CreatorServicoSimulacao;
import ufpe.cin.easyfix.demo.simulacao.ServicoSimulacao;
import ufpe.cin.easyfix.demo.util.TipoServico;

@Controller
public class TelaSimulacaoController {
    @Autowired Fachada fachada;

    @GetMapping(path = "/simulacao")
    public String mostrarSimulacao(Model model){
        System.out.println(fachada.listarSimulacoes());
        return "simulacaoPagina";
    }

    @PostMapping(path = "/simulacao/criar")
    public String criarSimulacao(@RequestParam(name = "tservico") String tipoServico, @RequestParam(name = "vminimo") String valorMinimo, @RequestParam(name = "vmaximo") String valorMaximo){
        CreatorServicoSimulacao creatorServicoSimulacao = new CreatorServicoSimulacao();
        ServicoSimulacao servicoSimulacao = creatorServicoSimulacao.createServicoSimulacao(new TipoServico(tipoServico),  Float.parseFloat(valorMinimo), Float.parseFloat(valorMaximo));
        fachada.criarSimulacao(servicoSimulacao);
        return "simulacaoPagina";
    }
}
