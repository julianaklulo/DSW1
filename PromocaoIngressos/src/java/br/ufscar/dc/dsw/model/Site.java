package br.ufscar.dc.dsw.model;

public class Site {
    private String nome;
    private String telefone;
    private String url;
    private String email;
    private String senha;

    public Site(String url) {
        this.url = url;
    }
    
    public Site(String nome, String telefone, String url, String email, String senha) {
        this.nome = nome;
        this.telefone = telefone;
        this.url = url;
        this.email = email;
        this.senha = senha;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String Nome) {
        this.nome = nome;
    }
    
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public String getUrl() {
        return url;
    }
    
    public void setUrl(String url) {
        this.url = url;
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
}



