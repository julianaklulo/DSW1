package br.ufscar.dc.dsw.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Promocao implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="site", nullable=false)
    private Site site;
    
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="teatro", nullable=false)
    private Teatro teatro;
    
    String nomepeca;
    Float preco;
    
    @Temporal(TemporalType.DATE)
    private Date data;
    
    private String hora;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Site getSite() {
        return site;
    }
    
    public void setSite(Site site) {
        this.site = site;
    }
    
    public Teatro getTeatro() {
        return teatro;
    }
    
    public void setTeatro(Teatro teatro) {
        this.teatro = teatro;
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
    
    public Date getData() {
        return data;
    }
    
    public void setData(Date data) {
        this.data = data;
    }
    
    public String getHora() {
        return hora;
    }
    
    public void setHora(String hora) {
        this.hora = hora;
    }
}