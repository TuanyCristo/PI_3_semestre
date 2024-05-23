package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import model.conexao.Conexao;
import model.user.Usuario;
import org.mindrot.jbcrypt.BCrypt;

public class UsuarioDAO implements InterfaceDAO<Usuario, Integer>{
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
                    
                    String senhaHash = rs.getString("senha");
                    
                    boolean senhaVerificada = BCrypt.checkpw(senha, senhaHash);
                    if(!senhaVerificada){
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
        return true;
    }
    
    private Usuario retorna(ResultSet rs) throws SQLException {
    return new Usuario(
                    rs.getInt("id_user"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("senha"),
                    rs.getString("tipo")
            );
    }

    @Override
    public boolean inserirItem(Usuario objeto) {
        Conexao conect = new Conexao();
        con = conect.criaConexao();
        
        if (con == null) {
            System.out.println("Falha ao estabelecer conexão com o banco de dados.");
            return false;
        }
        
        String query = "INSERT INTO usuarios (nome, email, senha, tipo)"
                + " VALUES (?, ?, ?, ?)";
        
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, objeto.getNome());
            stmt.setString(2, objeto.getEmailInstitucional());
            stmt.setString(3, objeto.getSenha());
            stmt.setString(4, objeto.getNivelAcesso());
            
            int linhasModificadas = stmt.executeUpdate();
            if(linhasModificadas > 0) return true;
        } catch(SQLException e) {
            System.out.println("Erro na query");
            System.out.println("Erro: " + e.getMessage());
        }
        conect.fechaConexao();
        return false;
    }

    @Override
    public boolean alterarItem(int id, Usuario objeto) {
        Conexao conect = new Conexao();
        con = conect.criaConexao();
        
        if (con == null) {
            System.out.println("Falha ao estabelecer conexão com o banco de dados.");
            return false;
        }
        
        String query = "UPDATE usuarios SET nome= ?, email= ?,"
                + "senha= ? WHERE id_livro= ?";
        
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, objeto.getNome());
            stmt.setString(2, objeto.getEmailInstitucional());
            stmt.setString(3, objeto.getSenha());
            stmt.setInt(4, objeto.getIdUsuario());
            
            int linhasModificadas = stmt.executeUpdate();
            if(linhasModificadas > 0) return true;
            
        } catch(SQLException e) {
            System.out.println("Erro na query");
            System.out.println("Erro: " + e.getMessage());
        }
        conect.fechaConexao();
        return false;
    }

    @Override
    public List<Usuario> listarItens() {
        Conexao conect = new Conexao();
        con = conect.criaConexao();
        
        if (con == null) {
            System.out.println("Falha ao estabelecer conexão com o banco de dados.");
            return null;
        }
        
        String query = "SELECT * FROM usuarios";
        List<Usuario> lista = new ArrayList<>();
        
        try(PreparedStatement stmt = con.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Usuario user = new Usuario();
                user.setIdUsuario(rs.getInt("id_user"));
                user.setNome(rs.getString("nome"));
                user.setEmailInstitucional(rs.getString("email"));

                lista.add(user);
            }
            return lista;
            
        } catch(SQLException e) {
        System.out.println("Erro na query");
        System.out.println("Erro: " + e.getMessage());
        conect.fechaConexao();
        
        
        }
        return null;
    }

    @Override
    public boolean deletarItem(Integer id) {
        Conexao conect = new Conexao();
        con = conect.criaConexao();
        
        if (con == null) {
            System.out.println("Falha ao estabelecer conexão com o banco de dados.");
            return false;
        }
        
        String query = "DELETE FROM usuarios WHERE id_user = ?;";
        
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            
            stmt.setInt(1, id);
            
            int linhasModificadas = stmt.executeUpdate();
            
            if(linhasModificadas > 0) return true;
            
        } catch(SQLException e) {
            System.out.println("Erro na query");
            System.out.println("Erro: " + e.getMessage());
        }
        conect.fechaConexao();
        return false;

    }

    @Override
    public Optional<Usuario> buscarId(Integer id) {
        Conexao conect = new Conexao();
            con = conect.criaConexao();

            if (con == null) {
                System.out.println("Falha ao estabelecer conexão com o banco de dados.");
                return null;
            }

            String query = "SELECT * FROM usuarios WHERE id_user = ?";

            try (PreparedStatement stmt = con.prepareStatement(query)) {
                stmt.setInt(1, id);

                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    Usuario user = new Usuario(
                    rs.getInt("id_user"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("senha"),
                    rs.getString("tipo")
                    );
                    return Optional.of(user);
                } else {
                    return null;
                }
            } catch (SQLException e) {
            System.out.println("Erro na query");
            System.out.println("Erro: " + e.getMessage());
            conect.fechaConexao();
            return null;
        }
    }

    public Usuario buscarEmail(String email) {
        Conexao conect = new Conexao();
        con = conect.criaConexao();

        if (con == null) {
            System.out.println("Falha ao estabelecer conexão com o banco de dados.");
            return null;
        }

        String query = "SELECT * FROM usuarios WHERE email = ?";

        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, email);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
               return new Usuario(
                rs.getInt("id_user"),
                rs.getString("nome"),
                rs.getString("email"),
                rs.getString("senha"),
                rs.getString("tipo")
                );
            } else {
                return null;
            }
        } catch (SQLException e) {
        System.out.println("Erro na query");
        System.out.println("Erro: " + e.getMessage());
        conect.fechaConexao();
        return null;
        }
    
    
    }
}