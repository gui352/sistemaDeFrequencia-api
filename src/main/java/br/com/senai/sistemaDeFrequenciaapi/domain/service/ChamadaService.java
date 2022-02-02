package br.com.senai.sistemaDeFrequenciaapi.domain.service;

import br.com.senai.sistemaDeFrequenciaapi.domain.entities.Chamada;
import br.com.senai.sistemaDeFrequenciaapi.domain.entities.ChamadaDTO;
import br.com.senai.sistemaDeFrequenciaapi.domain.repository.AlunoRepository;
import br.com.senai.sistemaDeFrequenciaapi.domain.repository.ChamadaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class ChamadaService {
    private ChamadaRepository chamadaRepository;
    private AlunoRepository alunoRepository;

    public Chamada cadastrar(Chamada chamada) {
        return chamadaRepository.save(chamada);
    }

    public List<ChamadaDTO> listar() {
        List<Chamada> todosAlunos = chamadaRepository.findAll();
        List<ChamadaDTO> todosAlunosDTO = new ArrayList<>();
        todosAlunos.forEach(aluno ->{
            ChamadaDTO chamadaDTO = new ChamadaDTO(aluno.getIdFrequencia(), aluno.getDataChamada(),
                    aluno.getIdaluno(), aluno.isPresenca(),
                    alunoRepository.findNome(aluno.getIdaluno()).getNome());
            todosAlunosDTO.add(chamadaDTO);
        });

        return todosAlunosDTO;
    }
}
