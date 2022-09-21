package ufpe.cin.easyfix.demo.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ufpe.cin.easyfix.demo.Fachada;
import ufpe.cin.easyfix.demo.cliente.Cliente;
import ufpe.cin.easyfix.demo.profissional.Profissional;
import ufpe.cin.easyfix.demo.servico.Servico;
import ufpe.cin.easyfix.demo.servico.Status;
import ufpe.cin.easyfix.demo.util.Data;
import ufpe.cin.easyfix.demo.util.Endereco;

@Controller
@RequestMapping("/servico")
public class TelaServico {
    @Autowired Fachada fachada;
    @Autowired private DiscoveryClient discoveryClient;

    @Value("${base_url}")
    private String baseUrl;

    @ModelAttribute("baseUrl")
    public String getUrl() {
        return this.baseUrl;
    }

    @ModelAttribute("servicoUrl")
    private String getServicoUrl() {
        ServiceInstance sInstance = discoveryClient.getInstances("servico").iterator().next();
        return String.format(
                "%s://%s:%s", sInstance.getScheme(), sInstance.getHost(), sInstance.getPort());
    }

    @GetMapping(path = "/servicoNotificado")
    public String mostrarServicoNotificado(Model model){
        Long id = fachada.iniciaServicos();
        Servico servico = fachada.verInformacaoServico(id);
        model.addAttribute("servico", servico);
        return "mostrarServico";
    }

    @PostMapping(path = "/servicoNotificado/aceite")
    public String aceitarServicoNotificado(@RequestParam(name = "group") String resposta, @RequestParam(name="id") Long idServico){
        Status status = new Status(resposta);
        fachada.mudarStatusServico(status, idServico);
        return "telaPosAceite";
    }

    @GetMapping(path="/contratacao/{id}")
    public String selecionarDataEndereco(Model model, @PathVariable Long id){
        model.addAttribute("datas", fachada.iniciarContratacao(id));
        model.addAttribute("profissional", fachada.buscaProfissionalSimulacao(id));
        model.addAttribute("id", id);
        return "escolherDataContratacao";
    }

    @PostMapping(path="contratacao/{id}/efetuar")
    public String efetuarContratacao(@RequestParam(name="data") String data,@RequestParam(name="lougradouro") String lougradouro,@RequestParam(name="numero") int numero,@RequestParam(name="cidade") String cidade,@RequestParam(name="bairro") String bairro,@RequestParam(name="estado") String estado, @PathVariable Long id){
        Endereco endereco = new Endereco(lougradouro, numero, cidade, bairro, estado);
        Profissional profissional = fachada.buscaProfissionalSimulacao(id);
        Servico servico = new Servico(new Cliente("Thalisson", "tmt2@cin.ufpe.br"), profissional, new Status("Aguardando confirmação"), profissional.getTipoServico(), Data.fromString(data),
        endereco, profissional.getValorCobrado());
        fachada.criarServico(servico);
        return "efetuarContratacao";
    }

    @GetMapping(path="listar")
    public String listarServicos(Model model){
        model.addAttribute("servicos", fachada.listarServicos());
        return "listarServicos";
    }

}
