package com.TCCProject.TCCPROJECT.Entities;

import com.TCCProject.TCCPROJECT.Models.EStatusRecompensa;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "crianca_recompensa")
public class CriancaRecompensa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank
    @Column(name = "fk_crianca_ID")
    private Long criancaId;

    @NotBlank
    @Column(name = "fk_recompensa_ID")
    private Long recompensaId;

    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "recompensa_status")
    private EStatusRecompensa statusRecompensa;

    public CriancaRecompensa() {
    }

    public CriancaRecompensa(Long criancaId, Long recompensaId, EStatusRecompensa statusRecompensa) {
        this.criancaId = criancaId;
        this.recompensaId = recompensaId;
        this.statusRecompensa = statusRecompensa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCriancaId() {
        return criancaId;
    }

    public void setCriancaId(Long criancaId) {
        this.criancaId = criancaId;
    }

    public Long getRecompensaId() {
        return recompensaId;
    }

    public void setRecompensaId(Long recompensaId) {
        this.recompensaId = recompensaId;
    }

    public EStatusRecompensa getStatusRecompensa() {
        return statusRecompensa;
    }

    public void setStatusRecompensa(EStatusRecompensa statusRecompensa) {
        this.statusRecompensa = statusRecompensa;
    }
}
