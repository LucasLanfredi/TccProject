package com.TCCProject.TCCPROJECT.DTO;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class AtividadeDTO {

    private String nomeAtividade;

    private String descricaoAtividade;

    private Date dataAtividade;

    private Integer valorPontos;

    private Set<String> statusAtividade;

    private List<Long> criancas;

    private Long responsavelId;

    public AtividadeDTO() {
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


    public Set<String> getStatusAtividade() {
        return statusAtividade;
    }

    public void setStatusAtividade(Set<String> statusAtividade) {
        this.statusAtividade = statusAtividade;
    }

    public void setValorPontos(int valorPontos) {
        this.valorPontos = valorPontos;
    }

    public Integer getValorPontos() {
        return valorPontos;
    }

    public void setValorPontos(Integer valorPontos) {
        this.valorPontos = valorPontos;
    }

    public Long getResponsavelId() {
        return responsavelId;
    }

    public void setResponsavelId(Long responsavelId) {
        this.responsavelId = responsavelId;
    }

    public List<Long> getCriancas() {
        return criancas;
    }

    public void setCriancas(List<Long> criancas) {
        this.criancas = criancas;
    }
}
