
package model.dao;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;
import model.conexao.Conexao;
import model.livros.Livro;

public class LivrosDAO implements InterfaceDAO<Livro, Integer>{

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
    }

    @Override
    public boolean alterarItem(Livro objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Livro> listarItens() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean deletarItem(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Optional<Livro> buscarId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
    

}
