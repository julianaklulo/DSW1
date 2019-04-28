package br.ufscar.dc.dsw.dao;
import br.ufscar.dc.dsw.model.Promocao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PromocaoDAO extends GenericDAO {
    public void insert(Promocao promocao) {
        String sql = "INSERT INTO promocoes (url, cnpj, nomepeca, preco, datahora) VALUES (?, ?, ?, ?, ?)";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, promocao.getUrl());
            statement.setString(2, promocao.getCnpj());
            statement.setString(3, promocao.getNomePeca());
            statement.setFloat(4, promocao.getPreco());
            statement.setString(5, promocao.getDataHora());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
        throw new RuntimeException(e);
        }
    }
        public List<Promocao> getAll() {
        List<Promocao> listaPromocoes = new ArrayList<>();
        String sql = "SELECT * FROM promocoes";
        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String url = resultSet.getString("url");
                String cnpj = resultSet.getString("cnpj");
                String nomepeca = resultSet.getString("nomepeca");
                Float preco = Float.parseFloat(resultSet.getString("preco"));
                String datahora = resultSet.getString("datahora");
                Promocao promocao = new Promocao(url, cnpj, nomepeca, preco, datahora);
                listaPromocoes.add(promocao);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaPromocoes;
    }
        
    public void delete(Promocao promocao) {
        String sql = "DELETE FROM promocoes where (url = ? and cnpj = ? and datahora = ?)";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, promocao.getUrl());
            statement.setString(2, promocao.getCnpj());
            statement.setString(3, promocao.getDataHora());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
        
    public void update(Promocao promocao) {
        String sql = "UPDATE promocoes SET (nomepeca = ?, preco = ?";
        sql += " WHERE (url = ? and cnpj = ? and datahora = ?)";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, promocao.getNomePeca());
            statement.setString(2, Float.toString(promocao.getPreco()));
            statement.setString(3, promocao.getUrl());
            statement.setString(4, promocao.getCnpj());
            statement.setString(5, promocao.getDataHora());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Promocao get(String url, String cnpj, String datahora) {
        Promocao promocao = null;
        String sql = "SELECT * FROM promocoes WHERE (url = ? and cnpj = ? and datahora = ?)";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, url);
            statement.setString(2, cnpj);
            statement.setString(3, datahora);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String nomepeca = resultSet.getString("nomepeca");
                Float preco = Float.parseFloat(resultSet.getString("preco"));
                promocao = new Promocao(url, cnpj, nomepeca, preco, datahora);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return promocao;
    }
        
    public List<Promocao> getAllPromocaoTeatro(String c) {
        List<Promocao> listaPromocoes = new ArrayList<>();
        String sql = "SELECT * FROM promocoes WHERE cnpj = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, c);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) { 
                String url = resultSet.getString("url");
                String cnpj = resultSet.getString("cnpj");
                String nomepeca = resultSet.getString("nomepeca");
                Float preco = resultSet.getFloat("preco");
                String datahora = resultSet.getString("datahora");
                Promocao promocao = new Promocao(url, cnpj, nomepeca, preco, datahora);
                listaPromocoes.add(promocao);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaPromocoes;
    }
    
    public List<String> sites() {
        List<String> listaSites = new ArrayList<>();
        String sql = "SELECT DISTINCT url FROM promocoes";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String site = resultSet.getString("url");
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
    
    public List<String> teatros() {
        List<String> listaTeatros = new ArrayList<>();
        String sql = "SELECT distinct t.cnpj FROM teatros t, promocoes p WHERE p.cnpj = t.cnpj";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String teatro = resultSet.getString("cnpj");
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
    
    public List<Promocao> getPromocaoBySite(String u) {
        List<Promocao> listaPromocoesSite = new ArrayList<>();
        String sql = "SELECT * FROM promocoes WHERE url = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, u);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String url = resultSet.getString("url");
                String cnpj = resultSet.getString("cnpj");
                String nomepeca = resultSet.getString("nomepeca");
                Float preco = resultSet.getFloat("preco");
                String datahora = resultSet.getString("datahora");
                Promocao promocao = new Promocao(url, cnpj, nomepeca, preco, datahora);
                listaPromocoesSite.add(promocao);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaPromocoesSite;
    }
    
    public List<Promocao> getPromocaoByTeatro(String t) {
        List<Promocao> listaPromocoesTeatro = new ArrayList<>();
        String sql = "SELECT * FROM promocoes WHERE cnpj = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, t);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String url = resultSet.getString("url");
                String cnpj = resultSet.getString("cnpj");
                String nomepeca = resultSet.getString("nomepeca");
                Float preco = resultSet.getFloat("preco");
                String datahora = resultSet.getString("datahora");
                Promocao promocao = new Promocao(url, cnpj, nomepeca, preco, datahora);
                listaPromocoesTeatro.add(promocao);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaPromocoesTeatro;
    }
}
    
    