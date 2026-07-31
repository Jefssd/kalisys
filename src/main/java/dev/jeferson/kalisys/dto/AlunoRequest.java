package dev.jeferson.kalisys.dto;

import dev.jeferson.kalisys.domain.Aluno;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record AlunoRequest(

        @NotBlank(message = "O nome é obrigatorio")
        @Size(max = 150, message = "Onome deve ter no máximo 150 caracteres.")
        String nome,

        @Past(message = "Data de nascimento deve estar no passado.")
        LocalDate dataNascimento,

        @Pattern(regexp = "[MF]")
        @Size(max = 1)
        String sexo,

        @Size(max = 30)
        String telefone,

        @Size(max = 30)
        String celular,

        @Email(message = "E-mail inválido.")
        @Size(max = 150, message = "O e-mail deve ter no máximo 150 caracteres.")
        String email,

        String observacao,

        @Size(max = 150)
        String endereco,

        @Size(max = 100)
        String numero,

        @Size(max = 100)
        String complemento,

        @Size(max = 100)
        String bairro,

        @Size(max = 100)
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
