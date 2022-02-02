package br.com.senai.sistemaDeFrequenciaapi.domain.service;

import br.com.senai.sistemaDeFrequenciaapi.domain.entities.Chamada;
import br.com.senai.sistemaDeFrequenciaapi.domain.repository.ChamadaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class ChamadaService {
    private ChamadaRepository chamadaRepository;

    public Chamada cadastrar(Chamada chamada) {
        return chamadaRepository.save(chamada);
    }

    public List<Chamada> listar() {
        return chamadaRepository.findAll();
    }
}
