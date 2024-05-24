
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import model.conexao.Conexao;
import model.reserva.Reserva;
import java.sql.Statement;

public class ReservaDAO implements InterfaceDAO<Reserva, Integer>{
    private Connection con;
    
    
    public int inserirReserva(int idUser) {
        Conexao conect = new Conexao();
        con = conect.criaConexao();

        if (con == null) {
            System.out.println("Falha ao estabelecer conexão com o banco de dados.");
            return -1;
        }

        String query = "INSERT INTO reservas (id_usuario, data_reserva) VALUES (?, ?)";

        try (PreparedStatement pst = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            pst.setInt(1, idUser);
            pst.setDate(2, new java.sql.Date(System.currentTimeMillis()));

            int linhasModificadas = pst.executeUpdate();

            if (linhasModificadas == 0) {
                throw new Exception("Falha ao adicionar reserva");
            }

            ResultSet rs = pst.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Erro na inserção da reserva: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro na inserção da reserva: " + e.getMessage());
        }

        conect.fechaConexao();
        return -1;
    }
    
    public boolean associarLivroReserva(int idReserva, int idLivro) {
        Conexao conect = new Conexao();
        con = conect.criaConexao();

        if (con == null) {
            System.out.println("Falha ao estabelecer conexão com o banco de dados.");
            return false;
        }
        
        String query = "INSERT INTO listaReserva (id_reserva, id_livro) VALUES (?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, idReserva);
            stmt.setInt(2, idLivro);

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao associar livro à reserva: " + e.getMessage());
        }
        return false;
    }



    @Override
    public boolean alterarItem(int id, Reserva objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Reserva> listarItens() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean deletarItem(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Optional<Reserva> buscarId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    

    public boolean inserirReserva(int idUser, int idLivro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean inserirItem(Reserva objeto) {
        Conexao conexao = new Conexao();
        con = conexao.criaConexao();

        if (con == null) {
            System.out.println("Falha ao estabelecer conexão com o banco de dados.");
            return false;
        }

        String query = "INSERT INTO reservas (id_usuario, data_reserva) VALUES (?, ?)";

        try (PreparedStatement pst = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pst.setInt(1, inserirReserva(objeto.getUser().getIdUsuario()));
            pst.setDate(2, new java.sql.Date(objeto.getDataReserva().getTime()));

            int linhasModificadas = pst.executeUpdate();

            if (linhasModificadas == 0) {
                throw new SQLException("Falha ao adicionar reserva. Nenhuma linha modificada.");
            }

            ResultSet rs = pst.getGeneratedKeys();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Erro na inserção da reserva: " + e.getMessage());
        } 
        conexao.fechaConexao();
        return false;
    }

    public void cancelarReserva(int idReserva) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public int retornaReserva(Reserva reserva) {
        Conexao conexao = new Conexao();
        con = conexao.criaConexao();

        if (con == null) {
            System.out.println("Falha ao estabelecer conexão com o banco de dados.");
            return -1;
        }

        String query = "INSERT INTO reservas (id_usuario, data_reserva) VALUES (?, CURRENT_DATE)";

        try (PreparedStatement pst = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pst.setInt(1, reserva.getId());

            int linhasModificadas = pst.executeUpdate();

            if (linhasModificadas == 0) {
                throw new SQLException("Falha ao adicionar reserva. Nenhuma linha modificada.");
            }

            ResultSet rs = pst.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1); // Retorna o ID da reserva inserida
            }
        } catch (SQLException e) {
            System.out.println("Erro na inserção da reserva: " + e.getMessage());
        } finally {
            conexao.fechaConexao();
        }

    return -1;
}

    
}
