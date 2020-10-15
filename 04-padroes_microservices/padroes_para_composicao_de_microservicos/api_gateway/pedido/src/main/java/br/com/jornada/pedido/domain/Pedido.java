package  br.com.jornada.pedido.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Pedido {

    @Id @GeneratedValue
    private Long id;

    private Long idCliente;
    @OneToMany
    private List<Produto> produtos;

    public Pedido() {
    }

    public Pedido(Long id, Long idCliente, List<Produto> produtos) {
        this.id = id;
        this.idCliente = idCliente;
        this.produtos = produtos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
