package br.com.healthtrack.platform.domain;

import javax.persistence.*;

@Entity
@Table(name = "T_CREDENCIAL")
@SequenceGenerator(name = "sqCredencial", sequenceName = "SQ_CREDENCIAL", allocationSize = 1)
public class Credencial {

    @Id
    @Column(name = "cd_credencial")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sqCredencial")
    private Integer codigo;

    @ManyToOne
    @JoinColumn(name = "cd_hospital")
    private Hospital hospital;

    @Column(name = "ds_email")
    private String email;

    @Column(name = "ds_senha")
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(name = "ds_tipo_usuario")
    private TipoUsuario tipoUsuario;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
