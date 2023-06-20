/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.trabalho.persistence;

import dcc025.trabalho.Usuario.Vendedor;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

public class VendedorPersistence implements Persistence <Vendedor>{

    private static final String PATH = DIRECTORY + File.separator + "vendedores.json";

    @Override
    public void save(List<Vendedor> itens) {
        Gson gson = new Gson();
        String json = gson.toJson(itens);

        File diretorio = new File(DIRECTORY);
        if (!diretorio.exists()) {
            diretorio.mkdirs();
        }

        Arquivo.salva(PATH, json);
    }

    @Override
    public List<Vendedor> findAll() {
        Gson gson = new Gson();

        String json = Arquivo.le(PATH);

        List<Vendedor> vendedores = new ArrayList<>();
        if (!json.trim().equals("")) {

            Type tipoLista = new TypeToken<List<Vendedor>>() {
            }.getType();
            vendedores = gson.fromJson(json, tipoLista);

            if (vendedores == null) {
                vendedores = new ArrayList<>();
            }
        }

        return vendedores;
    }
}
