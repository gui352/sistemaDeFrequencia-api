package br.com.senai.sistemaDeFrequenciaapi.domain.service;

import br.com.senai.sistemaDeFrequenciaapi.domain.entities.Turma;
import br.com.senai.sistemaDeFrequenciaapi.domain.repository.TurmaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class TurmaService {
    private TurmaRepository turmaRepository;

    @Transactional
    public Turma cadastrar(Turma turma){
        return turmaRepository.save(turma);
    }
}
