/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.UsuarioController;
import javax.swing.JLabel;
import model.user.Usuario;
/**
 *
 * @author isata
 */
public class TelaAluno extends javax.swing.JFrame {
    private UsuarioController controller;
    private Usuario usuario;

    public TelaAluno(Usuario user) {
        initComponents();
        this.controller = new UsuarioController();
        this.usuario = user;
        
    }
    
    public TelaAluno() {
        initComponents();
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
        reservas = new javax.swing.JButton();
        disponivelBreve = new javax.swing.JButton();
        livrosDisponiveis = new javax.swing.JButton();
        nomeJLabel = new javax.swing.JLabel();
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
        getContentPane().add(configConta, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 150, 180, 20));

        reservas.setBackground(new java.awt.Color(51, 75, 210));
        reservas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        reservas.setForeground(new java.awt.Color(255, 255, 255));
        reservas.setContentAreaFilled(false);
        reservas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reservasActionPerformed(evt);
            }
        });
        getContentPane().add(reservas, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 160, 100));

        disponivelBreve.setBackground(new java.awt.Color(51, 75, 210));
        disponivelBreve.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        disponivelBreve.setForeground(new java.awt.Color(255, 255, 255));
        disponivelBreve.setContentAreaFilled(false);
        disponivelBreve.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        disponivelBreve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disponivelBreveActionPerformed(evt);
            }
        });
        getContentPane().add(disponivelBreve, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 270, 160, 100));

        livrosDisponiveis.setBackground(new java.awt.Color(255, 153, 51));
        livrosDisponiveis.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        livrosDisponiveis.setForeground(new java.awt.Color(255, 255, 255));
        livrosDisponiveis.setContentAreaFilled(false);
        livrosDisponiveis.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        livrosDisponiveis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                livrosDisponiveisActionPerformed(evt);
            }
        });
        getContentPane().add(livrosDisponiveis, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, 160, 100));

        nomeJLabel.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        getContentPane().add(nomeJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 300, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/Tela Aluno (2).png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void reservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reservasActionPerformed
        TelaReservas telaReservas = new TelaReservas();
        telaReservas.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_reservasActionPerformed

    private void livrosDisponiveisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_livrosDisponiveisActionPerformed
        TelaDisponiveis telaDisponiveis = new TelaDisponiveis();
        telaDisponiveis.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_livrosDisponiveisActionPerformed

    private void disponivelBreveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disponivelBreveActionPerformed
        TelaDisponiveisBreve telaDisponiveisBreve = new TelaDisponiveisBreve();
        telaDisponiveisBreve.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_disponivelBreveActionPerformed

    private void configContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configContaActionPerformed
        if(usuario != null){
            TelaConfigConta tela = new TelaConfigConta(usuario);
            tela.setVisible(true);
        } 
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
            java.util.logging.Logger.getLogger(TelaAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaAluno telaAluno = new TelaAluno();
                telaAluno.setSize(800, 600);
                telaAluno.setVisible(true);
            }
        });
    }

    public JLabel getNomeJLabel() {
        return nomeJLabel;
    }

    public void setNomeJLabel(JLabel nomeJLabel) {
        this.nomeJLabel = nomeJLabel;
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton configConta;
    private javax.swing.JButton disponivelBreve;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton livrosDisponiveis;
    private javax.swing.JLabel nomeJLabel;
    private javax.swing.JButton reservas;
    // End of variables declaration//GEN-END:variables
}
