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

    @Column(name = "fk_crianca_ID")
    private Long criancaId;

    @Column(name = "fk_atividade_ID")
    private Long atividadeId;

    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "status_atividade")
    private EStatusAtividade statusAtividade;

    public CriancaAtividade() {
        super();
    }

    public CriancaAtividade(Long criancaId, Long atividadeId, EStatusAtividade statusAtividade) {
        this.criancaId = criancaId;
        this.atividadeId = atividadeId;
        this.statusAtividade = statusAtividade;
    }

    public Long getId() {
        return id;
    }

    public Long getCriancaId() {
        return criancaId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCriancaId(Long criancaId) {
        this.criancaId = criancaId;
    }

    public void setAtividadeId(Long atividadeId) {
        this.atividadeId = atividadeId;
    }

    public void setStatusAtividade(EStatusAtividade statusAtividade) {
        this.statusAtividade = statusAtividade;
    }

    public EStatusAtividade getStatusAtividade() {
        return statusAtividade;
    }

    public Long getAtividadeId() {
        return atividadeId;
    }
}
