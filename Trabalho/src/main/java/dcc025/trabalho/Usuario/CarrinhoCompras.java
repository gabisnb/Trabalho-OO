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

    public void comprarTudo() throws NullPointerException,IndexOutOfBoundsException
    {
        VendedorPersistence vendedorPers = new VendedorPersistence();
        ProdutoPersistence persistence = new ProdutoPersistence();
        int indexV = -1;
        Produto produto=null;
        Set<String> setProdutos = carrinho.keySet();
        String[] array = new String[setProdutos.size()];
        array = setProdutos.toArray(array);
        for(String id : array){
            produto = persistence.getProductbyID(id);
            Vendedor vendedor = vendedorPers.findVendedorByProductID(id);
            List<Vendedor> allV = vendedorPers.findAll();
            List<Produto> all = persistence.findAll();
            for(Vendedor vend : allV)
                if(vendedor.compare(vend)){
                    indexV = allV.indexOf(vend);
                    break;
                }

            if(produto.getQuantidade() - carrinho.get(id) > 0){
                int index = -1;

                for(Produto product : all)
                    if(produto.compare(product)){
                        index = all.indexOf(product);
                        break;
                    }

                all.get(index).setQuantidade(produto.getQuantidade() - carrinho.get(id) );
                persistence.save(all);
                allV.get(indexV).adicionaSaldo(produto.getPreco() * carrinho.get(id));
                vendedorPers.save(allV);
            }
            else{
                persistence.remove(produto);
            }
        }
        carrinho.clear();
    }

    public double getTotalPagar(){
        return totalPagar;
    }
    
    public List<Produto> getProdutos(){
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
