package br.com.senai.sistemaDeFrequenciaapi.domain.service;

import br.com.senai.sistemaDeFrequenciaapi.NegocioException;
import br.com.senai.sistemaDeFrequenciaapi.api.assembler.AlunoAssembler;
import br.com.senai.sistemaDeFrequenciaapi.domain.entities.Aluno;
import br.com.senai.sistemaDeFrequenciaapi.domain.repository.AlunoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class AlunoService {
    private AlunoRepository alunoRepository;
    private AlunoAssembler alunoAssembler;

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

    public ResponseEntity<Aluno> editar(Long id, Aluno aluno) {
        if (!alunoRepository.existsById(id)){
            throw new NegocioException("Pessoa não encontrada");
        }
        Aluno aluno1 = this.buscar(id);
        aluno.setNCadastro(id);
        aluno1 = alunoRepository.save(aluno);

        return ResponseEntity.ok(alunoAssembler.toModel(aluno1));
    }

    @Transactional
    public void deletar(Long id){
        alunoRepository.deleteById(id);
    }
}
