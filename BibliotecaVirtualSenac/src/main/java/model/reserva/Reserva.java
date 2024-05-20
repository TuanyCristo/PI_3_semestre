package model.reserva;

import java.util.ArrayList;


import model.livros.Livro;
import model.user.Usuario;

public class Reserva  {
    private ArrayList<Livro> livro;
    private Usuario user;
    private String dataReserva;
    private String dataDevolucao;

    public Reserva() {
    }

    public Reserva(Livro livro, Usuario user, String dataReserva, String dataDevolucao) {
        this.livro = new ArrayList<Livro>();
        Reserva.this.adicionaLivro(livro);
        this.user = user;
        this.dataReserva = dataReserva;
        this.dataDevolucao = dataDevolucao;
    }

    public ArrayList<Livro> getLivro() {
        return livro;
    }

    public void setLivro(ArrayList<Livro> livro) {
        this.livro = livro;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public String getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(String dataReserva) {
        this.dataReserva = dataReserva;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public void adicionaLivro(Livro l){
        livro.add(l);
    }

    @Override
    public String toString() {
        return "Reserva [livro=" + livro + ", user=" + user + ", dataReserva=" + dataReserva + ", dataDevolucao="
                + dataDevolucao + "]";
    }

    
    
}