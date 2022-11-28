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
    @Column(name = "fk_responsavel_ID")
    private Long responsavelId;

    @NotBlank
    @Column(name = "fk_crianca_ID")
    private Long criancaId;

    public ResponsavelAndCrianca() {
    }

    public ResponsavelAndCrianca(Long responsavelId, Long criancaId){
        super();
        this.responsavelId = responsavelId;
        this.criancaId = criancaId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getResponsavelId() {
        return responsavelId;
    }

    public void setResponsavelId(Long responsavelId) {
        this.responsavelId = responsavelId;
    }

    public Long getCriancaId() {
        return criancaId;
    }

    public void setCriancaId(Long criancaId) {
        this.criancaId = criancaId;
    }
}
