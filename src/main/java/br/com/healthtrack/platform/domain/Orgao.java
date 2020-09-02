package br.com.healthtrack.platform.domain;

import br.com.healthtrack.platform.domain.pk.OrgaoPK;

import javax.persistence.*;

@Entity
@Table(name = "T_ORGAO")
@SequenceGenerator(name = "sqOrgao", sequenceName = "SQ_ORGAO", allocationSize = 1)
@IdClass(OrgaoPK.class)
public class Orgao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sqOrgao")
    @Column(name = "cd_orgao")
    private Integer codigoOrgao;

    @Id
    @Column(name = "cd_paciente")
    private Integer codigoDoador;

    @ManyToOne
    @MapsId("codigoDoador")
    @JoinColumn(name = "cd_paciente")
    private Doador doador;

    @OneToOne(mappedBy = "orgao")
    private Match match;

    @Column(name = "nm_orgao")
    private String nome;

    @Column(name = "nr_isquemia")
    private Integer numeroIsquemia;

    public Doador getDoador() {
        return doador;
    }

    public void setDoador(Doador doador) {
        this.doador = doador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNumeroIsquemia() {
        return numeroIsquemia;
    }

    public void setNumeroIsquemia(Integer numeroIsquemia) {
        this.numeroIsquemia = numeroIsquemia;
    }

    public Integer getCodigoOrgao() {
        return codigoOrgao;
    }

    public void setCodigoOrgao(Integer codigoOrgao) {
        this.codigoOrgao = codigoOrgao;
    }

    public Integer getCodigoDoador() {
        return codigoDoador;
    }

    public void setCodigoDoador(Integer codigoDoador) {
        this.codigoDoador = codigoDoador;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }
}
