package  br.com.jornada.pedido.service;

import br.com.jornada.pedido.domain.Pedido;
import br.com.jornada.pedido.domain.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository repository;

    public List<Pedido> getAll(){
      return (List<Pedido>) repository.findAll();
    }
    public Optional<Pedido> getById(Long id){
        return repository.findById(id);
    }
    public Pedido save(Pedido pedido){
        return repository.save(pedido);
    }
}