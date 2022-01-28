package br.com.senai.sistemaDeFrequenciaapi.domain.repository;

import br.com.senai.sistemaDeFrequenciaapi.domain.entities.Chamada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChamadaRepository extends JpaRepository<Chamada, Long> {
}
