package br.com.senai.sistemaDeFrequenciaapi.domain.repository;

import br.com.senai.sistemaDeFrequenciaapi.domain.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    @Query("SELECT a FROM Aluno a WHERE a.cadastro = ?1")
    Aluno findNome(Long id);
}
