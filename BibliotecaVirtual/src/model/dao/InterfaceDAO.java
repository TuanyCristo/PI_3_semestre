package model.dao;

import java.util.List;
import java.util.Optional;



public interface InterfaceDAO<T, ID> {
    public boolean inserirItem(T objeto);
    public boolean alterarItem(T objeto);
    public List<T> listarItens();
    public boolean deletarItem(ID id);
    public Optional<T> buscarId(ID id);

    
   
    
}
