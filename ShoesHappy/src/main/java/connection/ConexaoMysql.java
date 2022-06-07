package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoMysql {
	
	  public static String DRIVER = "com.mysql.cj.jdbc.Driver";
	  public static String URL = "jdbc:mysql://localhost:3306/conexaojsp";
	  public static String USER = "root";
	  public static String PASS = "";
	    
	  public static Connection iniciarConexao() throws SQLException{
	      try {
	          Class.forName(DRIVER);
	          return DriverManager.getConnection(URL, USER, PASS);
	          
	      } catch (ClassNotFoundException ex) {
	          Logger.getLogger(ConexaoMysql.class.getName()).log(Level.SEVERE, null, ex);
	       	}
	        return null;
	        
	    }
	    
	    public static void encerrarConexao(Connection connection){
	        if (connection != null ){
	            try {
	                connection.close();
	            } catch (SQLException ex) {
	                Logger.getLogger(ConexaoMysql.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        }
	    }
	    
	    public static void encerrarConexao(Connection connection, PreparedStatement stmt){
	        encerrarConexao(connection);
	        
	        try {
	            stmt.close();
	        } catch (SQLException ex) {
	            Logger.getLogger(ConexaoMysql.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }
	    
	    public static void encerrarConexao(Connection connection, PreparedStatement stmt, ResultSet rs){
	        encerrarConexao(connection, stmt);
	        
	        try {
	            rs.close();
	        } catch (SQLException ex) {
	            Logger.getLogger(ConexaoMysql.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }
}


