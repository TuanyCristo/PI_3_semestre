package model.reserva;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

    public Reserva(int id, Livro livros, Usuario user, String dataParaReserva) {
        this.id = id;
        this.livro = new ArrayList<Livro>();
        livro.add(livros);
        this.user = user;
        //Recebemos uma String de data e formatamos
        try {
            this.dataReserva = new SimpleDateFormat("dd/MM/yyyy").parse(dataParaReserva);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //Adicionando 10 dias para devolução após o dia da reserva.
        Calendar ob = Calendar.getInstance();
        ob.setTime(this.dataReserva);
        ob.add(Calendar.DATE, + 10);
        this.dataDevolucao = ob.getTime();
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

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Reserva [id=" + id + ", livro=" + livro + ", user=" + user 
            + ", dataReserva=" + sdf.format(dataReserva) 
            + ", dataDevolucao=" + sdf.format(dataDevolucao) + "]";
    }
    
    
    
}