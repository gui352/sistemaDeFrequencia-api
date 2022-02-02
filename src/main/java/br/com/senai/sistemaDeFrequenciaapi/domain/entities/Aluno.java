package br.com.senai.sistemaDeFrequenciaapi.domain.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "alunos")
public class Aluno {

    @NotNull
    private String nome;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cadastro;

    private Long cpf;

    private LocalDate dataNascimento;

    @NotBlank
    @Size(max = 60)
    private String email;

    private Long telefone;

    private  Long turma;
}
