package model.user;

//imports para fazer o hash funcionar
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.mindrot.jbcrypt.BCrypt;

abstract class Pessoa {
    protected int idUsuario;
    protected String nome;
    protected String emailInstitucional;
    protected String senha;
    protected String nivelAcesso;

    public Pessoa() {
    }

    public Pessoa(int idUsuario, String nome, String emailInstitucional, String senha, String nivelAcesso) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.emailInstitucional = emailInstitucional;
        this.senha = senha;
        this.nivelAcesso = nivelAcesso;
        
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
            this.senha = BCrypt.hashpw(senha, BCrypt.gensalt());
    }

    public String getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(String nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    public boolean confirmaSenha(String senha){
        return BCrypt.checkpw(senha, this.senha);
    }




}
