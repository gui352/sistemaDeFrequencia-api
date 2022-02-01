package br.com.senai.sistemaDeFrequenciaapi.api.model.input;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class AlunoInputDTO {

    private String nome;

    private Long nCadastro;

    private Long cpf;

    private LocalDate dataNascimento;

    private String email;

    private Long telefone;

    private  Long turma;
}