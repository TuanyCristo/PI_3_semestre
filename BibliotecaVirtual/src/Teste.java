import controller.LivroController;
import controller.UsuarioController;
import java.sql.Date;
import java.util.Optional;
import model.dao.ReservaDAO;
import model.livros.Livro;
import model.reserva.Reserva;
import model.user.Usuario;

public class Teste {
    public static void main(String[] args) {
        ReservaDAO reservaDAO = new ReservaDAO();
        LivroController livroController = new LivroController();
        UsuarioController user = new UsuarioController();

        // Busca o livro pelo ID
        Optional<Livro> optionalLivro = livroController.buscarId(2);
        Optional<Usuario> userop = user.buscarId(1);

        if (optionalLivro.isPresent()) { // Verifica se o livro foi encontrado
            Livro livro = optionalLivro.get(); // Obtém o livro do Optional

            if(userop.isPresent()){
                Usuario u = userop.get();
            // Cria uma instância de Reserva e configura o livro e a data de reserva
            Reserva reserva = new Reserva();
            reserva.setUser(u);
            reserva.setDataReserva(Date.valueOf("2024-05-27")); // Converte a string para java.sql.Date

            // Insere a reserva no banco de dados
                if (reservaDAO.inserirItem(reserva, 8)) {
                    System.out.println("Reserva inserida com sucesso!");
                } else {
                    System.out.println("Falha ao inserir reserva.");
                }
            } else {
                System.out.println("Livro não encontrado.");
            }
        }
    }

}
