package br.com.senai.sistemaDeFrequenciaapi.api.resource;

import br.com.senai.sistemaDeFrequenciaapi.domain.entities.Chamada;
import br.com.senai.sistemaDeFrequenciaapi.domain.entities.ChamadaDTO;
import br.com.senai.sistemaDeFrequenciaapi.domain.service.ChamadaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chamada")
@AllArgsConstructor
public class ChamadaResource {
    private ChamadaService chamadaService;

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Chamada> CadastrarFrequencia(@RequestBody List<Chamada> frequencias){
        frequencias.forEach(frequencia -> {
            chamadaService.cadastrar(frequencia);
        });
        return frequencias;
    }

    @GetMapping("/listar")
    public List<ChamadaDTO> Listar(){
        return chamadaService.listar();
    }
}
