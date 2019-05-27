package br.ufscar.dc.dsw.bean;

import br.ufscar.dc.dsw.dao.SiteDAO;
import br.ufscar.dc.dsw.pojo.Site;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class SiteBean {

    private Site site;
    private List<Site> sites;

    public String lista() {
        return "site/index.xhtml";
    }

    public String cadastra() {
        site = new Site();
        return "form.xhtml";
    }

    public String edita(Long id) {
        SiteDAO dao = new SiteDAO();
        site = dao.get(id);
        return "form.xhtml";
    }

    public String salva() {
        SiteDAO dao = new SiteDAO();
        if (site.getId() == null) {
            dao.save(site);
        } else {
            dao.update(site);
        }
        return "index.xhtml";
    }

    public String delete(Site site) {
        SiteDAO dao = new SiteDAO();
        dao.delete(site);
        return "index.xhtml";
    }

    public String volta() {
        return "/index.xhtml?faces-redirect=true";
    }

    public List<Site> getSites() throws SQLException {
        SiteDAO dao = new SiteDAO();
        return dao.getAll();
    }

    public Site getSite() {
        return site;
    }
}