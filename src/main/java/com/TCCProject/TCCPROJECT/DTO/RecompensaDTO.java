package com.TCCProject.TCCPROJECT.DTO;

import java.util.Date;
import java.util.List;

public class RecompensaDTO {

    private Long id;

    private String nomeRecompensa;

    private String descricaoRecompensa;

    private List<Long> criancas;

    public RecompensaDTO() {
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

    public void setNomeRecompensa(String nomeAtividade) {
        this.nomeRecompensa = nomeAtividade;
    }

    public String getDescricaoRecompensa() {
        return descricaoRecompensa;
    }

    public void setDescricaoRecompensa(String descricaoRecompensa) {
        this.descricaoRecompensa = descricaoRecompensa;
    }


    public List<Long> getCriancas() {
        return criancas;
    }

    public void setCriancas(List<Long> criancas) {
        this.criancas = criancas;
    }
}
