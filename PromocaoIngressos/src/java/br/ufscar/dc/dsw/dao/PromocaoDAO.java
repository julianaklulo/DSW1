package br.ufscar.dc.dsw.dao;
import br.ufscar.dc.dsw.model.Teatro;
import br.ufscar.dc.dsw.model.Site;
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
        String sql = "INSERT INTO promocoes (url, cnpj, nome_peça, preco, data_hora) VALUES (?, ?, ?, ?, ?)";
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
                Integer id = Integer.parseInt(resultSet.getString("id"));
                String url = resultSet.getString("url");
                String cnpj = resultSet.getString("cnpj");
                String nomePeca = resultSet.getString("nome_peça");
                Float preco = Float.parseFloat(resultSet.getString("preco"));
                String dataHora = resultSet.getString("data_hora");
                Promocao promocao = new Promocao(id, url, cnpj, nomePeca, preco, dataHora);
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
        String sql = "DELETE FROM promocoes where id = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, Integer.toString(promocao.getId()));
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void update(Promocao promocao) {
        String sql = "UPDATE promocoes SET url = ?, cnpj = ?, nome_peça = ?, preco = ?, data_hora = ?";
        sql += " WHERE id = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, promocao.getUrl());
            statement.setString(2, promocao.getCnpj());
            statement.setString(3, promocao.getNomePeca());
            statement.setString(4, Float.toString(promocao.getPreco()));
            statement.setString(5, promocao.getDataHora());
            statement.setString(6, Integer.toString(promocao.getId()));
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Promocao get(Integer id) {
        Promocao promocao = null;
        String sql = "SELECT * FROM promocoes WHERE id = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, Integer.toString(id));
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String url = resultSet.getString("url");
                String cnpj = resultSet.getString("cnpj");
                String nomePeca = resultSet.getString("nome_peça");
                Float preco = Float.parseFloat(resultSet.getString("preco"));
                String dataHora = resultSet.getString("data_hora");
                promocao = new Promocao(id, url, cnpj, nomePeca, preco, dataHora);
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
                Integer id = resultSet.getInt("id");
                String url = resultSet.getString("url");
                String cnpj = resultSet.getString("cnpj");
                String nomePeca = resultSet.getString("nome_peça");
                Float preco = resultSet.getFloat("preco");
                String dataHora = resultSet.getString("data_hora");
                Promocao promocao = new Promocao(id, url, cnpj, nomePeca, preco, dataHora);
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
    
    public List<Promocao> getAllPromocaoSite(String u) {
        List<Promocao> listaPromocaoSite = new ArrayList<>();
        String sql = "SELECT * FROM promocoes WHERE url = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, u);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) { 
                Integer id = resultSet.getInt("id");
                String url = resultSet.getString("url");
                String cnpj = resultSet.getString("cnpj");
                String nomePeca = resultSet.getString("nome_peça");
                Float preco = resultSet.getFloat("preco");
                String dataHora = resultSet.getString("data_hora");
                Promocao promocao = new Promocao(id, url, cnpj, nomePeca, preco, dataHora);
                listaPromocaoSite.add(promocao);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaPromocaoSite;
    }
}
    
    