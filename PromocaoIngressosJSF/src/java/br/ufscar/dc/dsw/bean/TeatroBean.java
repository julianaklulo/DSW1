package br.ufscar.dc.dsw.bean;

import br.ufscar.dc.dsw.dao.TeatroDAO;
import br.ufscar.dc.dsw.pojo.Teatro;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class TeatroBean {
    private Teatro teatro;
    private List<Teatro> teatros;
    private List<Teatro> teatrosByCidade;
    private List<String> cidades;
    private String cidade;

    public Teatro getTeatro() {
        return teatro;
    }

    public void setTeatro(Teatro teatro) {
        this.teatro = teatro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    public String lista() {
        cidade = null;
        return "teatro/index.xhtml";
    }
    
    public String listaTodos() {
        cidade = null;
        return "teatro/listaTodosTeatros.xhtml";
    }

    public String cadastra() {
        teatro = new Teatro();
        return "form.xhtml";
    }

    public String edita(Long id) {
        TeatroDAO dao = new TeatroDAO();
        teatro = dao.get(id);
        return "form.xhtml";
    }

    public String salva() {
        TeatroDAO dao = new TeatroDAO();
        if (teatro.getId() == null) {
            dao.save(teatro);
        } else {
            dao.update(teatro);
        }
        return "index.xhtml";
    }

    public String delete(Teatro teatro) {
        TeatroDAO dao = new TeatroDAO();
        dao.delete(teatro);
        return "index.xhtml";
    }

    public String volta() {
        return "/index.xhtml?faces-redirect=true";
    }

    public List<Teatro> getTeatros() throws SQLException {
        TeatroDAO dao = new TeatroDAO();
        if (cidade != null) {
            return dao.getAllByCidade(cidade);
        } else {
            return dao.getAll();
        }
    }
    
    public List<String> getCidades() throws SQLException {
        TeatroDAO dao = new TeatroDAO();
        return dao.getCidades();
    }
    
    public String getTeatrosByCidade() throws SQLException {
        return "teatro/listaTeatroPorCidade.xhtml";
    }
}