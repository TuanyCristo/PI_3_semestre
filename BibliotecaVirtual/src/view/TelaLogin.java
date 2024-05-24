
package view;

import controller.UsuarioController;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author tcris
 */
public class TelaLogin extends javax.swing.JFrame {

    /**
     * Creates new form teste
     */
    
    private final UsuarioController controller;
    
    public TelaLogin() {
        initComponents();      
    
        this.controller = new UsuarioController();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        cadastro = new javax.swing.JButton();
        entrar = new javax.swing.JButton();
        emailText = new javax.swing.JTextField();
        senhajPass = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cadastro.setContentAreaFilled(false);
        cadastro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastroActionPerformed(evt);
            }
        });
        getContentPane().add(cadastro, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 270, 60, 10));

        entrar.setContentAreaFilled(false);
        entrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrarActionPerformed(evt);
            }
        });
        getContentPane().add(entrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 80, 30));
        getContentPane().add(emailText, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 300, -1));
        getContentPane().add(senhajPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 300, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/Login (1).png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void entrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrarActionPerformed
        String email = getEmailText().getText().toLowerCase();
        String senha = String.valueOf(senhajPass.getPassword()) ;
        
        if(controller.validaEmail(email)){
            if(controller.login(email, senha)){
                dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos");
            }
        }else{
            JOptionPane.showMessageDialog(null, "O email deve ser institucional");
        }
        
    }//GEN-LAST:event_entrarActionPerformed

    private void cadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastroActionPerformed
        TelaCadastro tela = new TelaCadastro();
        tela.setVisible(true);
    }//GEN-LAST:event_cadastroActionPerformed

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
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadastro;
    private javax.swing.JTextField emailText;
    private javax.swing.JButton entrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JPasswordField senhajPass;
    // End of variables declaration//GEN-END:variables

    public JTextField getEmailText() {
        return emailText;
    }

    public void setEmailText(JTextField emailText) {
        this.emailText = emailText;
    }

    public JPasswordField getSenhajPass() {
        return senhajPass;
    }

    public void setSenhajPass(JPasswordField senhajPass) {
        this.senhajPass = senhajPass;
    }


}
