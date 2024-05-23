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

    @Override
    public boolean inserirItem(Reserva objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public boolean inserirItem(Reserva objeto, int idLivro) {
        Conexao conect = new Conexao();
        con = conect.criaConexao();
        
        if (con == null) {
            System.out.println("Falha ao estabelecer conexão com o banco de dados.");
            return false;
        }
        
        String query = "INSERT INTO reservas (id_usuario, data_reserva)"
                + " VALUES (?, ?)";
        
        try(PreparedStatement pst = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
            
            pst.setInt(1, objeto.getUser().getIdUsuario());
            pst.setDate(2, objeto.getDataReserva());
            
            int linhasModificadas = pst.executeUpdate();
            
            if(linhasModificadas == 0){
                throw new Exception("Falha ao adicionar reserva");
            }
            
            ResultSet rs = pst.getGeneratedKeys();
            if(rs.next()){
                //gera um inteiro com o item da primeira posição do retorno da consulta que é o ID
                int idRserva = rs.getInt(1);
                                
                String query2 = "INSERT INTO listareserva (id_reserva, id_livro)"
                + " VALUES (?, ?)";
                      
            try(PreparedStatement stmt2 = con.prepareStatement(query2)){
                stmt2.setInt(1, idRserva);
                stmt2.setInt(2, idLivro);

                int linhasModificadas2 = stmt2.executeUpdate();
                
                if(linhasModificadas == 0){
                    throw new Exception("Falha ao adicionar reserva");
                }


            } catch(SQLException e) {
                System.out.println("Erro na query2");
                System.out.println("Erro: " + e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

                }
               

        } catch(SQLException e) {
            System.out.println("Erro na query 1");
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        
        
        conect.fechaConexao();
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
    
}
