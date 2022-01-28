package br.com.senai.sistemaDeFrequenciaapi.domain.service;

import br.com.senai.sistemaDeFrequenciaapi.domain.entities.Aluno;
import br.com.senai.sistemaDeFrequenciaapi.domain.repository.AlunoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class AlunoService {
    private AlunoRepository alunoRepository;

    @Transactional
    public Aluno cadastrar(Aluno aluno){
        return alunoRepository.save(aluno);
    }
}
