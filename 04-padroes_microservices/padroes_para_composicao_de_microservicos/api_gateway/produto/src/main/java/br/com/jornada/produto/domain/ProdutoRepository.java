package br.com.jornada.produto.domain;

import br.com.jornada.produto.domain.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {
}
