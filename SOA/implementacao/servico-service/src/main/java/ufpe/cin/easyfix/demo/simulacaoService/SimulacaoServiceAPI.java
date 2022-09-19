package ufpe.cin.easyfix.demo.simulacaoService;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class SimulacaoServiceAPI implements ISimulacaoService{

    @Autowired WebClient.Builder wBuilder;

    public WebClient client(){
        return wBuilder.baseUrl("lb://simulacao").build();
    }

    @Override
    public Map getSimulacao(Long simulacaoId) {
        Map map = (Map) client().get().uri("/simulacao/{id}/infos", simulacaoId).retrieve().bodyToMono(Map.class).block().get("infos");
        return map;
    }
    
}
