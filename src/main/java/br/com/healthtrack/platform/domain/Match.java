package br.com.healthtrack.platform.domain;

import br.com.healthtrack.platform.domain.pk.MatchPK;

import javax.persistence.*;

@Table(name = "T_MATCH")
@Entity
public class Match {

    @EmbeddedId
    private MatchPK matchId;

    @OneToOne
    @MapsId("orgaoId")
    @JoinColumns({
            @JoinColumn(name = "cd_orgao"),
            @JoinColumn(name = "cd_paciente_doador")
    })
    private Orgao orgao;

    @ManyToOne
    @MapsId("codigoReceptor")
    @JoinColumn(name = "cd_paciente_receptor")
    private Receptor receptor;

    @Column(name = "ds_status")
    private String status;

    @Column(name = "ds_indicacao_transporte")
    private String transporteIdeal;

    @Column(name = "cd_rastreio")
    private String codigoRastreio;

    public MatchPK getMatchId() {
        return matchId;
    }

    public void setMatchId(MatchPK matchPK) {
        this.matchId = matchPK;
    }

    public Receptor getReceptor() {
        return receptor;
    }

    public void setReceptor(Receptor receptor) {
        this.receptor = receptor;
    }

    public Orgao getOrgao() {
        return orgao;
    }

    public void setOrgao(Orgao orgao) {
        this.orgao = orgao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTransporteIdeal() {
        return transporteIdeal;
    }

    public void setTransporteIdeal(String transporteIdeal) {
        this.transporteIdeal = transporteIdeal;
    }

    public String getCodigoRastreio() {
        return codigoRastreio;
    }

    public void setCodigoRastreio(String codigoRastreio) {
        this.codigoRastreio = codigoRastreio;
    }
}
