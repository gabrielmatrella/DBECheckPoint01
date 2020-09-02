package br.com.healthtrack.platform.dto;

import br.com.healthtrack.platform.domain.Receptor;
import br.com.healthtrack.platform.domain.TipoSanguineo;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Calendar;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReceptorDTO {

    private Integer codigo;

    private String nome;

    private String sobrenome;

    private TipoSanguineo tipoSanguineo;

    private Calendar dataNascimento;

    private String orgao;

    private Integer score;

    private String rg;

    private String cpf;

    private String telefone;

    private EnderecoDTO endereco;

    public ReceptorDTO(Receptor receptor) {
        if (receptor.getEndereco() != null) this.endereco = new EnderecoDTO(receptor.getEndereco());
        this.codigo = receptor.getCodigo();
        this.tipoSanguineo = receptor.getTipoSanguineo();
        this.nome = receptor.getNome();
        this.sobrenome = receptor.getSobrenome();
        this.dataNascimento = receptor.getDataNascimento();
        this.orgao = receptor.getOrgao();
        this.score = receptor.getScore();
        this.rg = receptor.getRg();
        this.cpf = receptor.getCpf();
        this.telefone = receptor.getTelefone();
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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public TipoSanguineo getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(TipoSanguineo tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getOrgao() {
        return orgao;
    }

    public void setOrgao(String orgao) {
        this.orgao = orgao;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
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
}
