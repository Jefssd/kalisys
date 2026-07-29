package dev.jeferson.kalisys.domain;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "modalidades")
public class Modalidade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public Boolean ativo = true;

}
