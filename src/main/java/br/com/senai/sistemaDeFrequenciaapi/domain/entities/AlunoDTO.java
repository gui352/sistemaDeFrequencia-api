package br.com.senai.sistemaDeFrequenciaapi.domain.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlunoDTO {

    private String nome;

    private Long cadastro;

    private Long cpf;

    private LocalDate dataNascimento;

    private String email;

    private Long telefone;

    private  Long turma;

    private double frequencia;
}
