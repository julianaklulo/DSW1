package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.pojo.Promocao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class PromocaoDAO extends GenericDAO<Promocao>{
    
    @Override
    public void save(Promocao promocao) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(promocao);
        tx.commit();
        em.close();
    }
    
    @Override
    public List<Promocao> getAll() {
        EntityManager em = this.getEntityManager();
        Query q = em.createQuery("select p from Promocao p", Promocao.class);
        List<Promocao> promocoes = q.getResultList();
        em.close();
        return promocoes;
    }

    @Override
    public void delete(Promocao promocao) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        promocao = em.getReference(Promocao.class, promocao.getId());
        tx.begin();
        em.remove(promocao);
        tx.commit();
    }
    
    @Override
    public void update(Promocao promocao) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(promocao);
        tx.commit();
        em.close();
    }

    @Override
    public Promocao get(Long id) {
        EntityManager em = this.getEntityManager();
        Promocao promocao = em.find(Promocao.class, id);
        em.close();
        return promocao;
    }
    
    public List<Promocao> getAllByTeatro(Long id) {
        EntityManager em = this.getEntityManager();
        String s = "select p from Promocao p where p.teatro.id = :id";
        TypedQuery<Promocao> q = em.createQuery(s, Promocao.class);
        q.setParameter("id", id);
        return q.getResultList();
    }
    
    public List<Promocao> getAllBySite(Long id) {
        EntityManager em = this.getEntityManager();
        String s = "select p from Promocao p where p.site.id = :id";
        TypedQuery<Promocao> q = em.createQuery(s, Promocao.class);
        q.setParameter("id", id);
        return q.getResultList();
    }
}