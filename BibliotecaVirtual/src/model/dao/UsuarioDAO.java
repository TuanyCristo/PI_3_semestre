package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.conexao.Conexao;
import model.user.Usuario;

public class UsuarioDAO{
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
                    String tipo = rs.getString("tipo");
                    if(tipo.equals("regular")){
                        Usuario u = retornaUsuario(rs);
                        if(u.confirmaSenha(u.getSenha(), senha))
                        return true;
                    } else {
                        return false;
                    }
                }
            } catch(SQLException e){
                System.out.println("E-mail não encontrado na base de dados");
            }
        } catch(SQLException e) {
            System.out.println("Erro na query");
            System.out.println("Erro: " + e.getMessage());
        }
        conect.fechaConexao();
        return false;
    }
    
    private Usuario retornaUsuario(ResultSet rs) throws SQLException {
    return new Usuario(
                    rs.getInt("id_user"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("senha"),
                    rs.getString("tipo")
            );
    }
    
    public boolean insereUsuario(Usuario u){
        Conexao conect = new Conexao();
        con = conect.criaConexao();
        
        if (con == null) {
            System.out.println("Falha ao estabelecer conexão com o banco de dados.");
            return false;
        }
        
        String query = "INSERT INTO usuarios (nome, email, senha, tipo)"
                + " VALUES (?,?,?,'regular');";
        
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, email);
            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    String tipo = rs.getString("tipo");
                    if(tipo.equals("regular")){
                        Usuario u = retornaUsuario(rs);
                        if(u.confirmaSenha(u.getSenha(), senha))
                        return true;
                    } else {
                        return false;
                    }
                }
            } catch(SQLException e){
                System.out.println("E-mail não encontrado na base de dados");
            }
        } catch(SQLException e) {
            System.out.println("Erro na query");
            System.out.println("Erro: " + e.getMessage());
        }
        conect.fechaConexao();
        return false;
    }
        
    
    
}