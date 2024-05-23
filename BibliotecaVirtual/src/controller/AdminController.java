package controller;

import java.util.List;
import java.util.Optional;
import model.dao.AdminDAO;
import model.user.Admin;
import view.TelaLogin;


public class AdminController implements Controller<Admin, Integer>{
    private TelaLogin view;
    private AdminDAO user;

    public AdminController() {
        this.user = new AdminDAO();
    }
    
    public AdminController(TelaLogin view, AdminDAO user) {
        this.view = view;
        this.user = new AdminDAO();
    }

    @Override
    public boolean adicionar(Admin objeto) {
        return user.inserirItem(objeto);
    }

    @Override
    public boolean alterar(int id, Admin objeto) {
        return user.alterarItem(id, objeto);
    }

    @Override
    public List<Admin> listar() {
        return user.listarItens();
    }

    @Override
    public boolean deletar(Integer id) {
        return user.deletarItem(id);
    }

    @Override
    public Optional<Admin> buscarId(Integer id) {
        return user.buscarId(id);
    }
    
    public boolean login(String email, String senha){
        return user.loginEmail(email, senha);
    }
    
    @Override
    public void atualizaView(){
        
    }
    
    
    
}
