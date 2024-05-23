package controller;

import java.util.List;
import java.util.Optional;
import model.dao.LivroDAO;
import model.livros.Livro;

public class LivroController implements Controller<Livro, Integer>{

    private LivroDAO livro;
    
    public LivroController() {
        this.livro = new LivroDAO();
    }

 
    @Override
    public boolean adicionar(Livro objeto) {
        return livro.inserirItem(objeto);
    }

    @Override
    public boolean alterar(int id, Livro objeto) {
        return livro.alterarItem(id, objeto);
    }

    @Override
    public List<Livro> listar() {
        return livro.listarItens();
    }

    @Override
    public boolean deletar(Integer id) {
        return livro.deletarItem(id);
    }

    @Override
    public Optional<Livro> buscarId(Integer id) {
        return livro.buscarId(id);
    }

    @Override
    public void atualizaView() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}