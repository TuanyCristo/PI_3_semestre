package controller;

import java.util.List;
import java.util.Optional;

public interface Controller<T, ID> {
    public boolean adicionar(T objeto);
    public boolean alterar(int id, T objeto);
    public List<T> listar();
    public boolean deletar(ID id);
    public Optional<T> buscarId(ID id);
    public void atualizaView();
}
