package br.com.senai.sistemaDeFrequenciaapi.domain.repository;

import br.com.senai.sistemaDeFrequenciaapi.domain.entities.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {
}
