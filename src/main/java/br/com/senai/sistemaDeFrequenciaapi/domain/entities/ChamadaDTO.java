package br.com.senai.sistemaDeFrequenciaapi.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class ChamadaDTO {

        private Long idFrequencia;

        private LocalDate dataChamada;

        private Long idAluno;

        private boolean presenca;

        private String nomeAluno;
}
