package model.user;

import java.util.ArrayList;
import model.livros.Livro;

public class Usuario extends Pessoa {

    private ArrayList<Livro> listaLivros;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nome, String emailInstitucional, String senha, String nivelAcesso) {
        super(idUsuario, nome, emailInstitucional, senha, nivelAcesso);
        this.listaLivros = new ArrayList<Livro>();
        this.nivelAcesso = "regular";
    }

    public ArrayList<Livro> getListaLivros() {
        return listaLivros;
    }

    public void setListaLivros(ArrayList<Livro> listaLivros) {
        this.listaLivros = listaLivros;
    }

    
    
   
}
