package br.ufscar.dc.dsw.dao;
import br.ufscar.dc.dsw.model.Teatro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TeatroDAO extends GenericDAO {
    public void insert(Teatro teatro) {
        String sql = "INSERT INTO teatros (nome, cidade, cnpj, email, senha) VALUES (?, ?, ?, ?, ?)";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, teatro.getNome());
            statement.setString(2, teatro.getCidade());
            statement.setString(3, teatro.getCnpj());
            statement.setString(4, teatro.getEmail());
            statement.setString(5, teatro.getSenha());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
        throw new RuntimeException(e);
        }
    }
    
    public List<Teatro> getAll() {
        List<Teatro> listaTeatros = new ArrayList<>();
        String sql = "SELECT * FROM teatros";
        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String cidade = resultSet.getString("cidade");
                String cnpj = resultSet.getString("cnpj");
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                Teatro teatro = new Teatro(nome, cidade, cnpj, email, senha);
                listaTeatros.add(teatro);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaTeatros;
    }
    
    public List<Teatro> getTeatroByCidade(String c) {
        List<Teatro> listaTeatrosCidade = new ArrayList<>();
        String sql = "SELECT * FROM teatros WHERE cidade = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, c);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String cidade = resultSet.getString("cidade");
                String cnpj = resultSet.getString("cnpj");
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                Teatro teatro = new Teatro(nome, cidade, cnpj, email, senha);
                listaTeatrosCidade.add(teatro);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaTeatrosCidade;
    }
    
    public void delete(Teatro teatro) {
        String sql = "DELETE FROM teatros where cnpj = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, teatro.getCnpj());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void update(Teatro teatro) {
        String sql = "UPDATE teatros SET nome = ?, cidade = ?, email = ?, senha = ?";
        sql += " WHERE cnpj = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, teatro.getNome());
            statement.setString(2, teatro.getCidade());
            statement.setString(3, teatro.getEmail());
            statement.setString(4, teatro.getSenha());
            statement.setString(5, teatro.getCnpj());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Teatro get(String cnpj) {
        Teatro teatro = null;
        String sql = "SELECT * FROM teatros WHERE cnpj = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, cnpj);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String cidade = resultSet.getString("cidade");
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                teatro = new Teatro(nome, cidade, cnpj, email, senha);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return teatro;
    }
}
