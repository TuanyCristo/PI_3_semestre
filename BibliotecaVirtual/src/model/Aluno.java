package model;

//Aqui nós utilizamos herança
public class Aluno extends Usuario{
    private String ra;

    public Aluno() {
    }

    public Aluno(int idUsuario, String nome, String email, String senha, String ra) {
        super(idUsuario, nome, email, senha);
        this.ra = ra;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }


    

    
}