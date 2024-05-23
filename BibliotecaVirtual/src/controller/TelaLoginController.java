package controller;

import javax.swing.JOptionPane;
import model.dao.AdminDAO;
import model.dao.UsuarioDAO;
import view.TelaAdmin;
import view.TelaAluno;
import view.TelaLogin;

public class TelaLoginController {
    private final TelaLogin view;
    private final UsuarioDAO usuarioDAO;
    private final AdminDAO adminDAO;

    public TelaLoginController(TelaLogin view){
        this.view = view;
        this.usuarioDAO = new UsuarioDAO();
        this.adminDAO = new AdminDAO();
    }

    public void login(){
        //Captura o email da view
        String email = view.getEmail().getText();
        String senha = view.getSenha().getText();
        
        if(usuarioDAO.loginEmail(email, senha)){
            JOptionPane.showMessageDialog(null, "Login efetuado");
            TelaAluno telaAluno = new TelaAluno();
            telaAluno.setVisible(true);
            view.dispose();
        } else if(adminDAO.loginEmail(email,senha)){
            JOptionPane.showMessageDialog(null, "Login efetuado");
            TelaAdmin telaAdmin = new TelaAdmin();
            telaAdmin.setVisible(true);
            view.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Usuário ou senha incorreto");
        }
        
        
        
        
    }

}
