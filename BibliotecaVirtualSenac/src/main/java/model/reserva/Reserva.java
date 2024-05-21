package model.reserva;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.livros.Livro;
import model.user.Usuario;

public class Reserva  {
    private int id;
    private ArrayList<Livro> livro;
    private Usuario user;
    private Date dataReserva;
    private Date dataDevolucao;

    public Reserva() {
    }

    public Reserva(int id, ArrayList<Livro> livro, Usuario user, String dataReserva, String dataDevolucao) {
        this.id = id;
        this.livro = livro;
        this.user = user;
        try {
            this.dataReserva = new SimpleDateFormat("dd/MM/yyyy").parse(dataReserva);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            this.dataDevolucao = new SimpleDateFormat("dd/MM/yyyy").parse(dataReserva);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(Date dataReserva) {
        this.dataReserva = dataReserva;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public void adicionaLivro(Livro l){
        livro.add(l);
    }
    
}