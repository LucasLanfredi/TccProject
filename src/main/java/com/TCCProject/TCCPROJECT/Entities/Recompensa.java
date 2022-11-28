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

    @NotBlank
    @Size(max = 240)
    @Column(name = "descricao_recompensa")
    private String descricaoRecompensa;

    @NotBlank
    @Size(max = 240)
    @Column(name = "pontuacao_recompensa")
    private int pontuacaoRecompensa;

    @JoinColumn(name= "fk_responsavel_id")
    @NotBlank
    private Long responsavelId;

    public Recompensa(){
    }

    public Recompensa(String nomeRecompensa, String descricaoRecompensa, int pontuacaoRecompensa,
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

    public int getPontuacaoRecompensa() {
        return pontuacaoRecompensa;
    }

    public void setPontuacaoRecompensa(int pontuacaoRecompensa) {
        this.pontuacaoRecompensa = pontuacaoRecompensa;
    }

    public Long getResponsavelId() {
        return responsavelId;
    }

    public void setResponsavelId(Long responsavelId) {
        this.responsavelId = responsavelId;
    }
}