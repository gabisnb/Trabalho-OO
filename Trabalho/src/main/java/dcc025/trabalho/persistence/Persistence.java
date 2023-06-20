/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dcc025.trabalho.persistence;

import java.util.List;

/**
 *
 * @author duda2
 */
public interface Persistence <T> {

    String DIRECTORY = "data";

    public void save(List<T> itens);

    public List<T> findAll();
}
