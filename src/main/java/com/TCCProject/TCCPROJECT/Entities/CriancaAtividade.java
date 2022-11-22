package com.TCCProject.TCCPROJECT.Entities;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "crianca_atividade")
public class CriancaAtividade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank
    @Column(name = "fk_crianca_ID")
    private Long criancaID;

    @NotBlank
    @Column(name = "fk_atividade_ID")
    private Long atividadeID;

    public CriancaAtividade() {
    }

    public CriancaAtividade(Long criancaID, Long atividadeID) {
        this.criancaID = criancaID;
        this.atividadeID = atividadeID;
    }

    public Long getId() {
        return id;
    }

    public Long getCriancaID() {
        return criancaID;
    }

    public Long getAtividadeID() {
        return atividadeID;
    }
}
