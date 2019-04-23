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

@WebServlet(urlPatterns = {"/promocoes", "/promocoes/cadastro", "/promocoes/insercao", "/promocoes/remocao", "/promocoes/edicao", "/promocoes/atualizacao", "/promocoes/teatro", "/promocoes/site"})
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
               case "/promocoes/teatro":
                    listaPorTeatro(request, response);
                    break;
                case "/promocoes/site":
                    listaPorSite(request, response);
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
        Integer id = Integer.parseInt(request.getParameter("id"));
        Promocao promocao = dao.get(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/promocao/formulario.jsp");
        request.setAttribute("promocao", promocao);
        dispatcher.forward(request, response);
    }
    
    private void insere(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String url = request.getParameter("url");
        String cnpj = request.getParameter("cnpj");
        String nomePeca = request.getParameter("nomePeca");
        Float preco = Float.parseFloat(request.getParameter("preco"));
        String dataHora = request.getParameter("dataHora");
        Promocao promocao = new Promocao(url, cnpj, nomePeca, preco, dataHora);
        dao.insert(promocao);
        response.sendRedirect("../promocoes");
    }
    
    private void atualize(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        Integer id = Integer.parseInt(request.getParameter("id"));
        String url = request.getParameter("url");
        String cnpj = request.getParameter("cnpj");
        String nomePeca = request.getParameter("nomePeca");
        Float preco = Float.parseFloat(request.getParameter("preco"));
        String dataHora = request.getParameter("dataHora");
        Promocao promocao = new Promocao(id, url, cnpj, nomePeca, preco, dataHora);
        dao.update(promocao);
        response.sendRedirect("../promocoes");
    }
    
    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Promocao promocao = new Promocao(id);
        dao.delete(promocao);
        response.sendRedirect("../promocoes");
    }
    
    private void listaPorTeatro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cnpj = "23.765.345/2019-04";
        List<Promocao> listaPromocoes = dao.getAllPromocaoTeatro(cnpj);
        request.setAttribute("listaPromocoes", listaPromocoes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/promocao/listaPorTeatro.jsp");
        dispatcher.forward(request, response);
    }
    
    private void listaPorSite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "www.vendasbco.com.br";
        List<Promocao> listaPromocoes = dao.getAllPromocaoSite(url);
        request.setAttribute("listaPromocoes", listaPromocoes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/promocao/listaPorSite.jsp");
        dispatcher.forward(request, response);
    }
}