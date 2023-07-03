package dcc025.trabalho.persistence;

import dcc025.trabalho.Usuario.Vendedor;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import javax.swing.JOptionPane;

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

    public Vendedor findVendedorByProductID(String product_id){
        String [] split_ID = product_id.split("x");
        String vendedorID = split_ID[0];

        List<Vendedor> vendedores = findAll();

        for (Vendedor vendedor : vendedores){
            if(vendedor.getId().equals(vendedorID)) return vendedor;
        }

        return null;
    }
    
    public void remove(Vendedor vendedor){
        List<Vendedor> all = findAll();
        
        int index = 0;
        
        for(Vendedor vende : all)
            if(vendedor.compare(vende))
                index = all.indexOf(vende);
        
        all.remove(index);
        save(all);
    }
}
