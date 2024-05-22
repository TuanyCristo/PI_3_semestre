import model.livros.Livro;
import model.reserva.Reserva;
import model.user.Usuario;

public class Teste {
    public static void main(String[] args) {
        Usuario u = new Usuario(1, "Tuany", "E-mail", "123456");
        Livro l = new Livro();

        Reserva r = new Reserva(1, l, u, "22/05/2024");

        System.out.println(r);
    }
}
