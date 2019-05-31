package br.ufscar.dc.dsw.bean;

import br.ufscar.dc.dsw.dao.PromocaoDAO;
import br.ufscar.dc.dsw.pojo.Promocao;
import br.ufscar.dc.dsw.pojo.Teatro;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class PromocaoBean {

    private Promocao promocao;
    private List<Promocao> promocoes;
    private List<Promocao> promocoesByTeatro;
    private Teatro teatro;

    public Teatro getTeatro() {
        return teatro;
    }

    public void setTeatro(Teatro teatro) {
        this.site = null;
        this.teatro = teatro;
    }
    public String lista() {
        site = null;
        return "promocao/index.xhtml";
    }

    public String cadastra() {
        promocao = new Promocao();
        return "form.xhtml";
    }

    public String edita(Long id) {
        PromocaoDAO dao = new PromocaoDAO();
        promocao = dao.get(id);
        return "form.xhtml";
    }

    public String salva() {
        PromocaoDAO dao = new PromocaoDAO();
        if (promocao.getId() == null) {
            dao.save(promocao);
        } else {
            dao.update(promocao);
        }
        return "index.xhtml";
    }

    public String delete(Promocao promocao) {
        PromocaoDAO dao = new PromocaoDAO();
        dao.delete(promocao);
        return "index.xhtml";
    }

    public String volta() {
        return "/index.xhtml?faces-redirect=true";
    }

    public List<Promocao> getPromocoes() throws SQLException {
        PromocaoDAO dao = new PromocaoDAO();
        } else if (teatro != null) {
            return dao.getAllByTeatro(teatro.getId());
        } else {
        return dao.getAll();
        }

    public Promocao getPromocao() {
        return promocao;
    }
    
    public String getPromocoesByTeatro() throws SQLException {
        site = null;
        return "promocao/listaPromocaoPorTeatro.xhtml";
    }
    
    public String getPromocoesBySite(Long id) throws SQLException {
        PromocaoDAO dao = new PromocaoDAO();
        promocoes = dao.getAllBySite(id);
        return "promocao/listaPromocaoPorSite.xhtml";
    }
}