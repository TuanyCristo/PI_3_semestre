package com.mycompany;


import model.livros.Estoque;
import model.livros.Livro;
import model.reserva.Reserva;
import model.user.Usuario;

public class Teste {
    public static void main(String[] args) {
        Estoque e = new Estoque();

        Livro l = new Livro(1, "null", "null", "null", 5);
        System.out.println(l);

        e.adicionaLivro(l);

        System.out.println(e);


        Usuario u = new Usuario(0, "Tuany", "null", "123456");
        Reserva r = new Reserva(l, u, null, null);

        System.out.println(r);

    }
}
