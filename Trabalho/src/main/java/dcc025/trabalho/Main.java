package dcc025.trabalho;
import dcc025.trabalho.view.*;
import dcc025.trabalho.Usuario.*;
import dcc025.trabalho.exceptions.NegativePriceException;
import dcc025.trabalho.exceptions.NegativeQuantityException;
import dcc025.trabalho.model.Cor;
import dcc025.trabalho.model.Produto;
import dcc025.trabalho.model.SubTipoProduto;
import dcc025.trabalho.model.TiposProdutos;
import dcc025.trabalho.persistence.CompradorPersistence;
import dcc025.trabalho.persistence.ProdutoPersistence;
import dcc025.trabalho.persistence.VendedorPersistence;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        
        Vendedor.createID();
        VendedorPersistence persistence =  new VendedorPersistence();
        if(persistence.findAll().isEmpty()){
            List<Vendedor> list = new ArrayList();
            list.add(new Vendedor("Rodrigo", "rodrigomarques@gmail.com", "2365"));
            list.add(new Vendedor("Julia", "juliaasilva@hotmail.com", "bea453"));
            list.add(new Vendedor("Bernardo", "becoelho@yahoo.com.br", "123@0"));
            list.add(new Vendedor("adm", "adm", "adm"));
            persistence.save(list);
            ProdutoPersistence ppersistence = new ProdutoPersistence();
            if(ppersistence.findAll().isEmpty()){
                List<Produto> produtos = new ArrayList();
                try{
                    produtos.add(new Produto(1000, 20, Cor.BRANCO, TiposProdutos.ELETRODOMESTICO, SubTipoProduto.GELADEIRA, list.get(0).getId()));
                    produtos.add(new Produto(700, 30, Cor.PRETO, TiposProdutos.ELETRODOMESTICO, SubTipoProduto.FOGAO, list.get(0).getId()));
                    produtos.add(new Produto(3000, 10, Cor.ROSA, TiposProdutos.ELETRODOMESTICO, SubTipoProduto.COMPUTADOR, list.get(0).getId()));
                    produtos.add(new Produto(40, 5, Cor.ROXO, TiposProdutos.ROUPAS, SubTipoProduto.BLUSA, list.get(1).getId()));
                    produtos.add(new Produto(2, 50, Cor.CINZA, TiposProdutos.MATERIAL_ESCRITORIO, SubTipoProduto.LAPIS, list.get(1).getId()));
                    produtos.add(new Produto(50, 1, Cor.AMARELO, TiposProdutos.MOVEL, SubTipoProduto.LUMINARIA, list.get(1).getId()));
                    produtos.add(new Produto(30, 1, Cor.AZUL, TiposProdutos.ROUPAS, SubTipoProduto.SAPATO, list.get(1).getId()));
                }
                catch(NegativePriceException | NegativeQuantityException e){}
                ppersistence.save(produtos);
            }
        }
        
        CompradorPersistence cpersistence =  new CompradorPersistence();
        if(cpersistence.findAll().isEmpty()){
            List<Comprador> clist = new ArrayList();
            clist.add(new Comprador("Thiago", "thiagofernandes@hotmail.com", "45sist", 100.00));
            clist.add(new Comprador("Alessandra", "alebatista@yahoo.com.br", "abc650", 235.00));
            clist.add(new Comprador("Fernanda", "fernandatrib@gmail.com", "98h56", 0));
            clist.add(new Comprador("adm", "adm", "adm", 10000.00));
            cpersistence.save(clist);
        }
        
        TelaLogin login = new TelaLogin();
        login.desenha();
    }       
}


