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

    @NotBlank
    @Column(name = "pode_resgatar")
    private Boolean podeResgatar;

    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "recompensa_status")
    private EStatusRecompensa statusRecompensa;

    public CriancaRecompensa() {
    }

    public CriancaRecompensa(Long criancaID, Long recompensaID, Boolean podeResgatar, EStatusRecompensa statusRecompensa) {
        this.criancaID = criancaID;
        this.recompensaID = recompensaID;
        this.podeResgatar  = podeResgatar;
        this.statusRecompensa = statusRecompensa;
    }

    public Long getId() {
        return id;
    }

    public Long getCriancaID() {
        return criancaID;
    }

    public Long getRecompensaID() {
        return recompensaID;
    }

    public Boolean getPodeResgatar() {return podeResgatar; }

    public void setPodeResgatar(Boolean podeResgatar) {
        this.podeResgatar = podeResgatar;
    }

    public EStatusRecompensa getStatusRecompensa() {
        return statusRecompensa;
    }

    public void setStatusRecompensa(EStatusAtividade statusAtividade) {
        this.statusRecompensa = statusRecompensa;
    }
}
