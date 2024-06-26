package controller;

import java.util.List;
import java.util.Optional;
import model.dao.UsuarioDAO;
import model.user.Usuario;
import view.TelaAluno;
import view.TelaLogin;

public class UsuarioController{
    private TelaLogin view;
    private UsuarioDAO user;
    private TelaAluno telaAluno;
    
    public UsuarioController(){
        this.user = new UsuarioDAO();
    }

    public boolean adicionar(Usuario objeto) {
        
        return user.inserirItem(objeto);
    }

    public boolean alterar(int id, Usuario objeto) {
        return user.alterarItem(id, objeto);
    }

    public List<Usuario> listar() {
        return user.listarItens();
    }

    public boolean deletar(Integer id) {
        return user.deletarItem(id);
    }

    public Optional<Usuario> buscarId(Integer id) {
        return user.buscarId(id);
    }
    
    public Usuario buscarEmail(String email){
        return user.buscarEmail(email);
    }
    
    public boolean login(String email, String senha){
        if(user.loginEmail(email, senha)){
            Usuario u = buscarEmail(email);
            telaAluno = new TelaAluno(u);
            telaAluno.setVisible(true);
            telaAluno.getNomeJLabel().setText(u.getNome());
            return true;
            
        }
        return false;
    }
      
    
    public void atualizaView(String email){
            Usuario u = buscarEmail(email);
            telaAluno = new TelaAluno(u);
            telaAluno.setVisible(true);
            telaAluno.getNomeJLabel().setText(u.getNome());
              
         
    }
    
    public Usuario criarUsuario(String nome, String email, String senha, String comparaSenha){
                     
            if(senha.equals(comparaSenha)){
                Usuario u = new Usuario();
                u.setNome(nome);
                u.setEmailInstitucional(email);
                u.setSenha(senha);
                return u;
            } else {
               return null;
            }
             
    }
    
    public Usuario criarUsuario(String nome, String email, String senha){
        Usuario u = new Usuario();
        u.setNome(nome);
        u.setEmailInstitucional(email);
        u.setSenha(senha);
        return u;
             
    }
    
        public Usuario criarUsuario(String nome, String email){
        Usuario u = new Usuario();
        u.setNome(nome);
        u.setEmailInstitucional(email);
        return u;
             
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
    public boolean alterarSenha(int id, String senha, String senha2){
         if (!verificaSenha(senha, senha2)) {
            return false;
        }
          if (!validaSenha(senha2)) {
            return false;
        }
          Optional<Usuario> optionalUsuario = buscarId(id);
        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            // Altera a senha do usuário
            usuario.setSenha(senha);
            // Atualiza o usuário no banco de dados
            return alterar(id, usuario);
        }
        return false;
    }
   
}
    