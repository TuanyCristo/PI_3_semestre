
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import model.conexao.Conexao;
import model.livros.Livro;
import model.user.Usuario;

public class LivroDAO implements InterfaceDAO<Livro, Integer>{

    private Connection con;
    
    @Override
    public boolean inserirItem(Livro objeto) {
        Conexao conect = new Conexao();
        con = conect.criaConexao();
        
        if (con == null) {
            System.out.println("Falha ao estabelecer conexão com o banco de dados.");
            return false;
        }
        
        String query = "INSERT INTO livros (titulo, autor, quantExemplares) "
                + "VALUES (?,?,?)";
        
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, objeto.getTitulo());
            stmt.setString(2, objeto.getAutor());
            stmt.setInt(3, objeto.getQntExemplares());
            
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
    public boolean alterarItem(int id, Livro objeto) {
        Conexao conect = new Conexao();
        con = conect.criaConexao();
        
        if (con == null) {
            System.out.println("Falha ao estabelecer conexão com o banco de dados.");
            return false;
        }
        
        String query = "UPDATE livros SET titulo= ?, autor= ?,"
                + "quantExemplares= ? WHERE id_livro= ?";
        
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, objeto.getTitulo());
            stmt.setString(2, objeto.getAutor());
            stmt.setInt(3, objeto.getQntExemplares());
            stmt.setInt(4, id);
            
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
    public List<Livro> listarItens() {
        Conexao conect = new Conexao();
        con = conect.criaConexao();
        
        if (con == null) {
            System.out.println("Falha ao estabelecer conexão com o banco de dados.");
            return null;
        }
        
        String query = "SELECT * FROM livros";
        List<Livro> lista = new ArrayList<>();
        
        try(PreparedStatement stmt = con.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Livro livro = new Livro();
                livro.setIdLivro(rs.getInt("id_livro"));
                livro.setTitulo(rs.getString("titulo"));
                livro.setAutor(rs.getString("autor"));
                livro.setQntExemplares(rs.getInt("quantExemplares"));

                lista.add(livro);
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
        
        String query = "DELETE FROM livros WHERE id_livro = ?;";
        
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

    public int buscarTitulo(String titulo) {
        Conexao conect = new Conexao();
        con = conect.criaConexao();
        
        if (con == null) {
            System.out.println("Falha ao estabelecer conexão com o banco de dados.");
            return -1;
        }
        
        String query = "SELECT * FROM livros WHERE titulo ?";
        
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, titulo);
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                Livro livro = new Livro(
                    rs.getInt("id"),
                    rs.getString("titulo"),
                    rs.getString("autor"),
                    rs.getInt("quantExemplares")
                );
                return livro.getIdLivro();
            } else {
                return -1;
            }
        } catch (SQLException e) {
        System.out.println("Erro na query");
        System.out.println("Erro: " + e.getMessage());
        conect.fechaConexao();
        return -1;
        
        }       
    }
        @Override
        public Optional<Livro> buscarId(Integer id) {
            Conexao conect = new Conexao();
            con = conect.criaConexao();

            if (con == null) {
                System.out.println("Falha ao estabelecer conexão com o banco de dados.");
                return null;
            }

            String query = "SELECT * FROM livros WHERE id_livro = ?";

            try (PreparedStatement stmt = con.prepareStatement(query)) {
                stmt.setInt(1, id);

                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    Livro livro = new Livro(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getInt("quantExemplares")
                    );
                    return Optional.of(livro);
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
