package br.com.healthtrack.platform.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "T_ENDERECO")
@SequenceGenerator(name = "sqEndereco", sequenceName = "SQ_ENDERECO", allocationSize = 1)
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sqEndereco")
    @Column(name = "cd_endereco")
    private Integer codigo;

    @Column(name = "ds_cep")
    private String cep;

    @Column(name = "ds_logradouro")
    private String logradouro;

    @Column(name = "nm_cidade")
    private String cidade;

    @Column(name = "nm_uf")
    private String uf;

    @Column(name = "ds_complemento")
    private String complemento;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "endereco")
    private List<Paciente> pacientes;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }
}
