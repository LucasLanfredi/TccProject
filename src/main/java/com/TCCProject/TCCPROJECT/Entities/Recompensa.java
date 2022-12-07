package com.TCCProject.TCCPROJECT.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "recompensa")
public class Recompensa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 80)
    @Column(name = "nome_recompensa")
    private String nomeRecompensa;

    @Size(max = 240)
    @Column(name = "descricao_recompensa")
    private String descricaoRecompensa;

    @Column(name = "pontuacao_recompensa")
    private Integer pontuacaoRecompensa;

    @JoinColumn(name= "fk_responsavel_id")
    private Long responsavelId;

    public Recompensa(){
    }

    public Recompensa(String nomeRecompensa, String descricaoRecompensa, Integer pontuacaoRecompensa,
                      Long responsavelId) {
        this.nomeRecompensa = nomeRecompensa;
        this.descricaoRecompensa = descricaoRecompensa;
        this.pontuacaoRecompensa  = pontuacaoRecompensa;
        this.responsavelId = responsavelId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeRecompensa() {
        return nomeRecompensa;
    }

    public void setNomeRecompensa(String nomeRecompensa) {
        this.nomeRecompensa = nomeRecompensa;
    }

    public String getDescricaoRecompensa() {
        return descricaoRecompensa;
    }

    public void setDescricaoRecompensa(String descricaoRecompensa) {
        this.descricaoRecompensa = descricaoRecompensa;
    }

    public Integer getPontuacaoRecompensa() {
        return pontuacaoRecompensa;
    }

    public void setPontuacaoRecompensa(Integer pontuacaoRecompensa) {
        this.pontuacaoRecompensa = pontuacaoRecompensa;
    }

    public Long getResponsavelId() {
        return responsavelId;
    }

    public void setResponsavelId(Long responsavelId) {
        this.responsavelId = responsavelId;
    }
}