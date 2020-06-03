package  br.com.jornada.pedido.controller;

import br.com.jornada.pedido.domain.Pedido;
import br.com.jornada.pedido.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService service;
//    @Autowired
//    private RestTemplate restTemplate;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pedido> findById(@PathVariable Long id){
        Optional<Pedido> pedido = service.getById(id);
        //TODO: buscar o pedido por id no MS de pedido usando RestTemplate
        //Criar dto com os dados que mostraria na tela (nome de produto e cliente)
        if (pedido.isPresent()) {
            return new ResponseEntity(pedido, HttpStatus.OK);
        }else{
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Pedido> findAll(){
        List<Pedido> all = service.getAll();
        //TODO: buscar o pedido por id no MS de pedido usando RestTemplate
        //Criar dto com os dados que mostraria na tela (nome de produto e cliente)

        return all;
    }

    //TODO: Implementar POST pedido
/*
//passar um post ao api-gateway
            Map<String, Object> result =
                    restTemplate.getForObject("http://localhost:8200/inventory/check/{itemId}/", Map.class, params);
                if (result.containsKey("errorId")) {
                    if ("SVR_URI_010".equals(result.get("errorId"))) {
                        throw new ItemNotFoundException();
                    }
                }

                if (Integer.parseInt(result.get("unit").toString()) < orderedItem.getUnit()) {
                    throw new ItemUnitLackingException();
                }
                orderedItem.setVersionno(Long.parseLong(result.get("versionno").toString()));
 */
}