package br.com.senai.sistemaDeFrequenciaapi.api.assembler;

import br.com.senai.sistemaDeFrequenciaapi.domain.entities.Aluno;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class AlunoAssembler {

    private ModelMapper modelMapper;

    public Aluno toEntity(Aluno aluno){
        return modelMapper.map(aluno, Aluno.class);
    }

    public Aluno toModel(Aluno aluno){
        return modelMapper.map(aluno, Aluno.class);
    }
}
