package br.com.healthtrack.platform.dto;

import br.com.healthtrack.platform.domain.Endereco;

public class EnderecoDTO {

    private Integer codigo;
    private String cep;
    private String logradouro;
    private String cidade;
    private String uf;
    private String complemento;

    public EnderecoDTO(Endereco endereco) {
        this.codigo = endereco.getCodigo();
        this.cep = endereco.getCep();
        this.logradouro = endereco.getLogradouro();
        this.cidade = endereco.getCidade();
        this.uf = endereco.getUf();
        this.complemento = endereco.getComplemento();
    }

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
}
