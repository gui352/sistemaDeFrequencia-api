package br.com.senai.sistemaDeFrequenciaapi.domain.repository;

import br.com.senai.sistemaDeFrequenciaapi.domain.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
