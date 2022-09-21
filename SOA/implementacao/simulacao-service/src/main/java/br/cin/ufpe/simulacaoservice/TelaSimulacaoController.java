package br.cin.ufpe.simulacaoservice.controllers;

import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Map;

import br.cin.ufpe.simulacaoservice.Fachada;
import br.cin.ufpe.simulacaoservice.profissional.Profissional;
import org.springframework.web.bind.annotation.ModelAttribute;
import br.cin.ufpe.simulacaoservice.simulacao.CreatorServicoSimulacao;
import br.cin.ufpe.simulacaoservice.simulacao.ServicoSimulacao;
import br.cin.ufpe.simulacaoservice.util.TipoServico;

@Controller
@RequestMapping("/simulacao")
public class TelaSimulacaoController {
    @Autowired Fachada fachada;
    @Autowired private DiscoveryClient discoveryClient;

    @Value("${base_url}")
    private String baseUrl;

    @ModelAttribute("baseUrl")
    public String getUrl() {
        return this.baseUrl;
    }

    @ModelAttribute("simulacaoUrl")
    private String getServicoUrl() {
        ServiceInstance sInstance = discoveryClient.getInstances("simulacao").iterator().next();
        return String.format(
                "%s://%s:%s", sInstance.getScheme(), sInstance.getHost(), sInstance.getPort());
    }

    @GetMapping(path = "/")
    public String mostrarSimulacao(){
        fachada.iniciaProfissionais();
        return "simulacaoPagina";
    }

    @PostMapping(path = "/criar")
    public String criarSimulacao(Model model, @RequestParam(name = "tservico") String tipoServico, @RequestParam(name = "vminimo") String valorMinimo, @RequestParam(name = "vmaximo") String valorMaximo){
        CreatorServicoSimulacao creatorServicoSimulacao = new CreatorServicoSimulacao();
        ServicoSimulacao servicoSimulacao = creatorServicoSimulacao.createServicoSimulacao(new TipoServico(tipoServico),  Float.parseFloat(valorMinimo), Float.parseFloat(valorMaximo));
        fachada.criarSimulacao(servicoSimulacao);
        model.addAttribute("profissionais", fachada.buscarProfissionais(servicoSimulacao));
        model.addAttribute("simulacao", servicoSimulacao);
        return "escolherProfissional";
    }

    @PostMapping(path = "/enviar")
    public String escolherProfissional(Model model, @RequestParam(name="eprofissional") String email, @RequestParam(name="idSimulacao") String id){
        Optional<Profissional> profissional = fachada.buscaProfissional(email);
        ServicoSimulacao servicoSimulacao = null;
        if(profissional.isPresent()){
            servicoSimulacao = fachada.escolherProfissional(profissional.get(), Long.parseLong(id));
        }
        model.addAttribute("simulacao", servicoSimulacao);
        return "mostrarSimulacao";
    }

    @GetMapping(path="/listar")
    public String listarSimulacoes(Model model){
        model.addAttribute("simulacoes", fachada.listarSimulacoes());
        return "listarSimulacoes";
    }

    @GetMapping("/{id}/infos")
    @ResponseBody
    public Map<String, ServicoSimulacao> getSimulacao(@PathVariable Long id){
        return Collections.singletonMap("infos", fachada.getSimulacao(id));
    }

}
