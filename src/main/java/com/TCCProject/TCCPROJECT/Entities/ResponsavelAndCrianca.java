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
    private Long responsavelID;

    @NotBlank
    @Column(name = "fk_crianca_ID")
    private Long criancaID;

    public ResponsavelAndCrianca() {
    }

    public ResponsavelAndCrianca(Long responsavelID, Long criancaID){
        super();
        this.responsavelID = responsavelID;
        this.criancaID = criancaID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getResponsavelID() {
        return responsavelID;
    }

    public void setResponsavelID(Long responsavelID) {
        this.responsavelID = responsavelID;
    }

    public Long getCriancaID() {
        return criancaID;
    }

    public void setCriancaID(Long criancaID) {
        this.criancaID = criancaID;
    }
}
