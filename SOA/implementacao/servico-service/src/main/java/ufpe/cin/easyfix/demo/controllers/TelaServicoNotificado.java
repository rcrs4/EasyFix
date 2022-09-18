package ufpe.cin.easyfix.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ufpe.cin.easyfix.demo.Fachada;
import ufpe.cin.easyfix.demo.servico.Servico;
import ufpe.cin.easyfix.demo.servico.Status;

@Controller
public class TelaServicoNotificado {
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
}
