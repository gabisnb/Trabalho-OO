package dcc025.trabalho.Usuario;

import dcc025.trabalho.exceptions.ProductAlreadyShoppingCart;
import dcc025.trabalho.model.Produto;
import dcc025.trabalho.persistence.ProdutoPersistence;
import dcc025.trabalho.persistence.VendedorPersistence;

import javax.swing.JOptionPane;

import java.util.*;

public class CarrinhoCompras {
    private Map<String, Integer> carrinho; //Gabriel: Armazena o produto junto com sua quantidade
    private double totalPagar;
    
    public CarrinhoCompras()
    {
        this.totalPagar = 0.0;
        carrinho =  new HashMap<>();
    }

    public void insereProduto(String product_id, int quantidade){
        ProdutoPersistence persistence = new ProdutoPersistence();
        Produto produto = persistence.getProductbyID(product_id);
        try{
            checkException(produto.getProduct_id());
            carrinho.put(produto.getProduct_id(), quantidade);
        }
        catch(ProductAlreadyShoppingCart e){
            carrinho.put(produto.getProduct_id(), carrinho.get(produto.getProduct_id())+1);
        }
        totalPagar += produto.getPreco();
    }
    
    public void checkException(String s) throws ProductAlreadyShoppingCart{
        if(carrinho.containsKey(s))
            throw new ProductAlreadyShoppingCart();
    }

    public void removeProduto(String product_id, int quantidade)
    {

        ProdutoPersistence persistence = new ProdutoPersistence();
        Produto produto = persistence.getProductbyID(product_id);

        if(carrinho.get(product_id) - quantidade > 0)
        {
            this.totalPagar -= produto.getPreco()*quantidade;
            int quantidadeNoCarrinhoAposRemocao = carrinho.get(product_id) - quantidade;
            carrinho.put(produto.getProduct_id(), quantidadeNoCarrinhoAposRemocao);
        }
        else{
            this.totalPagar -= carrinho.get(product_id)*produto.getPreco();
            carrinho.remove(product_id);
        }
    }

    public void comprarTudo()
    {
        VendedorPersistence vendedorPers = new VendedorPersistence();
        ProdutoPersistence persistence = new ProdutoPersistence();
        
        for(String id : carrinho.keySet()){
            try{
                Produto produto = persistence.getProductbyID(id);
                Vendedor vendedor = vendedorPers.findVendedorByProductID(id);
                List<Vendedor> allV = vendedorPers.findAll();

                int index1 = 0;

                for(Vendedor vend : allV)
                    if(vendedor.compare(vend))
                        index1 = allV.indexOf(vend);

                allV.remove(index1);
                vendedorPers.remove(vendedor);

                vendedor.adicionaSaldo(produto.getPreco() * carrinho.get(id));
                allV.add(vendedor);
                vendedorPers.save(allV);

                if(produto.getQuantidade() - carrinho.get(id) > 0){
                    List<Produto> all = persistence.findAll();

                    int index = 0;

                    for(Produto product : all)
                        if(produto.compare(product))
                            index = all.indexOf(product);

                    all.remove(index);
                    persistence.remove(produto);
                    produto.setQuantidade(produto.getQuantidade() - carrinho.get(id) );
                    all.add(produto);
                    persistence.save(all);
                }
                else{
                    persistence.remove(produto);
                }
            }catch(NullPointerException ex){
                JOptionPane.showMessageDialog(null, "Produto Esgotado");
            }
            carrinho.remove(id);
        }
    carrinho.clear();
    }

    public double getTotalPagar(){
        return totalPagar;
    }
    
    public List<Produto> getProdutos(){
//        ProdutoPersistence persistence = new ProdutoPersistence();
//        List<Produto> produtos = new ArrayList();
//
//        List<String> invalido = new ArrayList();
//        this.totalPagar = 0;
//
//        for(String s: this.carrinho.keySet()){
//            Produto produto = persistence.getProductbyID(s);
//            if(produto!=null){
//                produto.setQuantidade(this.carrinho.getOrDefault(s, 1));
//                produtos.add(produto);
//                totalPagar += produto.getPreco()*produto.getQuantidade();
//                System.out.println(s);
//            }
//            else{
//                System.out.println( "Tem que apagar: "+s);
//                invalido.add(s);
//            }
//        }
//
//        for(String s: invalido){
//            this.carrinho.remove(s);
//        }
//        return produtos;
        ProdutoPersistence persistence = new ProdutoPersistence();
        List<Produto> produtos = new ArrayList<>();
        this.totalPagar = 0;
        try {
            for (String s : this.carrinho.keySet()) {
                try {
                    Produto produto = persistence.getProductbyID(s);
                    checkNull(produto);
                    produto.setQuantidade(this.carrinho.getOrDefault(s, 1));
                    produtos.add(produto);
                    totalPagar += produto.getPreco() * produto.getQuantidade();
                } catch (NullPointerException ex) {
                    JOptionPane.showMessageDialog(null, "Alguns produtos esgotaram desde a última vez que esteve por aqui :(");
                    carrinho.remove(s);
                }
            }
        }catch (ConcurrentModificationException ex){

        }
        return produtos;
    }

    public void checkNull(Produto produto){
        if(produto == null) throw new NullPointerException();
    }
    public int quantidadeEmCarrinho(String id){
        return carrinho.get(id);
    }
    
    public boolean isEmpty(){
        return this.carrinho.isEmpty();
    }
}
