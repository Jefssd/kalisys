package dev.jeferson.kalisys.service;

import dev.jeferson.kalisys.domain.Aluno;
import dev.jeferson.kalisys.dto.AlunoRequest;
import dev.jeferson.kalisys.dto.AlunoResponse;
import dev.jeferson.kalisys.repository.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoResponse cadastrar(AlunoRequest request) {
        if (request.email() != null && alunoRepository.existsByEmail(request.email())) {
            throw new RuntimeException("email ja cadastrado!");
        }
        Aluno aluno = request.toEntity();
        Aluno alunoSalvo = alunoRepository.save(aluno);
        return AlunoResponse.fromEntity(alunoSalvo);
    }

    public AlunoResponse atualizar(Long id, AlunoRequest request) {
        Aluno aluno = buscarEntidadePorId(id);
        request.preencher(aluno);
        Aluno alunoAtualizado = alunoRepository.save(aluno);
        return AlunoResponse.fromEntity(alunoAtualizado);
    }

    public Page<AlunoResponse> listar(Pageable pageable) {
        return alunoRepository.findAll(pageable).map(AlunoResponse::fromEntity);
    }

    public void excluir(Long id){
        Aluno aluno = buscarEntidadePorId(id);
        alunoRepository.delete(aluno);
    }

    public AlunoResponse buscarPorId(Long id) {
        return AlunoResponse.fromEntity(buscarEntidadePorId(id));
    }

    public Aluno buscarEntidadePorId(Long id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado!"));
    }
}
