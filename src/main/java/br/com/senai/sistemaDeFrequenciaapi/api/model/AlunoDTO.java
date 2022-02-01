package br.com.senai.sistemaDeFrequenciaapi.api.model;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class AlunoDTO {

    private String nome;

    private Long nCadastro;

    private Long cpf;

    private LocalDate dataNascimento;

    private String email;

    private Long telefone;

    private  Long turma;
}
