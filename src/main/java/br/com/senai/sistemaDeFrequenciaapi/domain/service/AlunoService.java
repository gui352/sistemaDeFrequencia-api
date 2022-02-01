package br.com.senai.sistemaDeFrequenciaapi.domain.service;

import br.com.senai.sistemaDeFrequenciaapi.NegocioException;
import br.com.senai.sistemaDeFrequenciaapi.domain.entities.Aluno;
import br.com.senai.sistemaDeFrequenciaapi.domain.repository.AlunoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class AlunoService {
    private AlunoRepository alunoRepository;

    @Transactional
    public Aluno cadastrar(Aluno aluno){
        return alunoRepository.save(aluno);
    }

    public List<Aluno> listar(){
        return alunoRepository.findAll();
    }

    public Aluno buscar(Long id){
        return alunoRepository.findById(id)
                .orElseThrow(() -> new NegocioException("Pessoa não encontrada."));
    }

    public Aluno editar(Long nCadastro, Aluno aluno){
        Aluno novoAluno = aluno;
        novoAluno.setNCadastro(nCadastro);
        return alunoRepository.save(novoAluno);
    }

    @Transactional
    public void deletar(Long nCadastro){
        alunoRepository.deleteById(nCadastro);
    }
}
