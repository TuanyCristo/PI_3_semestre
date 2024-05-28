package model.user;

import java.util.ArrayList;
import model.livros.Livro;

public class Usuario extends Pessoa {

    private ArrayList<Livro> listaLivros;

    public Usuario() {
        
    }

    public Usuario(int idUsuario, String nome, String emailInstitucional, String senha) {
        super(idUsuario, nome, emailInstitucional, senha);
        this.listaLivros = new ArrayList<Livro>();
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmailInstitucional() {
        return emailInstitucional;
    }

    public void setEmailInstitucional(String emailInstitucional) {
        this.emailInstitucional = emailInstitucional;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    

    public ArrayList<Livro> getListaLivros() {
        return listaLivros;
    }

    public void setListaLivros(ArrayList<Livro> listaLivros) {
        this.listaLivros = listaLivros;
    }

    
    
   
}
