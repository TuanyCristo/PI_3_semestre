package model.livros;

import java.util.ArrayList;

public class Estoque {
 private ArrayList<Livro> livro;
 private int qntTotalExemplares;
 private int qntDisponivel;
 private int qntEmprestada;

public Estoque() {
    this.livro = new ArrayList<Livro>();
}

public ArrayList<Livro> getLivro() {
    return livro;
}

public void setLivro(ArrayList<Livro> livro) {
    this.livro = livro;
}

public int getQntTotalExemplares() {
    return qntTotalExemplares;
}

public void setQntTotalExemplares(int qntTotalExemplares) {
    this.qntTotalExemplares = qntTotalExemplares;
}

public int getQntDisponivel() {
    return qntDisponivel;
}

public void setQntDisponivel(int qntDisponivel) {
    this.qntDisponivel = qntDisponivel;
}

public int getQntEmprestada() {
    return qntEmprestada;
}

public void setQntEmprestada(int qntEmprestada) {
    this.qntEmprestada = qntEmprestada;
}

public void adicionaLivro(Livro l){
    livro.add(l);
}

@Override
public String toString() {
    return "Estoque [livro=" + livro + "]";
}


    
}