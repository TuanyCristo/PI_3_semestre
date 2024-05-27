/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.Dimension;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import model.dao.ReservaDAO;
import model.reserva.Reserva;
import model.user.Usuario;

/**
 *
 * @author tcris
 */
public class ReservaController{
    
    private ReservaDAO dao;
    private LivroController livroController;
    private Usuario usuario;
    private Reserva res;
    
    public ReservaController() {
        this.dao = new ReservaDAO();
        this.livroController = new LivroController();
    }
    
        public ReservaController(int id) {
        this.dao = new ReservaDAO();
        this.livroController = new LivroController();
        this.usuario = new Usuario();
        this.res = new Reserva();
        res.setId(id);
        
    }
    
    public boolean fazerReserva(int idUser, List<Integer> idLivros) {
        try {
            Reserva novaReserva = new Reserva(idUser);
            int idReserva = dao.retornaReserva(novaReserva);

            if (idReserva != -1) { 
                for (int idLivro : idLivros) {
                    if (!dao.associarLivroReserva(idReserva, idLivro)) {
                        dao.cancelarReserva(idReserva);
                        return true;
                    }
                }
            } else {
                return false; 
            }
        } catch (Exception e) {
            return false; 
        }
        return true;
    }
    
    public void carregaReservas(JTable table, int idUser){
        List<Reserva> reservas = dao.listarItens(idUser);
        String[] colunas = {"#", "Id", "<html>Data <br>Reserva</html>", "<html>Data <br>Devolução</html>", "Quantidade"};

        DefaultTableModel modeloTabela = new DefaultTableModel(colunas, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 0) {
                    return Boolean.class;
                }
                return Object.class;
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 0;
            }
        };

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        for (Reserva reserva : reservas) {
            Object[] linha = new Object[5];
            linha[0] = false; // Checkbox
            linha[1] = reserva.getId(); // Id da reserva
            linha[2] = dateFormat.format(reserva.getDataReserva()); // Data de reserva formatada
            linha[3] = dateFormat.format(reserva.getDataDevolucao()); // Data de devolução formatada
            linha[4] = reserva.getQntLivros(); // Quantidade de livros

            modeloTabela.addRow(linha);
        }

        table.setModel(modeloTabela);

        // Ajustar largura das colunas
        table.getColumnModel().getColumn(0).setMaxWidth(20); // Largura da coluna de checkbox
        table.getColumnModel().getColumn(1).setMaxWidth(30); // Largura da coluna de id
        table.getColumnModel().getColumn(2).setPreferredWidth(100); // Largura da coluna de data de reserva
        table.getColumnModel().getColumn(3).setPreferredWidth(100); // Largura da coluna de data de devolução
        table.getColumnModel().getColumn(4).setPreferredWidth(60); // Quantidade de livros

        // Definir altura do cabeçalho
        JTableHeader header = table.getTableHeader();
        header.setPreferredSize(new Dimension(header.getWidth(), 40)); // Ajuste a altura conforme necessário
        header.setFont(header.getFont().deriveFont(Font.BOLD)); // Definir fonte em negrito para o cabeçalho
    }

    
    public List<Reserva> listar(int id) {
        dao.listarItens(id);
        return null;
    }
    
    public boolean devolucao(int idReserva){
        return dao.deletarItem(idReserva);
    }

}
