package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.conexao.Conexao;
import model.user.Usuario;

public class UsuarioDAO{

    public void cadastrarUsuario(Usuario u){
        String query = "INSERT INTO PESSOAS (nome, email, senha, usuario) VALUES (?, ?, ? ,?)";
        PreparedStatement ps = null;
        try {
            ps = Conexao.fazerConexao().prepareStatement(query);
            ps.setString(1, u.getNome());
            ps.setString(2, u.getEmailInstitucional());
            ps.setString(3, u.getSenha());
            ps.setString(4, "usuario");

            ps.execute();
            ps.close();
        
        
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
   
    }

    public Usuario buscarEmail(String email){
        //buscar na tabela pessoa filtrando pelo email
        String query = "SELECT * FROM pessoas WHERE email = ?";
        PreparedStatement ps = null;
        //variavel para guardar o resultado da busca
        ResultSet rs = null;
        //usuario para armazenar o resultado
        Usuario u = null;
        try {
            ps = Conexao.fazerConexao().prepareStatement(query);
            ps.setString(1, email);

            rs = ps.executeQuery();

            if(rs.next()){
                //cria um novo usuario
                u = new Usuario();
                //seta o email adquirido na tabela ao usuario buscando pelo noma da coluna
                u.setIdUsuario(rs.getInt("id"));
                u.setNome(rs.getString("nome"));
                u.setEmailInstitucional(rs.getString("email"));
                u.setSenha(rs.getString("senha"));
            }

            ps.close();
        } catch (SQLException e) {
            System.out.println("Usuário não encontrato");
        }
        return u;
    }
}