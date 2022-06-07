package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConexaoMysql;
import model.Usuario;

public class UsuarioDAO {
	public void create(Usuario usuario) throws SQLException{
        Connection connection = ConexaoMysql.iniciarConexao();
        PreparedStatement stmt = null;
        
        try {
            stmt = connection.prepareStatement("INSERT INTO usuario(nome, endereco, modalidade) VALUES(?, ?, ?)");
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEndereco());
            stmt.setString(3, usuario.getModalidade());
            
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConexaoMysql.encerrarConexao(connection, stmt);
        }
        
    }
                
    public ArrayList<Usuario> read() throws SQLException{
        Connection connection = ConexaoMysql.iniciarConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        
        try {
            stmt = connection.prepareStatement("SELECT * FROM usuario");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Usuario usuario = new Usuario();
                usuario.setMatricula(rs.getInt("matricula"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEndereco(rs.getString("endereco"));
                usuario.setModalidade(rs.getString("modalidade"));
                listaUsuarios.add(usuario);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConexaoMysql.encerrarConexao(connection, stmt, rs);
        }
        return listaUsuarios;
        
        
    }
    public void update(Usuario usuario) throws SQLException{
        Connection connection = ConexaoMysql.iniciarConexao();
        PreparedStatement stmt = null;
        
        try {
            stmt = connection.prepareStatement("UPDATE usuario SET nome = ?, endereco = ? , modalidade =? WHERE matriculausuario = ?");
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEndereco());
            stmt.setString(3, usuario.getModalidade());
            stmt.setInt(4, usuario.getMatricula());
            
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConexaoMysql.encerrarConexao(connection, stmt);
        }
        
    }
        
        
    
    public void delete(Usuario usuario) throws SQLException{
        Connection connection = ConexaoMysql.iniciarConexao();
        PreparedStatement stmt = null;
        
        try {
            stmt = connection.prepareStatement("DELETE FROM usuario WHERE matriculausuario = ?");
            stmt.setInt(1, usuario.getMatricula());
            
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConexaoMysql.encerrarConexao(connection, stmt);
        }
        
    }

}
