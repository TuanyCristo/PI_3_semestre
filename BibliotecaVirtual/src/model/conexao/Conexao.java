package model.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {
    private static final String url = "jdbc:mysql://localhost:3306/biblioteca/";
    private static final String user = "root";
    private static final String password = "";
    
    private Connection conn = null;
    
   

public class ConexaoBanco {

        public ConexaoBanco() {         
            
        }
        
        public Connection criaConexao(){
            try {
                if(conn == null){
                    Class.forName("org.gjt.mm.mysql.Driver");
                    conn = DriverManager.getConnection(url, user, password);
                } else if (conn.isClosed()) {
                    conn = null;
                    return criaConexao();
                }
            } catch (ClassNotFoundException e) {
                //TODO: use um sistema de log apropriado.
                e.printStackTrace();
            } catch (SQLException e) {
                //TODO: use um sistema de log apropriado.
                e.printStackTrace();
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
}
