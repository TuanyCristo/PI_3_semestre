package model.user;

import java.util.ArrayList;
import model.livros.Livro;

public class Usuario {
private int idUsuario;
private String nome;
private String emailInstitucional;
private String senha;
private ArrayList<Livro> listaLivros;

public Usuario() {
}

public Usuario(int idUsuario, String nome, String emailInstitucional, String senha) {
    this.idUsuario = idUsuario;
    this.nome = nome;
    this.emailInstitucional = emailInstitucional;
    this.senha = senha;
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

@Override
public String toString() {
    return "Usuario [idUsuario=" + idUsuario + ", nome=" + nome + ", emailInstitucional=" + emailInstitucional
            + ", senha=" + senha + "]";
}




}
