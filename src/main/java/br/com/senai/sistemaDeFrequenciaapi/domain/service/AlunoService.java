package br.com.senai.sistemaDeFrequenciaapi.domain.service;

import br.com.senai.sistemaDeFrequenciaapi.NegocioException;
import br.com.senai.sistemaDeFrequenciaapi.domain.entities.Aluno;
import br.com.senai.sistemaDeFrequenciaapi.domain.entities.AlunoDTO;
import br.com.senai.sistemaDeFrequenciaapi.domain.entities.Chamada;
import br.com.senai.sistemaDeFrequenciaapi.domain.entities.ChamadaDTO;
import br.com.senai.sistemaDeFrequenciaapi.domain.repository.AlunoRepository;
import br.com.senai.sistemaDeFrequenciaapi.domain.repository.ChamadaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class AlunoService {
    private AlunoRepository alunoRepository;
    private ChamadaRepository chamadaRepository;

    @Transactional
    public Aluno cadastrar(Aluno aluno){
        return alunoRepository.save(aluno);
    }

    public List<Aluno> listar(){
        return alunoRepository.findAll();
    }

    public Aluno buscar(Long nCadastro) {
        return alunoRepository.findById(nCadastro).orElseThrow();
    }

    public AlunoDTO buscarAluno(Long nCadastro) {
        var quantidadePresenca = 0;

        Aluno aluno = alunoRepository.findById(nCadastro).orElseThrow();
        AlunoDTO alunoDTO = new AlunoDTO();
        alunoDTO.setNome(aluno.getNome());
        alunoDTO.setCpf(alunoDTO.getCpf());
        alunoDTO.setCadastro(aluno.getCadastro());
        alunoDTO.setEmail(aluno.getEmail());
        alunoDTO.setDataNascimento(aluno.getDataNascimento());
        alunoDTO.setTurma(aluno.getTurma());
        alunoDTO.setTelefone(aluno.getTelefone());
        List<Chamada> listar = chamadaRepository.listaTudo(aluno.getCadastro());
        if (listar.size()==0){
            alunoDTO.setFrequencia(100);
        }else {
            for (int i = 0; i < listar.size(); ++i){
                if (listar.get(i).isPresenca()){
                    quantidadePresenca+=1;
                }
            }
            alunoDTO.setFrequencia(quantidadePresenca * 100 / listar.size());
        }
        return alunoDTO;
    }

    public Aluno editar(Long nCadastro, Aluno aluno){
        Aluno novoAluno = aluno;
        novoAluno.setCadastro(nCadastro);
        return alunoRepository.save(novoAluno);
    }

    @Transactional
    public void deletar(Long nCadastro){
        alunoRepository.deleteById(nCadastro);
        chamadaRepository.deletarAluno(nCadastro);
    }
}
