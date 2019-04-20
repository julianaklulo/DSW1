package br.ufscar.dc.dsw.controller;
import br.ufscar.dc.dsw.model.Site;
import br.ufscar.dc.dsw.dao.SiteDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/")
public class SiteController extends HttpServlet {
    private SiteDAO dao;

    @Override
    public void init() {
        dao = new SiteDAO();
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
                case "/cadastro":
                    apresentaFormCadastro(request, response);
                    break;
                case "/insercao":
                    insere(request, response);
                    break;
                case "/remocao":
                    remove(request, response);
                    break;
                case "/edicao":
                    apresentaFormEdicao(request, response);
                    break;
                case "/atualizacao":
                    atualize(request, response);
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
        List<Site> listaSites = dao.getAll();
        request.setAttribute("listaSites", listaSites);
        RequestDispatcher dispatcher = request.getRequestDispatcher("site/lista.jsp");
        dispatcher.forward(request, response);
    }
    
    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("site/formulario.jsp");
        dispatcher.forward(request, response);
    }
    
    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getParameter("url");
        Site site = dao.get(url);
        RequestDispatcher dispatcher = request.getRequestDispatcher("site/formulario.jsp");
        request.setAttribute("site", site);
        dispatcher.forward(request, response);
    }
    
    private void insere(HttpServletRequest request, HttpServletResponse response) throws IOException{
        request.setCharacterEncoding("UTF-8");
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");
        String url = request.getParameter("url");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        Site site = new Site(nome, telefone, url, email, senha);
        dao.insert(site);
        response.sendRedirect("lista");
    }
    
    private void atualize(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");
        String url = request.getParameter("url");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        Site site = new Site(nome, telefone, url, email, senha);
        dao.update(site);
        response.sendRedirect("lista");
    }
    
    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String url = request.getParameter("url");
        Site site = new Site(url);
        dao.delete(site);
        response.sendRedirect("lista");
    }
}