package br.ufscar.dc.dsw.dao;
import br.ufscar.dc.dsw.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

abstract public class GenericDAO {
    public GenericDAO() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:derby://localhost:1527/PromocaoIngressos", "root", "root");
    }
    
    public void insertUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (email, senha, papel, ativo) VALUES (?, ?, ?, true)";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, usuario.getEmail());
            statement.setString(2, usuario.getSenha());
            statement.setString(3, usuario.getPapel());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
        throw new RuntimeException(e);
        }
    }
    
    public void updateUsuario(Usuario usuario) {
        String sql = "UPDATE usuarios SET senha = ?";
        sql += " WHERE email = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, usuario.getSenha());
            statement.setString(2, usuario.getEmail());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
        throw new RuntimeException(e);
        }
    }
}