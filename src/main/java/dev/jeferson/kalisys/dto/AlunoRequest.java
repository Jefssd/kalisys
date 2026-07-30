package dev.jeferson.kalisys.dto;

import dev.jeferson.kalisys.domain.Aluno;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record AlunoRequest(

        @NotBlank
        String nome,

        @Past
        LocalDate dataNascimento,

        @Pattern(regexp = "[MF]")
        String sexo,

        String telefone,
        String celular,

        @Email
        String email,

        String observacao,
        String endereco,
        String numero,
        String complemento,
        String bairro,
        String cidade,

        @Size(max = 2)
        String estado,

        @Size(max = 20)
        String cep
) {

    public Aluno toEntity() {
        Aluno aluno = new Aluno();
        preencher(aluno);
        return aluno;
    }

    public void preencher(Aluno aluno) {
        aluno.setNome(nome);
        aluno.setDataNascimento(dataNascimento);
        aluno.setSexo(sexo);
        aluno.setTelefone(telefone);
        aluno.setCelular(celular);
        aluno.setEmail(email);
        aluno.setObservacao(observacao);
        aluno.setEndereco(endereco);
        aluno.setNumero(numero);
        aluno.setComplemento(complemento);
        aluno.setBairro(bairro);
        aluno.setCidade(cidade);
        aluno.setEstado(estado);
        aluno.setCep(cep);
    }
}
