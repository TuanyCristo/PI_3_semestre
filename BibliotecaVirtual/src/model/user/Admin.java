package model.user;
//Aqui nós utilizamos herança
public class Admin extends Pessoa{
    private String cargo;

    public Admin() {
    }

    public Admin(int idUsuario, String nome, String emailInstitucional, String senha, String cargo) {
        super(idUsuario, nome, emailInstitucional, senha);
        this.cargo = cargo;
        this.nivelAcesso = "adm";
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    

    
}
