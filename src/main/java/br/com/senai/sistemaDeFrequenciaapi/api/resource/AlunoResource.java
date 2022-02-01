package br.com.senai.sistemaDeFrequenciaapi.api.resource;

import br.com.senai.sistemaDeFrequenciaapi.domain.entities.Aluno;
import br.com.senai.sistemaDeFrequenciaapi.domain.repository.AlunoRepository;
import br.com.senai.sistemaDeFrequenciaapi.domain.service.AlunoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/aluno")
@AllArgsConstructor
public class AlunoResource {
    private AlunoService alunoService;
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

    @PutMapping("/editar/{nCadastro}")
    public Aluno editar(@Valid @PathVariable Long nCadastro, @RequestBody Aluno aluno){
       return alunoService.editar(nCadastro, aluno);
    }

//    @DeleteMapping=("/apagar/{nCadastro}")
//    public Aluno deletar(@PathVariable Long nCadastro){
//        return alunoService.deletar(nCadastro);
//    }

}
