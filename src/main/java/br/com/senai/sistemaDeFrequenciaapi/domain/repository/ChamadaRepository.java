package br.com.senai.sistemaDeFrequenciaapi.domain.repository;

import br.com.senai.sistemaDeFrequenciaapi.domain.entities.Chamada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ChamadaRepository extends JpaRepository<Chamada, Long> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Chamada c WHERE c.idaluno = ?1")
    void deletarAluno(Long id);

    @Query("SELECT c FROM Chamada c WHERE c.idaluno = ?1")
    List<Chamada> listaTudo(Long id);
}
