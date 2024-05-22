package model.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String url = "jdbc:mysql://localhost:3306/biblioteca";
    private static final String user = "root";
    private static final String password = "";
    
    private static Connection conexao;

    public static Connection fazerConexao(){
            try {
                if(conexao == null){
                    conexao = DriverManager.getConnection(url, user, password);
                    return conexao;    
                }else{
                    return conexao;
                }
            } catch (SQLException e) {
                System.out.println("Conexão falhou");
                return null;
            }
    } 
}
