package br.ufscar.dc.dsw.controller;
import br.ufscar.dc.dsw.model.Teatro;
import br.ufscar.dc.dsw.dao.TeatroDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/teatros", "/teatros/cadastro", "/teatros/insercao", "/teatros/remocao", "/teatros/edicao", "/teatros/atualizacao"})
public class TeatroController extends HttpServlet {
    private TeatroDAO dao;

    @Override
    public void init() {
        dao = new TeatroDAO();
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
                case "/teatros/cadastro":
                    apresentaFormCadastro(request, response);
                    break;
                case "/teatros/insercao":
                    insere(request, response);
                    break;
                case "/teatros/remocao":
                    remove(request, response);
                    break;
                case "/teatros/edicao":
                    apresentaFormEdicao(request, response);
                    break;
                case "/teatros/atualizacao":
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
        List<Teatro> listaTeatros = dao.getAll();
        request.setAttribute("listaTeatros", listaTeatros);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/teatro/lista.jsp");
        dispatcher.forward(request, response);
    }
    
    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/teatro/formulario.jsp");
        dispatcher.forward(request, response);
    }
    
    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cnpj = request.getParameter("cnpj");
        Teatro teatro = dao.get(cnpj);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/teatro/formulario.jsp");
        request.setAttribute("teatro", teatro);
        dispatcher.forward(request, response);
    }
    
    private void insere(HttpServletRequest request, HttpServletResponse response) throws IOException{
        request.setCharacterEncoding("UTF-8");
        String nome = request.getParameter("nome");
        String cidade = request.getParameter("cidade");
        String cnpj = request.getParameter("cnpj");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        Teatro teatro = new Teatro(nome, cidade, cnpj, email, senha);
        dao.insert(teatro);
        response.sendRedirect("../teatros");
    }
    
    private void atualize(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String nome = request.getParameter("nome");
        String cidade = request.getParameter("cidade");
        String cnpj = request.getParameter("cnpj");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        Teatro teatro = new Teatro(nome, cidade, cnpj, email, senha);
        dao.update(teatro);
        response.sendRedirect("../teatros");
    }
    
    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String cnpj = request.getParameter("cnpj");
        Teatro teatro = new Teatro(cnpj);
        dao.delete(teatro);
        response.sendRedirect("../teatros");
    }
}