package br.com.healthtrack.platform.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "T_HOSPITAL")
@SequenceGenerator(name = "sqHospital", sequenceName = "SQ_HOSPITAL", allocationSize = 1)
public class Hospital {

    @Id
    @Column(name = "cd_hospital")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sqHospital")
    private Integer codigo;

    @Column(name = "nm_hospital")
    private String nome;

    @Column(name = "ds_latitude")
    private String latitude;

    @Column(name = "ds_longitude")
    private String longitude;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "hospital", cascade = CascadeType.ALL)
    private List<Credencial> credenciais = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "hospital")
    private List<Paciente> pacientes;

    public Hospital() {
    }

    public Hospital(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void addCredencial(Credencial credencial) {
        credencial.setHospital(this);
        this.credenciais.add(credencial);
    }

    public List<Credencial> getCredenciais() {
        return credenciais;
    }

    public void setCredenciais(List<Credencial> credenciais) {
        this.credenciais = credenciais;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }
}
