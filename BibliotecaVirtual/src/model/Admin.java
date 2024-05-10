package model;

//Aqui nós utilizamos herança
public class Admin extends Usuario{
    private String cargo;
    private String cpf;

    public Admin() {
    }

    public Admin(int idUsuario, String nome, String email, String senha, String cargo, String cpf) {
        super(idUsuario, nome, email, senha);
        this.cargo = cargo;
        this.cpf = cpf;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    

    
}
