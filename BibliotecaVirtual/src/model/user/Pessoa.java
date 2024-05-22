package model.user;

//imports para fazer o hash funcionar
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
        if(validaEmail(emailInstitucional)) this.emailInstitucional = emailInstitucional;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
        //if(validaSenha(senha)) this.senha = senhaHash(senha);

    }

    public String getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(String nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
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

    public String senhaHash(String senha){
        try {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(senha.getBytes());

        // Converter o hash em uma representação hexadecimal
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }

        return hexString.toString();
    } catch (NoSuchAlgorithmException e) {
        // Tratar erro de algoritmo não encontrado
        e.printStackTrace();
        return null;
    }
    }

    private boolean validaEmail(String email) {
        // quebra o email no @
        String[] partes = email.split("@");
        
        if (partes.length == 2) {
            //verifica de a ultima parte do vetor é o email institucional
            if(partes[1].equals("senacsp.edu.br")){
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
    
    public boolean confirmaSenha(String senhaBD, String senhaText){
        return senhaBD.equals(senhaText);
    }




}
