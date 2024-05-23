package controller;

import java.util.List;
import java.util.Optional;
import model.dao.UsuarioDAO;
import model.user.Usuario;
import view.TelaLogin;

public class UsuarioController implements Controller<Usuario, Integer>{
    private TelaLogin view;
    private UsuarioDAO user;
    
    public UsuarioController(){
        this.user = new UsuarioDAO();
    }

    public UsuarioController(TelaLogin view, UsuarioDAO user) {
        this.view = view;
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
    
    
    
}