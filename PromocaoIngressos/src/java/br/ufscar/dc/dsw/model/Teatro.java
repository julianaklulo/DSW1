package br.ufscar.dc.dsw.model;

public class Teatro {
    private String nome;
    private String cidade;
    private String cnpj;
    private String email;
    private String senha;

    public Teatro(String cnpj) {
        this.cnpj = cnpj;
    }
    
    public Teatro(String nome, String cidade, String cnpj, String email, String senha) {
        this.nome = nome;
        this.cidade = cidade;
        this.cnpj = cnpj;
        this.email = email;
        this.senha = senha;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String Nome) {
        this.nome = nome;
    }
    
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    public String getCnpj() {
        return cnpj;
    }
    
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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



