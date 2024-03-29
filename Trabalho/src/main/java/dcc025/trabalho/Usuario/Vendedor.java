package dcc025.trabalho.Usuario;

import dcc025.trabalho.model.Produto;
import dcc025.trabalho.persistence.Persistence;
import dcc025.trabalho.persistence.ProdutoPersistence;
import dcc025.trabalho.persistence.VendedorPersistence;

import java.util.*;

public class Vendedor extends Pessoa implements Compare<Vendedor>{

    private final int id;
    private static int n_vendedores;

    public Vendedor(String nome, String email, String senha) {
        super(nome, email, senha);
        super.setSaldo(0);
        this.id = n_vendedores++;
    }
    public String getId(){ return Integer.toString(this.id); }

    public void adicionarSaldo(double valor){
        super.setSaldo(getSaldo() + valor);
    }
    
    //Função adicionada apenas para testagem da adição de produto, mudar depois


    public static List<Produto> getProdutosByVendedorID(String vender_id){
        ProdutoPersistence persistence = new ProdutoPersistence();
        List<Produto> allProducts;
        allProducts = persistence.findAll();

        List<Produto> sameIdProducts = new ArrayList<>();

        for(Produto produto : allProducts){
            if(separateProductId(produto.getProduct_id()).equals(vender_id)){
                sameIdProducts.add(produto);
            }
        }
        return sameIdProducts;
    }

    private static String separateProductId(String product_id){
        String[] id = product_id.split("x");

        return id[0];
    }

    public static void createID(){
        Persistence<Vendedor> all = new VendedorPersistence();
        List<Vendedor> allVender = all.findAll();

        if (allVender.isEmpty()) n_vendedores = 0;
        else n_vendedores = allVender.size();
    }
    
    @Override
    public String toString(){
        return "Loja de " +  this.getNome();
    }

    @Override
    public boolean compare(Vendedor item) {
        return this.getId().equals(item.getId());
    }
}
