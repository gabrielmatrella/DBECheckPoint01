package br.com.healthtrack.platform.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "T_DOADOR")
public class Doador extends Paciente {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "doador")
    private List<Orgao> orgaosDoacao;

    public List<Orgao> getOrgaosDoacao() {
        return orgaosDoacao;
    }

    public void setOrgaosDoacao(List<Orgao> orgaosDoacao) {
        this.orgaosDoacao = orgaosDoacao;
    }
}
