/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import javax.swing.JTextField;

/**
 *
 * @author steph
 */
public class Cadastro extends javax.swing.JFrame {

    /**
     * Creates new form Cadastro
     */
    public Cadastro() {
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

        senhaco = new javax.swing.JTextField();
        enterc = new javax.swing.JButton();
        emailc = new javax.swing.JTextField();
        senhac = new javax.swing.JTextField();
        nome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(senhaco, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 270, -1));

        enterc.setBackground(new java.awt.Color(255, 153, 0));
        enterc.setForeground(new java.awt.Color(255, 255, 255));
        enterc.setText("Cadastrar");
        enterc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entercActionPerformed(evt);
            }
        });
        getContentPane().add(enterc, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, -1, -1));

        emailc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailcActionPerformed(evt);
            }
        });
        getContentPane().add(emailc, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 270, -1));
        getContentPane().add(senhac, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 270, -1));

        nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeActionPerformed(evt);
            }
        });
        getContentPane().add(nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 270, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/Cadastro (1).png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 402, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeActionPerformed

    private void emailcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailcActionPerformed

    private void entercActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entercActionPerformed
        
    }//GEN-LAST:event_entercActionPerformed

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
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cadastro().setVisible(true);
            }
        });
    }

    public JTextField getEmailc() {
        return emailc;
    }

    public void setEmailc(JTextField emailc) {
        this.emailc = emailc;
    }

    public JTextField getNome() {
        return nome;
    }

    public void setNome(JTextField nome) {
        this.nome = nome;
    }

    public JTextField getSenhac() {
        return senhac;
    }

    public void setSenhac(JTextField senhac) {
        this.senhac = senhac;
    }

    public JTextField getSenhaco() {
        return senhaco;
    }

    public void setSenhaco(JTextField senhaco) {
        this.senhaco = senhaco;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField emailc;
    private javax.swing.JButton enterc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField nome;
    private javax.swing.JTextField senhac;
    private javax.swing.JTextField senhaco;
    // End of variables declaration//GEN-END:variables
}
