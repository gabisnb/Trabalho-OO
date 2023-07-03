package dcc025.trabalho;
import dcc025.trabalho.view.*;
import dcc025.trabalho.Usuario.*;
import dcc025.trabalho.persistence.CompradorPersistence;
import dcc025.trabalho.persistence.VendedorPersistence;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        
       VendedorPersistence persistence =  new VendedorPersistence();
       List<Vendedor> list = new ArrayList();
        list.add(new Vendedor("t", "t", "t"));

       persistence.save(list);
        list.add(new Vendedor("a", "a", "a"));
        persistence.save(list);

//        CompradorPersistence cpersistence =  new CompradorPersistence();
//        List<Comprador> clist = new ArrayList();
//        clist.add(new Comprador("t", "t", "t", 100.00));
//        cpersistence.save(clist);
//        clist.add(new Comprador("a", "a", "a", 1000.00));
//        cpersistence.save(clist);
//
        TelaLogin login = new TelaLogin();
        login.desenha();
//        TelaCompra compra = new TelaCompra(login, new Comprador("teste", "teste", "teste"));
//        compra.desenha();
//        TelaVende vende = new TelaVende(null, new Vendedor("teste", "teste", "teste"));
//        vende.desenha();
//        TelaCarrinho tela = new TelaCarrinho(new Comprador("teste", "teste", "teste"));
//        tela.desenha();
        
        /* Scanner teclado = new Scanner(System.in);
        int tipoUsuario; 
        String nome, email, senha;
        
        System.out.println("");
        System.out.println("--LOGIN--");
        System.out.print("Nome: ");
        nome = teclado.next();
        System.out.print("Email: ");
        email = teclado.next();
        System.out.print("Senha: ");
        senha = teclado.next();
        System.out.println("");
        System.out.println("--TIPO DE USUÁRIO--");
        System.out.println("1 - Vendedor");
        System.out.println("2 - Comprador");
        tipoUsuario = teclado.nextInt();
        
        Produto eletrodomestico = new Produto(3000, 5, Cor.AZUL_CLARO, "Computador");
        
        
        switch(tipoUsuario){
            case 1:
                Vendedor vendedor = new Vendedor(nome, email, senha);
                vendedor.DadosVendedor();
                vendedor.adicionarProduto(roupa);
                roupa.addCorProduto(12, Cor.ROSA);
                vendedor.adicionarProduto(movel);
                vendedor.adicionarProduto(material);
                vendedor.adicionarProduto(eletrodomestico);
                vendedor.exibirEstoque();
                break;
            
            case 2:
                Comprador comprador = new Comprador(nome, email, senha);
                comprador.DadosComprador();
                comprador.adicionarCarrinho(roupa, 1);
                comprador.adicionarCarrinho(movel, 1);
                comprador.adicionarCarrinho(material, 2);
                comprador.adicionarCarrinho(eletrodomestico, 5);
                comprador.exibirCarrinho();
                break;
            
            default:
                System.out.println("Opção de usuário inválido");
                break;
        */}       
    }


