package dev.jeferson.kalisys.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "planos")
public class Plano {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String nome;
    private Boolean ativo = true;

    @Column(name = "valor_mensal")
    private BigDecimal valorMensal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "modalidade_id")
    private Modalidade modalidade;
}
