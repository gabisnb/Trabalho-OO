/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.trabalho.persistence;

import dcc025.trabalho.Usuario.Comprador;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

public class CompradorPersistence implements Persistence<Comprador>{
 private static final String PATH = DIRECTORY + File.separator + "compradores.json";
    @Override
    public void save(List<Comprador> itens){
        Gson gson = new Gson();
        String json = gson.toJson(itens);

        File diretorio = new File(DIRECTORY);
        if(!diretorio.exists())
            diretorio.mkdirs();

        Arquivo.salva(PATH, json);
    }

    @Override
    public List<Comprador> findAll() {
        Gson gson = new Gson();

        String json = Arquivo.le(PATH);

        List<Comprador> compradores = new ArrayList<>();
        if(!json.trim().equals("")) {

            Type tipoLista = new TypeToken<List<Comprador>>() {
            }.getType();
            compradores = gson.fromJson(json, tipoLista);

            if (compradores == null)
                compradores = new ArrayList<>();
        }

        return compradores;   
    }
}
