
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
import java.util.ArrayList;
import model.livros.Livro;

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

    public List<Reserva> listarItens(int idUser) {
        List<Reserva> reservas = new ArrayList<>();
        Conexao conexao = new Conexao();
        con = conexao.criaConexao();

    if (con == null) {
        System.out.println("Falha ao estabelecer conexão com o banco de dados.");
        return reservas;
    }

    String queryReservas = "SELECT r.id_reserva, r.data_reserva, COUNT(lis.id_livro) AS QTD_LIVRO " +
                           "FROM reservas r " +
                           "INNER JOIN listareserva lis ON lis.id_reserva = r.id_reserva " +
                           "WHERE r.id_usuario = ? " +
                           "GROUP BY r.id_reserva, r.data_reserva";

    try (PreparedStatement pst = con.prepareStatement(queryReservas)) {
            pst.setInt(1, idUser);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int reservaId = rs.getInt("id_reserva");
                java.sql.Date dataReserva = rs.getDate("data_reserva");
                int qtdLivros = rs.getInt("QTD_LIVRO");

                // Calcular data de devolução (10 dias após a data de reserva)
                java.util.Date dataDevolucao = new java.util.Date(dataReserva.getTime() + (10L * 24 * 60 * 60 * 1000));

                Reserva reserva = new Reserva();
                reserva.setId(reservaId);
                reserva.setDataReserva(new java.util.Date(dataReserva.getTime()));
                reserva.setDataDevolucao(dataDevolucao);
                reserva.setQntLivros(qtdLivros);

                reservas.add(reserva);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar reservas: " + e.getMessage());
        } finally {
            conexao.fechaConexao();
        }

        return reservas;
    }

    @Override
    public boolean deletarItem(Integer id) {
        Conexao conexao = new Conexao();
    con = conexao.criaConexao();

    if (con == null) {
        System.out.println("Falha ao estabelecer conexão com o banco de dados.");
        return false;
    }

    String query = "DELETE FROM reservas WHERE id_reserva = ?";

    try (PreparedStatement pst = con.prepareStatement(query)) {
        pst.setInt(1, id);

        int linhasModificadas = pst.executeUpdate();

        if (linhasModificadas == 0) {
            throw new SQLException("Falha ao deletar reserva. Nenhuma linha modificada.");
        }

        return true; // Deleção bem-sucedida
    } catch (SQLException e) {
        System.out.println("Erro ao deletar reserva: " + e.getMessage());
    } finally {
        conexao.fechaConexao();
    }

    return false;
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

    @Override
    public List<Reserva> listarItens() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
