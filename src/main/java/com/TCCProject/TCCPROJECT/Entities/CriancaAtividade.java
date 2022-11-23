package com.TCCProject.TCCPROJECT.Entities;


import com.TCCProject.TCCPROJECT.Models.EStatusAtividade;

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

    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "atividade_status")
    private EStatusAtividade statusAtividade;

    public CriancaAtividade() {
        super();
    }

    public CriancaAtividade(Long criancaID, Long atividadeID, EStatusAtividade statusAtividade) {
        this.criancaID = criancaID;
        this.atividadeID = atividadeID;
        this.statusAtividade = statusAtividade;
    }

    public Long getId() {
        return id;
    }

    public Long getCriancaID() {
        return criancaID;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCriancaID(Long criancaID) {
        this.criancaID = criancaID;
    }

    public void setAtividadeID(Long atividadeID) {
        this.atividadeID = atividadeID;
    }

    public void setStatusAtividade(EStatusAtividade statusAtividade) {
        this.statusAtividade = statusAtividade;
    }

    public EStatusAtividade getStatusAtividade() {
        return statusAtividade;
    }

    public Long getAtividadeID() {
        return atividadeID;
    }
}
