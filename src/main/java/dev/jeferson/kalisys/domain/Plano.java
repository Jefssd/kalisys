package dev.jeferson.kalisys.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "planos")
public class Plano {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
