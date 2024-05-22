package model.user;
//Aqui nós utilizamos herança
public class Admin extends Pessoa{
    private String cargo;

    public Admin() {
    }

    public Admin(int idUsuario, String nome, String emailInstitucional, String senha, String cargo, String nivelAcesso) {
        super(idUsuario, nome, emailInstitucional, senha, nivelAcesso);
        this.cargo = cargo;
        this.nivelAcesso = "admin";
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    

    
}
