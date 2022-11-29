package com.TCCProject.TCCPROJECT.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "atividades")
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(max = 80)
    @Column(name = "nome_atividade")
    private String nomeAtividade;

    @Size(max = 240)
    @Column(name = "descricao_atividade")
    private String descricaoAtividade;

    @Column(name = "data_atividade")
    private Date dataAtividade;

    @Column(name = "valor_pontos")
    private Integer valorPontos;

    @Column(name = "necessario_validar")
    private boolean necessarioValidar;

    @JoinColumn(name= "fk_responsavel_id")
    private Long responsavelId;

    public Atividade(){
    }

    public Atividade(String nomeAtividade, String descricaoAtividade, Date dataAtividade, int valorPontos, boolean necessarioValidar,
                     Long responsavelId) {
        this.nomeAtividade = nomeAtividade;
        this.descricaoAtividade = descricaoAtividade;
        this.dataAtividade = dataAtividade;
        this.valorPontos = valorPontos;
        this.necessarioValidar = necessarioValidar;
        this.responsavelId = responsavelId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Integer getValorPontos() {
        return valorPontos;
    }

    public void setValorPontos(Integer valorPontos) {
        this.valorPontos = valorPontos;
    }

    public boolean isNecessarioValidar() {
        return necessarioValidar;
    }

    public void setNecessarioValidar(boolean necessarioValidar) {
        this.necessarioValidar = necessarioValidar;
    }

    public Long getResponsavelId() {
        return responsavelId;
    }

    public void setResponsavelId(Long responsavelId) {
        this.responsavelId = responsavelId;
    }
}