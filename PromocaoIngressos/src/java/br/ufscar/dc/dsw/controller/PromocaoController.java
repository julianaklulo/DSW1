package br.ufscar.dc.dsw.controller;
import br.ufscar.dc.dsw.model.Promocao;
import br.ufscar.dc.dsw.dao.PromocaoDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/promocoes", "/promocoes/escolheSite", "/promocoes/listaPorSite", "/promocoes/escolheTeatro", "/promocoes/listaPorTeatro", "/promocoes/cadastro", "/promocoes/insercao", "/promocoes/remocao", "/promocoes/edicao", "/promocoes/atualizacao"})
public class PromocaoController extends HttpServlet {
    private PromocaoDAO dao;

    @Override
    public void init() {
        dao = new PromocaoDAO();
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        doGet(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/promocoes/cadastro":
                    apresentaFormCadastro(request, response);
                    break;
                case "/promocoes/insercao":
                    insere(request, response);
                    break;
                case "/promocoes/remocao":
                    remove(request, response);
                    break;
                case "/promocoes/edicao":
                    apresentaFormEdicao(request, response);
                    break;
                case "/promocoes/atualizacao":
                    atualize(request, response);
                    break;
                case "/promocoes/escolheSite":
                    escolheSite(request, response);
                    break;
                case "/promocoes/listaPorSite":
                    listaPorSite(request, response);
                    break;
                case "/promocoes/escolheTeatro":
                    escolheTeatro(request, response);
                    break;
                case "/promocoes/listaPorTeatro":
                    listaPorTeatro(request, response);
                    break;
                default:
                    lista(request, response);
                    break;
            }
        } catch (RuntimeException | IOException | ServletException e) {
            throw new ServletException(e);
        }
    }
    
    private void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Promocao> listaPromocoes = dao.getAll();
        request.setAttribute("listaPromocoes", listaPromocoes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/promocao/lista.jsp");
        dispatcher.forward(request, response);
    }
    
    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/promocao/formulario.jsp");
        dispatcher.forward(request, response);
    }
    
    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getParameter("url");
        String cnpj = request.getParameter("cnpj");
        String datahora = request.getParameter("datahora");
        Promocao promocao = dao.get(url, cnpj, datahora);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/promocao/formulario.jsp");
        request.setAttribute("promocao", promocao);
        dispatcher.forward(request, response);
    }
    
    private void insere(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String url = request.getParameter("url");
        String cnpj = request.getParameter("cnpj");
        String nomepeca = request.getParameter("nomepeca");
        Float preco = Float.parseFloat(request.getParameter("preco"));
        String datahora = request.getParameter("datahora");
        Promocao promocao = new Promocao(url, cnpj, nomepeca, preco, datahora);
        dao.insert(promocao);
        response.sendRedirect("../promocoes");
    }
    
    private void atualize(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String url = request.getParameter("url");
        String cnpj = request.getParameter("cnpj");
        String nomepeca = request.getParameter("nomepeca");
        Float preco = Float.parseFloat(request.getParameter("preco"));
        String datahora = request.getParameter("datahora");
        Promocao promocao = new Promocao(url, cnpj, nomepeca, preco, datahora);
        dao.update(promocao);
        response.sendRedirect("../promocoes");
    }
    
    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String url = request.getParameter("url");
        String cnpj = request.getParameter("cnpj");
        String datahora = request.getParameter("datahora");
        Promocao promocao = new Promocao(url, cnpj, datahora);
        dao.delete(promocao);
        response.sendRedirect("../promocoes");
    }
    
    private void escolheSite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> listaSites = dao.sites();
        request.setAttribute("sites", listaSites);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/promocao/escolheSite.jsp");
        dispatcher.forward(request, response);
    }
    
    private void listaPorSite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String site = request.getParameter("site");  
        List<Promocao> listaPromocoes = dao.getPromocaoBySite(site);
        request.setAttribute("listaPromocoes", listaPromocoes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/promocao/listaPorSite.jsp");
        dispatcher.forward(request, response);
    }
    
    private void escolheTeatro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> listaTeatros = dao.teatros();
        request.setAttribute("teatros", listaTeatros);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/promocao/escolheTeatro.jsp");
        dispatcher.forward(request, response);
    }
    
    private void listaPorTeatro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String teatro = request.getParameter("teatro");  
        List<Promocao> listaPromocoes = dao.getPromocaoByTeatro(teatro);
        request.setAttribute("listaPromocoes", listaPromocoes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/promocao/listaPorTeatro.jsp");
        dispatcher.forward(request, response);
    }
}