package com.TCCProject.TCCPROJECT.Entities;

import com.TCCProject.TCCPROJECT.Models.EStatusAtividade;
import com.TCCProject.TCCPROJECT.Models.EStatusRecompensa;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "recompensa")
public class Recompensa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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
    private Long pontuacaoRecompensa;

    @JoinColumn(name= "fk_responsavel_id")
    @NotBlank
    private Long responsavelID;

    public Recompensa(){
    }

    public Recompensa(String nomeRecompensa, String descricaoRecompensa, Long pontuacaoRecompensa, Long responsavelID) {
        this.nomeRecompensa = nomeRecompensa;
        this.descricaoRecompensa = descricaoRecompensa;
        this.pontuacaoRecompensa  = pontuacaoRecompensa;
        this.responsavelID = responsavelID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeRecompensa() {
        return nomeRecompensa;
    }

    public void setNomeRecompensa(String nomeAtividade) {
        this.nomeRecompensa = nomeRecompensa;
    }

    public String getDescricaoRecompensa() {
        return descricaoRecompensa;
    }

    public void setDescricaoRecompensa(String descricaoRecompensa) {
        this.descricaoRecompensa = descricaoRecompensa;
    }

    public Long getPontuacaoRecompensa() {return  pontuacaoRecompensa; }

    public void setPontuacaoRecompensa() { this.pontuacaoRecompensa = pontuacaoRecompensa; }

    public Long getResponsavelID() {
        return responsavelID;
    }

    public void setResponsavelID(Long responsavelID) {
        this.responsavelID = responsavelID;
    }

}