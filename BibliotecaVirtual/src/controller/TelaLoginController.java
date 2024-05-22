package controller;

import model.dao.UsuarioDAO;
import model.user.Usuario;
import view.TelaLogin;

public class TelaLoginController {
    private final TelaLogin view;
    private final UsuarioDAO usuarioDAO;

    public TelaLoginController(TelaLogin view){
        this.view = view;
        this.usuarioDAO = new UsuarioDAO();
    }

    public boolean login(){
        //Captura o email e a senha da view
        String email = view.getEmail().getText();
        String senha = view.getSenha().getText();
        Usuario u = usuarioDAO.buscarEmail(email);
        if(u != null){
            if (senha.equals(u.getSenha())) {
                return true;

            }
        } else {
            System.out.println("Usuario ou senha inválidos");
            
        }
        return false;   
        
    }

}
