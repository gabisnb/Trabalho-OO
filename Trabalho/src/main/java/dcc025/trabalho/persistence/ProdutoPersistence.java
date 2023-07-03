package dcc025.trabalho.persistence;

import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import dcc025.trabalho.model.Produto;

public class ProdutoPersistence implements Persistence <Produto>{

    private static final String PATH = DIRECTORY + File.separator + "produto.json";

    @Override
    public void save(List<Produto> itens) {
        Gson gson = new Gson();
        String json = gson.toJson(itens);

        File diretorio = new File(DIRECTORY);
        if (!diretorio.exists()) {
            diretorio.mkdirs();
        }

        Arquivo.salva(PATH, json);
    }

    @Override
    public List<Produto> findAll() {
        Gson gson = new Gson();

        String json = Arquivo.le(PATH);

        List<Produto> produtos = new ArrayList<>();
        if (!json.trim().equals("")) {

            Type tipoLista = new TypeToken<List<Produto>>() {
            }.getType();
            produtos = gson.fromJson(json, tipoLista);

            if (produtos == null) {
                produtos = new ArrayList<>();
            }
        }

        return produtos;
    }

    public Produto getProductbyID(String product_id){
        List<Produto> produtos = new ArrayList<>();
        produtos = findAll();
        for(Produto produto : produtos) {
            if (produto.getProduct_id().equals(product_id)) return produto;
        }
        return null;
    }
    
    public void remove(Produto produto){
        List<Produto> all = findAll();
        
        int index = 0;
        
        for(Produto product : all)
            if(produto.compare(product))
                index = all.indexOf(product);
        
        all.remove(index);
        save(all);
    }
    
}
