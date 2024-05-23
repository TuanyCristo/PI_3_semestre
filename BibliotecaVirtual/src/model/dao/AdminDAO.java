package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import model.conexao.Conexao;
import model.user.Admin;


public class AdminDAO implements InterfaceDAO<Admin, Integer>{
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
                    if(tipo.equals("admin")){
                        Admin a = retorna(rs);
                        if(a.confirmaSenha(a.getSenha(), senha))
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
        
        return false;
    }

    private Admin retorna(ResultSet rs) throws SQLException {
        return new Admin(
                    rs.getInt("id_user"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("senha"),
                    rs.getString("cargo"),
                    rs.getString("tipo")
                );
    }
    
    @Override
    public boolean inserirItem(Admin objeto) {
        Conexao conect = new Conexao();
        con = conect.criaConexao();
        
        if (con == null) {
            System.out.println("Falha ao estabelecer conexão com o banco de dados.");
            return false;
        }
        
        String query = "INSERT INTO usuarios (nome, email, senha, cargo, tipo)"
                + " VALUES (?, ?, ?, ?, ?)";
        
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, objeto.getNome());
            stmt.setString(0, objeto.getEmailInstitucional());
            stmt.setString(3, objeto.getSenha());
            stmt.setString(4, objeto.getCargo());
            stmt.setString(5, objeto.getNivelAcesso());
            
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
    public boolean alterarItem(int id, Admin objeto) {
        Conexao conect = new Conexao();
        con = conect.criaConexao();
        
        if (con == null) {
            System.out.println("Falha ao estabelecer conexão com o banco de dados.");
            return false;
        }
        
        String query = "UPDATE usuarios SET nome= ?, email= ?,"
                + "senha= ?, cargo= ? WHERE id_user= ?";
        
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, objeto.getNome());
            stmt.setString(2, objeto.getEmailInstitucional());
            stmt.setString(3, objeto.getSenha());
            stmt.setString(4, objeto.getCargo());
            stmt.setInt(5, objeto.getIdUsuario());
            
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
    public List<Admin> listarItens() {
        Conexao conect = new Conexao();
        con = conect.criaConexao();
        
        if (con == null) {
            System.out.println("Falha ao estabelecer conexão com o banco de dados.");
            return null;
        }
        
        String query = "SELECT * FROM usuarios";
        List<Admin> lista = new ArrayList<>();
        
        try(PreparedStatement stmt = con.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Admin user = new Admin();
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
    public Optional<Admin> buscarId(Integer id) {
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
                    Admin user = new Admin(
                    rs.getInt("id_user"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("senha"),
                    rs.getString("cargo"),
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
    
    
}