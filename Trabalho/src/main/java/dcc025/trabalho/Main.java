package dcc025.trabalho;
import dcc025.trabalho.view.*;
import dcc025.trabalho.Usuario.*;

public class Main {

    public static void main(String[] args) {
        
        TelaLogin login = new TelaLogin();
        login.desenha();
//        TelaCompra compra = new TelaCompra(login, new Comprador("teste", "teste", "teste"));
//        compra.desenha();
        
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


