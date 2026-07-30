package dev.jeferson.kalisys.domain;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "modalidades")
public class Modalidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public Boolean ativa = true;

}
