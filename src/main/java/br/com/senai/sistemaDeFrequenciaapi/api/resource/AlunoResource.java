package br.com.senai.sistemaDeFrequenciaapi.api.resource;

import br.com.senai.sistemaDeFrequenciaapi.domain.entities.Aluno;
import br.com.senai.sistemaDeFrequenciaapi.domain.entities.AlunoDTO;
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

    @GetMapping("/buscar/{nCadastro}")
    public Aluno buscar(@PathVariable Long nCadastro){
        return alunoService.buscar(nCadastro);
    }

    @GetMapping("/freq/{nCadastro}")
    public AlunoDTO freq(@PathVariable Long nCadastro){ return alunoService.buscarAluno(nCadastro);}

    @GetMapping("/listar")
    public List<Aluno> listar(){
        return alunoService.listar();
    }

    @PutMapping("/editar/{nCadastro}")
    public Aluno editar(@Valid @PathVariable Long nCadastro, @RequestBody Aluno aluno){
       return alunoService.editar(nCadastro, aluno);
    }

    @DeleteMapping("/apagar/{nCadastro}")
    public void deletar(@PathVariable Long nCadastro){
        alunoService.deletar(nCadastro);
    }
}
