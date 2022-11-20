package com.TCCProject.TCCPROJECT.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "responsavel_crianca")
public class ResponsavelAndCrianca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private Long responsavelID

    @NotBlank

}
