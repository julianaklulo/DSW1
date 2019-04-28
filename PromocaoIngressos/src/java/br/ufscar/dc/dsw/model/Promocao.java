package br.ufscar.dc.dsw.model;

public class Promocao {
    private String url;
    private String cnpj;
    private String nomepeca;
    private Float preco;
    private String datahora;

    public Promocao(String url, String cnpj, String datahora){
        this.url = url;
        this.cnpj = cnpj;
        this.datahora = datahora;
    }
    
    public Promocao(String url, String cnpj, String nomepeca, Float preco, String datahora){
        this.url = url;
        this.cnpj = cnpj;
        this.nomepeca = nomepeca;
        this.preco = preco;
        this.datahora = datahora;
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
        return nomepeca;
    }
    
    public void setNomePeca(String nomepeca) {
        this.nomepeca = nomepeca;
    }
    
    public Float getPreco() {
        return preco;
    }
    
    public void setPreco(Float preco) {
        this.preco = preco;
    }
    
    public String getDataHora() {
        return datahora;
    }
    
    public void setDataHora(String datahora) {
        this.datahora = datahora;
    }
}