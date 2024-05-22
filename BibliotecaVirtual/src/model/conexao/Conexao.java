package model.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {
    private static final String url = "jdbc:mysql://localhost:3306/biblioteca";
    private static final String user = "root";
    private static final String password = "";
    
    private Connection conn = null;
    
      
        public Connection criaConexao(){
            try {
                if(conn == null){
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    conn = DriverManager.getConnection(url, user, password);
                } else if (conn.isClosed()) {
                    conn = null;
                    return criaConexao();
                }
            } catch (ClassNotFoundException e) {
                System.out.println("Driver não encontrato");
                System.out.println("Erro: " + e.getMessage());
            } catch (SQLException e) {
                System.out.println("Não foi possível efetuar conexão");
                System.out.println("Erro: " + e.getMessage());
            }
            return conn;
        }
        
        public void fechaConexao() {
            if (conn != null) {
              try {
                conn.close();
              } catch (SQLException e) {
                //TODO: use um sistema de log apropriado.
                e.printStackTrace();
              }
            }
        }
    
        
}
