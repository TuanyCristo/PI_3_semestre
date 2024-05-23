package controller;

import java.util.List;
import java.util.Optional;
import model.dao.UsuarioDAO;
import model.user.Usuario;
import view.TelaAdmin;
import view.TelaLogin;

public class UsuarioController implements Controller<Usuario, Integer>{
    private TelaLogin view;
    private TelaAdmin viewAdmin;
    private UsuarioDAO user;
    
    public UsuarioController(){
        this.user = new UsuarioDAO();
    }

    public UsuarioController(TelaLogin view, TelaAdmin viewAdmin, UsuarioDAO user) {
        this.view = view;
        this.viewAdmin = viewAdmin;
        this.user = user;
    }

    @Override
    public boolean adicionar(Usuario objeto) {
        return user.inserirItem(objeto);
    }

    @Override
    public boolean alterar(int id, Usuario objeto) {
        return user.alterarItem(id, objeto);
    }

    @Override
    public List<Usuario> listar() {
        return user.listarItens();
    }

    @Override
    public boolean deletar(Integer id) {
        return user.deletarItem(id);
    }

    @Override
    public Optional<Usuario> buscarId(Integer id) {
        return user.buscarId(id);
    }
    
    public boolean login(String email, String senha){
        return user.loginEmail(email, senha);
    }
    
    @Override
    public void atualizaView(){
        
    }
    
    public Usuario criarUsuario(String nome, String email, String senha, String comparaSenha) throws Exception{
                     
            if(senha.equals(comparaSenha)){
                Usuario u = new Usuario();
                u.setNome(nome);
                u.setEmailInstitucional(email);
                u.setSenha(senha);
                return u;
            } else {
                throw new Exception("Senha incorreta");
            }
             
    }
    
    public boolean validaEmail(String email){
        return email.contains("@senacsp.edu.br");
    }

    public boolean verificaSenha(String senha, String confirmaSenha){
        return senha.equals(confirmaSenha);
    }
    

    public boolean validaSenha(String senhaDigitada){
        if(senhaDigitada.length() == 8){
            boolean maiuscula = false;
            boolean minuscula = false;
            boolean numero = false;
            boolean simbolo = false;

            for (int i = 0; i < senhaDigitada.length(); i++) {
                char caractere = senhaDigitada.charAt(i);
                if(Character.isUpperCase(caractere)){
                    maiuscula = true;
                } else if(Character.isLowerCase(caractere)){
                    minuscula = true;
                } else if(Character.isDigit(caractere)){
                    numero = true;                       
                } else {
                    simbolo = true;
                }     
            }
            return maiuscula && minuscula && numero && simbolo;
        } else {
            return false;
        }
    }
    
    
}