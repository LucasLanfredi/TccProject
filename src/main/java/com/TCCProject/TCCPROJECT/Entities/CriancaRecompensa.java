package com.TCCProject.TCCPROJECT.Entities;


import com.TCCProject.TCCPROJECT.Models.EStatusAtividade;
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
    private Long criancaID;

    @NotBlank
    @Column(name = "fk_recompensa_ID")
    private Long recompensaID;

    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "recompensa_status")
    private EStatusRecompensa statusRecompensa;

    public CriancaRecompensa() {
    }

    public CriancaRecompensa(Long criancaID, Long recompensaID, EStatusRecompensa statusRecompensa) {
        this.criancaID = criancaID;
        this.recompensaID = recompensaID;
        this.statusRecompensa = statusRecompensa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCriancaID() {
        return criancaID;
    }

    public void setCriancaID(Long criancaID) {
        this.criancaID = criancaID;
    }

    public Long getRecompensaID() {
        return recompensaID;
    }

    public void setRecompensaID(Long recompensaID) {
        this.recompensaID = recompensaID;
    }

    public EStatusRecompensa getStatusRecompensa() {
        return statusRecompensa;
    }

    public void setStatusRecompensa(EStatusRecompensa statusRecompensa) {
        this.statusRecompensa = statusRecompensa;
    }
}
