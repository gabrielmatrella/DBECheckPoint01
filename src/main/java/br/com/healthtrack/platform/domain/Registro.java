package br.com.healthtrack.platform.domain;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "T_REGISTROS")
@SequenceGenerator(name = "sqRegistro", sequenceName = "SQ_REGISTRO", allocationSize = 1)
public class Registro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sqRegistro")
    @Column(name = "cd_registro")
    private Integer codigo;

    @OneToOne
    @JoinColumns({
            @JoinColumn(name = "cd_orgao"),
            @JoinColumn(name = "cd_paciente_doador"),
            @JoinColumn(name = "cd_paciente_receptor")
    })
    private Match match;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_registro")
    private Calendar data;

    @Column(name = "ds_motivo")
    private String motivo;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}
