package br.ufscar.dc.dsw.model;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Promocao {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE) @Column(name = "id", nullable = false)
    private Integer id;
    private String url;
    private String cnpj;
    private String nomePeca;
    private Float preco;
    private String dataHora;

    public Promocao(Integer id) {
        this.id = id;
    }
    
    public Promocao(Integer id, String url, String cnpj, String nomePeca, Float preco, String dataHora){
        this.id = id;
        this.url = url;
        this.cnpj = cnpj;
        this.nomePeca = nomePeca;
        this.preco = preco;
        this.dataHora = dataHora;
    }
    
    public Promocao(String url, String cnpj, String nomePeca, Float preco, String dataHora){
        this.url = url;
        this.cnpj = cnpj;
        this.nomePeca = nomePeca;
        this.preco = preco;
        this.dataHora = dataHora;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getUrl() {
        return url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    public String getCnpj() {
        return cnpj;
    }
    
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    public String getNomePeca() {
        return nomePeca;
    }
    
    public void setNomePeca(String nomePeca) {
        this.nomePeca = nomePeca;
    }
    
    public Float getPreco() {
        return preco;
    }
    
    public void setPreco(Float preco) {
        this.preco = preco;
    }
    
    public String getDataHora() {
        return dataHora;
    }
    
    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }
}