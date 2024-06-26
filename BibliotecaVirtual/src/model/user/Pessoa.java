package model.user;


abstract class Pessoa {
    protected int idUsuario;
    protected String nome;
    protected String emailInstitucional;
    protected String senha;


    public Pessoa() {
    }

    public Pessoa(int idUsuario, String nome, String emailInstitucional, String senha) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.emailInstitucional = emailInstitucional;
        this.senha = senha;
        
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





}
