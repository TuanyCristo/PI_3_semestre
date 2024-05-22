package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.conexao.Conexao;
import model.user.Admin;

public class AdminDAO{
    private Connection con;
    
    public boolean loginEmail(String email, String senha){
        Conexao conect = new Conexao();
        con = conect.criaConexao();
        
        if (con == null) {
            System.out.println("Falha ao estabelecer conexão com o banco de dados.");
            return false;
        }
        
        String query = "SELECT * FROM usuarios WHERE  email = ?";
        
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, email);
            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    Admin a = retornaAdmin(rs);
                    if(a.confirmaSenha(a.getSenha(), senha))
                    return true;
                }
            } catch(SQLException e){
                System.out.println("E-mail não encontrado na base de dados");
            }
        } catch(SQLException e) {
            System.out.println("Erro na query");
            System.out.println("Erro: " + e.getMessage());
        }
        
        return false;
    }

    private Admin retornaAdmin(ResultSet rs) throws SQLException {
        return new Admin(
                    rs.getInt("id_user"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("senha"),
                    rs.getString("cargo"),
                    rs.getString("tipo")
                );
    }
    
}