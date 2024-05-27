/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.LivroController;
import controller.ReservaController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.user.Usuario;

/**
 *
 * @author isata
 */
public class TelaReservas extends javax.swing.JFrame {
    
    private LivroController controller;
    private Usuario usuario;
    private ReservaController  conReserva;

    /**
     * Creates new form TelaReservas
     */
    public TelaReservas() {
        initComponents();
    }
    
    public TelaReservas(Usuario user) {
        initComponents();
        this.controller = new LivroController();
        this.usuario = user;
        this.conReserva = new ReservaController();
        nomeJLabel.setText(user.getNome());
        carregaTabela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        configConta = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaReserva = new javax.swing.JTable();
        livrosDisponiveis = new javax.swing.JButton();
        nomeJLabel = new javax.swing.JLabel();
        voltar = new javax.swing.JButton();
        reservas = new javax.swing.JButton();
        sair = new javax.swing.JButton();
        devolucao = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        configConta.setContentAreaFilled(false);
        configConta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        configConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configContaActionPerformed(evt);
            }
        });
        getContentPane().add(configConta, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 190, 190, 20));

        tabelaReserva.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Data de reserva", "Data de devolução", "Livros", "Qnt livros"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaReserva);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 510, 240));

        livrosDisponiveis.setContentAreaFilled(false);
        livrosDisponiveis.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        livrosDisponiveis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                livrosDisponiveisActionPerformed(evt);
            }
        });
        getContentPane().add(livrosDisponiveis, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 270, 150, 90));

        nomeJLabel.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        getContentPane().add(nomeJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 300, 30));

        voltar.setContentAreaFilled(false);
        voltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
            }
        });
        getContentPane().add(voltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 620, 150, 40));

        reservas.setContentAreaFilled(false);
        reservas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reservasActionPerformed(evt);
            }
        });
        getContentPane().add(reservas, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 160, 100));

        sair.setBackground(new java.awt.Color(255, 204, 153));
        sair.setForeground(new java.awt.Color(255, 255, 255));
        sair.setText("Sair");
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });
        getContentPane().add(sair, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 210, 60, 20));

        devolucao.setContentAreaFilled(false);
        devolucao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        devolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                devolucaoActionPerformed(evt);
            }
        });
        getContentPane().add(devolucao, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 560, 150, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/Tela Aluno - tabela - reservas.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void devolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_devolucaoActionPerformed
DefaultTableModel model = (DefaultTableModel) tabelaReserva.getModel();
    int numRows = model.getRowCount();
    List<Integer> reservasParaDevolucao = new ArrayList<>();

    for (int i = 0; i < numRows; i++) {
        Boolean selecionado = (Boolean) model.getValueAt(i, 0);

        if (Boolean.TRUE.equals(selecionado)) {
            Integer idReserva = (Integer) model.getValueAt(i, 1);
            reservasParaDevolucao.add(idReserva);
        }
    }

    if (reservasParaDevolucao.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Nenhuma reserva selecionada para devolução.");
    } else {
        for (Integer id : reservasParaDevolucao) {
            conReserva.devolucao(id);
        }
        JOptionPane.showMessageDialog(this, "Devolução realizada com sucesso.");
        carregaTabela(); // Recarregar a tabela após a devolução
    }        
        
    }//GEN-LAST:event_devolucaoActionPerformed

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        TelaAluno telaAluno = new TelaAluno();
        telaAluno.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_voltarActionPerformed

    private void reservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reservasActionPerformed
        DefaultTableModel model = (DefaultTableModel) tabelaReserva.getModel();
        int numRows = model.getRowCount();
        List<Integer> reservaSelecionada = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            Boolean verCheckbox = (Boolean) model.getValueAt(i, 0);

            if (verCheckbox) {
                
                Integer idReserva = (Integer) model.getValueAt(i, 1);
                reservaSelecionada.add(idReserva);
            }
        }
    }//GEN-LAST:event_reservasActionPerformed

    private void livrosDisponiveisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_livrosDisponiveisActionPerformed
        TelaDisponiveis telaDisponiveis = new TelaDisponiveis(usuario);
        telaDisponiveis.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_livrosDisponiveisActionPerformed

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_sairActionPerformed

    private void configContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configContaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_configContaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaReservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaReservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaReservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaReservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaReservas telaReservas = new TelaReservas();
                telaReservas.setSize(800, 800);
                telaReservas.setVisible(true);
            }
        });
    }
    public JLabel getNomeJLabel() {
        return nomeJLabel;
    }

    public void setNomeJLabel(JLabel nomeJLabel) {
        this.nomeJLabel = nomeJLabel;
    }
    
    private void carregaTabela(){
        conReserva.carregaReservas(tabelaReserva, usuario.getIdUsuario());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton configConta;
    private javax.swing.JButton devolucao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton livrosDisponiveis;
    private javax.swing.JLabel nomeJLabel;
    private javax.swing.JButton reservas;
    private javax.swing.JButton sair;
    private javax.swing.JTable tabelaReserva;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables
}
