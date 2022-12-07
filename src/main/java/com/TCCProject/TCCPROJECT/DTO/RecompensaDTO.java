package com.TCCProject.TCCPROJECT.DTO;

import org.apache.tomcat.Jar;

import java.util.List;

public class RecompensaDTO {

    private String nomeRecompensa;

    private String descricaoRecompensa;

    private Integer pontuacaoRecompensa;

    private List<Long> criancas;

    private Long responsavelId;

    public RecompensaDTO() {
    }


    public String getNomeRecompensa() {
        return nomeRecompensa;
    }

    public void setNomeRecompensa(String nomeAtividade) {
        this.nomeRecompensa = nomeAtividade;
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
    public List<Long> getCriancas() {
        return criancas;
    }

    public Long getResponsavelId() {
        return responsavelId;
    }

    public void setResponsavelId(Long responsavelId) {
        this.responsavelId = responsavelId;
    }

    public void setCriancas(List<Long> criancas) {
        this.criancas = criancas;
    }
}
