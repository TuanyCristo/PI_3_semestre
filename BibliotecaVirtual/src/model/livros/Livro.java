package model.livros;

public class Livro {
    private int idLivro;
    private String titulo;
    private String autor;
    private int qntExemplares;

    public Livro() {
    }

    public Livro(int idLivro, String titulo, String autor, int qntExemplares) {
        this.idLivro = idLivro;
        this.titulo = titulo;
        this.autor = autor;
        this.qntExemplares = qntExemplares;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getQntExemplares() {
        return qntExemplares;
    }

    public void setQntExemplares(int qntExemplares) {
        this.qntExemplares = qntExemplares;
    }

 }