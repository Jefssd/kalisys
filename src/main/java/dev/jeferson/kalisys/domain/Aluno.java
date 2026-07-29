package dev.jeferson.kalisys.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Aluno {


    @Data
    @Entity
    @Table(name = "alunos")

    public class aluno(){
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        private String nome;

        @Column(name = "data_nascimento")
        private LocalDate dataNascimento;

        @Column(name = "sexo", length =  1)
        private  String sexo;

        private  String telefone;
        private  String celular;
        private  String email;
        private  String observacao;
        private  String endereco;
        private  String numero;
        private  String complemento;
        private  String bairro;
        private  String cidade;


        @Column(length = 2)
        private  String estado;

        @Column(name   = "criado_em")
        private LocalDateTime criadoEm;

        @Column(name  = "atualizado_em")
        private LocalDateTime atualizadoEm;

        @PrePersist
        private void prepersist(){
            criadoEm = LocalDateTime.now();
       }

        @PrePersist
        private void preupdate(){
            atualizadoEm = LocalDateTime.now();
        }
    }
}
