package model;

import model.user.Usuario;

public class Login {
    private Usuario user;

    public Login(Usuario user) {
        this.user = user;
    }

    public boolean fazerLogin(String email, String senha){
        if(user != null && user.getEmail().equals(email) && user.getSenha().equals(senha)) return true;
        return false;
    }
    
}
