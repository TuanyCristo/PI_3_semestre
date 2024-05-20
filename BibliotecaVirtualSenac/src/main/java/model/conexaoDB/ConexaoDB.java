package model.conexaoDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoDB {
    private static final String URL = "jdbc:mysql://localhost:3306/seubanco";
    private static final String USER = "seuusuario";
    private static final String PASSWORD = "suasenha";

    public static Connection conectar() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Erro na conexão com o banco de dados.", e);
        }
    }   

}
