package br.com.healthtrack.platform.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Calendar;

@Entity
@Table(name = "T_PACIENTE")
@SequenceGenerator(name = "sqPaciente", sequenceName = "SQ_PACIENTE", allocationSize = 1)
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Paciente {

    @Id
    @Column(name = "cd_paciente")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sqPaciente")
    private Integer codigo;

    @ManyToOne
    @JoinColumn(name = "cd_hospital")
    private Hospital hospital;

    @NotBlank(message = "Nome obrigatório")
    private String nome;

    @NotBlank(message = "Sobrenome obrigatório")
    private String sobrenome;

    @Temporal(TemporalType.DATE)
    @Past(message = "Data deve ser menor do que a atual")
    @NotNull(message = "Data de nascimento obrigatória")
    private Calendar dataNascimento;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Tipo sanguineo obrigatório")
    private TipoSanguineo tipoSanguineo;

    @Column(name = "in_arquivado")
    private boolean arquivado;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cd_endereco")
    private Endereco endereco;

    @Column(name = "ds_rg")
    @NotBlank(message = "Rg obrigatório")
    private String rg;

    @Column(name = "ds_cpf")
    @NotBlank(message = "Cpf obrigatório")
    private String cpf;

    @Column(name = "ds_telefone")
    @NotBlank(message = "Telefone obrigatório")
    private String telefone;

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

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public TipoSanguineo getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(TipoSanguineo tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public boolean isArquivado() {
        return arquivado;
    }

    public void setArquivado(boolean arquivado) {
        this.arquivado = arquivado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }


}
