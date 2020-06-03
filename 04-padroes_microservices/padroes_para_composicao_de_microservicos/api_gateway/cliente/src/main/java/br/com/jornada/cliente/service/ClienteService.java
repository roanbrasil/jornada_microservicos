package br.com.jornada.cliente.service;

import br.com.jornada.cliente.domain.Cliente;
import br.com.jornada.cliente.domain.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    public List<Cliente> getAll(){
      return (List<Cliente>) repository.findAll();
    }
    public Optional<Cliente> getById(Long id){
        return repository.findById(id);
    }
    public Cliente save(Cliente cliente){
        return repository.save(cliente);
    }
}
