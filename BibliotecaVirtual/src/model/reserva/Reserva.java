package model.reserva;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;




import model.livros.Livro;
import model.user.Usuario;

public class Reserva  {
    private int id;
    private ArrayList<Livro> listaLivro;
    private Usuario user;
    private Date dataReserva;
    private Date dataDevolucao;

    public Reserva() {
    }

    public Reserva(int id, Livro livros, Usuario user, String dataParaReserva) {
        this.id = id;
        this.listaLivro = new ArrayList<>();
        this.user = user;
        //Recebemos uma String de data e formatamos
        try {
            this.dataReserva = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(dataParaReserva);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
        }

        //Adicionando 10 dias para devolução após o dia da reserva.
        Calendar ob = Calendar.getInstance();
        ob.setTime(this.dataReserva);
        ob.add(Calendar.DATE, + 10);
        this.dataDevolucao = (Date) ob.getTime();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Livro> getListaLivro() {
        return listaLivro;
    }

    public void setListaLivro(ArrayList<Livro> listaLivro) {
        this.listaLivro = listaLivro;
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
        //Adicionando 10 dias para devolução após o dia da reserva.
        Calendar ob = Calendar.getInstance();
        ob.setTime(this.dataReserva);
        ob.add(Calendar.DATE, + 10);
        this.dataDevolucao = (Date) ob.getTime();
    }

 
}