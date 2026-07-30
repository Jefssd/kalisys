package dev.jeferson.kalisys.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "assiduidade")
public class Assiduidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(name = "data_entrada")
    private LocalDate dataEntrada;

    @Column(name = "data_saida")
    private LocalDate dataSaida;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "matricula_id")
    private Matricula matricula;

    public void prePersist(){
        if (dataEntrada == null){
            dataEntrada = LocalDate.now();
        }
    }
}
