package br.com.senai.sistemaDeFrequenciaapi.api.resource;

import br.com.senai.sistemaDeFrequenciaapi.domain.entities.Turma;
import br.com.senai.sistemaDeFrequenciaapi.domain.service.TurmaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/turma")
@AllArgsConstructor
public class TurmaResource {
    private TurmaService turmaService;

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public Turma cadastrarTurma(@RequestBody Turma turma){
        Turma novaTurma = turmaService.cadastrar(turma);
        return novaTurma;
    }
}
