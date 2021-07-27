package com.silva.imc.repository;

import com.silva.imc.entity.HistoricoImcEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculadoraImcRepository extends CrudRepository<HistoricoImcEntity, Long> {
}
