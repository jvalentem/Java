package dao;

import java.util.ArrayList;

public interface GenericDAO <ObjetoGenerico> {
    
    void inserir(ObjetoGenerico obj);
    ArrayList<ObjetoGenerico> listar();
    Object buscarID(ObjetoGenerico obj);
    void atualizar(ObjetoGenerico obj);
    void excluir(ObjetoGenerico obj);
    
}
