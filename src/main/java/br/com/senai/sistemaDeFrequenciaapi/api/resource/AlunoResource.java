package br.com.senai.sistemaDeFrequenciaapi.api.resource;

import br.com.senai.sistemaDeFrequenciaapi.api.assembler.AlunoAssembler;
import br.com.senai.sistemaDeFrequenciaapi.domain.entities.Aluno;
import br.com.senai.sistemaDeFrequenciaapi.domain.repository.AlunoRepository;
import br.com.senai.sistemaDeFrequenciaapi.domain.service.AlunoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/aluno")
@AllArgsConstructor
public class AlunoResource {
    private AlunoService alunoService;
    private AlunoAssembler alunoAssembler;
    private AlunoRepository alunoRepository;

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public Aluno cadastrarAluno(@RequestBody Aluno aluno){
        Aluno novoAluno = alunoService.cadastrar(aluno);
        return novoAluno;
    }

    @GetMapping("/listar")
    public List<Aluno> listar(){
        return alunoService.listar();
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Aluno> editar(@Valid @PathVariable Long id,
                                        @RequestBody Aluno aluno){
        Aluno aluno1 = alunoAssembler.toEntity(aluno);
        alunoService.editar(id,aluno);
        return ResponseEntity.ok(alunoAssembler.toModel(aluno));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Aluno> remover(@PathVariable Long id){
        if(!alunoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        alunoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
