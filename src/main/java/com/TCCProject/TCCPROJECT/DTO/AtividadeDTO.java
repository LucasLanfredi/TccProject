package com.TCCProject.TCCPROJECT.DTO;

import com.TCCProject.TCCPROJECT.Entities.User;
import com.TCCProject.TCCPROJECT.Models.EStatusAtividade;

import java.util.Date;
import java.util.List;

public class AtividadeDTO {

    private Long id;

    private String nomeAtividade;

    private String descricaoAtividade;

    private Date dataAtividade;

    private int valorPontos;

    private boolean necessarioValidar;

    private EStatusAtividade statusAtividade;

    private List<Long> criancas;

    public AtividadeDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeAtividade() {
        return nomeAtividade;
    }

    public void setNomeAtividade(String nomeAtividade) {
        this.nomeAtividade = nomeAtividade;
    }

    public String getDescricaoAtividade() {
        return descricaoAtividade;
    }

    public void setDescricaoAtividade(String descricaoAtividade) {
        this.descricaoAtividade = descricaoAtividade;
    }

    public Date getDataAtividade() {
        return dataAtividade;
    }

    public void setDataAtividade(Date dataAtividade) {
        this.dataAtividade = dataAtividade;
    }

    public int getValorPontos() {
        return valorPontos;
    }

    public void setValorPontos(int valorPontos) {
        this.valorPontos = valorPontos;
    }

    public boolean isNecessarioValidar() {
        return necessarioValidar;
    }

    public void setNecessarioValidar(boolean necessarioValidar) {
        this.necessarioValidar = necessarioValidar;
    }

    public List<Long> getCriancas() {
        return criancas;
    }

    public EStatusAtividade getStatusAtividade() {
        return statusAtividade;
    }

    public void setStatusAtividade(EStatusAtividade statusAtividade) {
        this.statusAtividade = statusAtividade;
    }

    public void setCriancas(List<Long> criancas) {
        this.criancas = criancas;
    }
}
