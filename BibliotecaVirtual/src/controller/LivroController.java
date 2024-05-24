package controller;

import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import java.util.Optional;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import model.dao.LivroDAO;
import model.livros.Livro;

public class LivroController{

    private LivroDAO livro;
    
    public LivroController() {
        this.livro = new LivroDAO();
    }

    public List<Livro> listar() {
        return livro.listarItens();
    }

    public Optional<Livro> buscarId(Integer id) {
        return livro.buscarId(id);
    }

    public void atualizaView(String email) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void carregaLirosDisponiveis(JTable table){
        List<Livro> livros = listar();
        String[] colunas = {"#", "id", "Título", "Autor", "<html>Quant.<br>Exemplares</html>"};

        DefaultTableModel modeloTabela = new DefaultTableModel(colunas, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 0) {
                    return Boolean.class;
                }
                return String.class;
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 0;
            }
        };

        for (Livro livro : livros) {
            Object[] linha = new Object[5];
            linha[0] = false;
            linha[1] = livro.getIdLivro();
            linha[2] = livro.getTitulo();
            linha[3] = livro.getAutor();
            linha[4] = livro.getQntExemplares();
            modeloTabela.addRow(linha);
        }

        table.setModel(modeloTabela);

        // Ajustar largura das colunas
        table.getColumnModel().getColumn(0).setMaxWidth(30); // Largura da coluna de checkbox
        table.getColumnModel().getColumn(1).setMaxWidth(30); // Largura da coluna de título
        table.getColumnModel().getColumn(2).setPreferredWidth(200); // Largura da coluna de título
        table.getColumnModel().getColumn(3).setPreferredWidth(100); // Largura da coluna de autor
        table.getColumnModel().getColumn(4).setPreferredWidth(50); // Largura da coluna de quant. exemplares

        // Definir altura do cabeçalho
        JTableHeader header = table.getTableHeader();
        header.setPreferredSize(new Dimension(header.getWidth(), 40)); // Ajuste a altura conforme necessário
        header.setFont(header.getFont().deriveFont(Font.BOLD)); // Definir fonte em negrito para o cabeçalho
    }
    
    
}