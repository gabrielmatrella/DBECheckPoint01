package br.com.healthtrack.platform.domain.pk;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MatchPK implements Serializable {

    private OrgaoPK orgaoId;

    private Integer codigoReceptor;

    public MatchPK() {
    }

    public MatchPK(OrgaoPK orgaoId, Integer codigoReceptor) {
        this.orgaoId = orgaoId;
        this.codigoReceptor = codigoReceptor;
    }

    public OrgaoPK getOrgaoId() {
        return orgaoId;
    }

    public void setOrgaoId(OrgaoPK orgaoId) {
        this.orgaoId = orgaoId;
    }

    public Integer getCodigoReceptor() {
        return codigoReceptor;
    }

    public void setCodigoReceptor(Integer codigoReceptor) {
        this.codigoReceptor = codigoReceptor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchPK matchPK = (MatchPK) o;
        return Objects.equals(orgaoId, matchPK.orgaoId) &&
                Objects.equals(codigoReceptor, matchPK.codigoReceptor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orgaoId, codigoReceptor);
    }
}

