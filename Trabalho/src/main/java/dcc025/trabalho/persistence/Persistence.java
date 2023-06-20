package dcc025.trabalho.persistence;

import java.util.List;

public interface Persistence <T> {

    String DIRECTORY = "data";

    public void save(List<T> itens);

    public List<T> findAll();
}
