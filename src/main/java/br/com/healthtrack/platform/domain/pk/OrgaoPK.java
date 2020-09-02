package br.com.healthtrack.platform.domain.pk;

import java.io.Serializable;
import java.util.Objects;

public class OrgaoPK implements Serializable {

    private Integer codigoOrgao;

    private Integer codigoDoador;

    public OrgaoPK() {
    }

    public OrgaoPK(Integer codigoOrgao, Integer codigoDoador) {
        this.codigoOrgao = codigoOrgao;
        this.codigoDoador = codigoDoador;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrgaoPK orgaoPK = (OrgaoPK) o;
        return Objects.equals(codigoOrgao, orgaoPK.codigoOrgao) &&
                Objects.equals(codigoDoador, orgaoPK.codigoDoador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoOrgao, codigoDoador);
    }
}
