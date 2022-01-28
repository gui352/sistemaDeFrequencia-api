package br.com.senai.sistemaDeFrequenciaapi.api.resource;

import br.com.senai.sistemaDeFrequenciaapi.domain.entities.Aluno;
import br.com.senai.sistemaDeFrequenciaapi.domain.service.AlunoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aluno")
@AllArgsConstructor
public class AlunoResource {
    private AlunoService alunoService;

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public Aluno cadastrarAluno(@RequestBody Aluno aluno){
        Aluno novoAluno = alunoService.cadastrar(aluno);
        return novoAluno;
    }
}
