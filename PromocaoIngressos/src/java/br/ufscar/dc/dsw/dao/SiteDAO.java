package br.ufscar.dc.dsw.dao;
import br.ufscar.dc.dsw.model.Site;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SiteDAO {
    public SiteDAO() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    
    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:derby://localhost:1527/SiteVenda", "root", "root");
    }
    
    public void insert(Site site) {
        String sql = "INSERT INTO sites (nome, telefone, url, email, senha) VALUES (?, ?, ?, ?, ?)";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, site.getNome());
            statement.setString(2, site.getTelefone());
            statement.setString(3, site.getUrl());
            statement.setString(4, site.getEmail());
            statement.setString(5, site.getSenha());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
        throw new RuntimeException(e);
        }
    }
    
    public List<Site> getAll() {
        List<Site> listaSites = new ArrayList<>();
        String sql = "SELECT * FROM sites";
        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String telefone = resultSet.getString("telefone");
                String url = resultSet.getString("url");
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                Site site = new Site(nome, telefone, url, email, senha);
                listaSites.add(site);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaSites;
    }
    
    public void delete(Site site) {
        String sql = "DELETE FROM sites where url = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, site.getUrl());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void update(Site site) {
        String sql = "UPDATE sites SET nome = ?, telefone = ?, email = ?, senha = ?";
        sql += " WHERE url = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, site.getNome());
            statement.setString(2, site.getTelefone());
            statement.setString(3, site.getEmail());
            statement.setString(4, site.getSenha());
            statement.setString(5, site.getUrl());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Site get(String url) {
        Site site = null;
        String sql = "SELECT * FROM sites WHERE url = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, url);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String telefone = resultSet.getString("telefone");
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                site = new Site(url, nome, telefone, email, senha);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return site;
    }
}
