package br.com.jornada.cliente.controller;

import br.com.jornada.cliente.domain.Cliente;
import br.com.jornada.cliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService service;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> findById(@PathVariable Long id){
        Optional<Cliente> cli = service.getById(id);
        if (cli.isPresent()) {
            return new ResponseEntity(cli,HttpStatus.OK);
        }else{
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cliente> findAll(){
        return service.getAll();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Cliente save(@RequestBody Cliente cliente){
        return service.save(cliente);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> update(@PathVariable Long id, @RequestBody Cliente cliente){
        Optional<Cliente> cli = service.getById(id);
        if (cli.isPresent()) {
            Cliente c = cli.get();
            c.setIdade(cliente.getIdade());
            c.setNome(cliente.getNome());
            return new ResponseEntity(service. save(c),HttpStatus.OK);
        }else{
          return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
