package br.com.healthtrack.platform.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "T_RECEPTOR")
public class Receptor extends Paciente {

    @Column(name = "ds_orgao")
    @NotBlank(message = "É necessário preencher o orgão do receptor")
    private String orgao;

    @Column(name = "nr_score")
    @Min(value = 1, message = "É necessário preencher o score do receptor")
    private Integer score;

    public String getOrgao() {
        return orgao;
    }

    public void setOrgao(String orgao) {
        this.orgao = orgao;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
