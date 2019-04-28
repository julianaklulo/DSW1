package br.ufscar.dc.dsw.model;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Usuario {
    String email;
    String senha;
    String papel;
    Boolean ativo;
    
    public Usuario(String email, String senha, String papel) {
        this.email = email;
        this.setSenha(senha);
        this.papel = papel;
        this.ativo = true;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getSenha() {
        return this.senha;
    }
    
    public void setSenha(String senha) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String senha_criptografada = encoder.encode(senha);
        this.senha = senha_criptografada;
    }
    
    public String getPapel() {
        return this.papel;
    }
    
    public void setPapel(String papel) {
        this.papel = papel;
    }
   
}
