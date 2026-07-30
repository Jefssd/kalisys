package dev.jeferson.kalisys.dto;

import dev.jeferson.kalisys.domain.Aluno;

import java.time.LocalDate;

public record AlunoResponse(

        String nome,
        LocalDate dataNascimento,
        String sexo,
        String telefone,
        String celular,
        String email,
        String observacao,
        String endereco,
        String numero,
        String complemento,
        String bairro,
        String cidade,
        String estado,
        String cep
) {


        public static AlunoResponse fromEntity(Aluno aluno){
            return new AlunoResponse(
                    aluno.getNome(),
                    aluno.getDataNascimento(),
                    aluno.getSexo(),
                    aluno.getTelefone(),
                    aluno.getCelular(),
                    aluno.getEmail(),
                    aluno.getObservacao(),
                    aluno.getEndereco(),
                    aluno.getNumero(),
                    aluno.getComplemento(),
                    aluno.getBairro(),
                    aluno.getCidade(),
                    aluno.getEstado(),
                    aluno.getCep()
            );
        }
}

