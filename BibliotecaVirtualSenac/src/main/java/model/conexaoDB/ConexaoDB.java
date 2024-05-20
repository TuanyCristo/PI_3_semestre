package model;
import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoDB {
    // Informações para conexão com o banco de dados
    private static final String URL = "jdbc:mysql://localhost:3306/nome_do_banco";
    private static final String USUARIO = "seu_usuario";
    private static final String SENHA = "sua_senha";

    // Método para obter uma conexão com o banco de dados
    public static Connection obterConexao() throws SQLException {
        Connection conexao = null;

        try {
            // Registrar o driver JDBC (opcional em versões recentes do JDBC)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Estabelecer conexão com o banco de dados
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver MySQL não encontrado.");
            e.printStackTrace();
        }

        return conexao;
    }

}
