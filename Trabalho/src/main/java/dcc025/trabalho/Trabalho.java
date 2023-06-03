package dcc025.trabalho;

import dcc025.trabalho.Usuario.*;
import dcc025.trabalho.Telas.*;
import java.util.Scanner;

public class Trabalho {

    public static void main(String[] args) {
//        Scanner teclado = new Scanner(System.in);
//        int tipoUsuario; 
//        String nome, email, senha;
//        
//        System.out.println("");
//        System.out.println("--LOGIN--");
//        System.out.print("Nome: ");
//        nome = teclado.next();
//        System.out.print("Email: ");
//        email = teclado.next();
//        System.out.print("Senha: ");
//        senha = teclado.next();
//        System.out.println("");
//        System.out.println("--TIPO DE USUÁRIO--");
//        System.out.println("1 - Vendedor");
//        System.out.println("2 - Comprador");
//        tipoUsuario = teclado.nextInt();
//        
//        Produto roupa = new Roupa(50.00, 5, Cor.VERMELHO, TiposProdutos.TipoRoupa.BLUSA );
//        Produto movel = new Movel(250.00, 5, Cor.BRANCO, TiposProdutos.TipoMovel.MESA);
//        Produto material = new MaterialEscritorio(5, 5, Cor.PRETO, TiposProdutos.TipoMatEscritorio.CANETA);
//        Produto eletrodomestico = new Eletrodomestico(3000, 5, Cor.AZUL_CLARO, TiposProdutos.TipoEletrodomestico.COMPUTADOR);
//        
//        
//        switch(tipoUsuario){
//            case 1:
//                Vendedor vendedor = new Vendedor(nome, email, senha);
//                vendedor.DadosVendedor();
//                vendedor.adicionarProduto(roupa);
//                vendedor.adicionarProduto(movel);
//                vendedor.adicionarProduto(material);
//                vendedor.adicionarProduto(eletrodomestico);
//                vendedor.exibirEstoque();
//                break;
//            
//            case 2:
//                Comprador comprador = new Comprador(nome, email, senha);
//                comprador.DadosComprador();
//                comprador.adicionarCarrinho(roupa, 1);
//                comprador.adicionarCarrinho(movel, 1);
//                comprador.adicionarCarrinho(material, 2);
//                comprador.adicionarCarrinho(eletrodomestico, 5);
//                comprador.exibirCarrinho();
//                break;
//            
//            default:
//                System.out.println("Opção de usuário inválido");
//                break;
//        }       
        Scanner teclado = new Scanner(System.in);
        
        int opcao = 0;
        do{
            System.out.println("TESTE DAS TELAS");
            System.out.println("[1] Login");
            System.out.println("[2] Comprador");
            System.out.println("[3] Vendedor");
            System.out.println("[4] Carrinho");
            switch(opcao){
                case 1:
                    TelaLogin tela = new TelaLogin();
                    tela.desenha();
                    break;
                case 2:
                    TelaCompra tela2 = new TelaCompra(
                            new Comprador("testeComprador","comprador@teste.com", "senha"));
                    tela2.desenha();
                    break;
                case 3:
                    TelaVende tela3 = new TelaVende(
                            new Vendedor("testeVendedor", "vendedor@teste.com", "senha"));
                    tela3.desenha();
                    break;
                case 4:
                    TelaCarrinho tela4 = new TelaCarrinho(
                            new Comprador("testeCompradorCarrinho", "comprador@teste.com", "senha"),
                            new CarrinhoCompras());
                    tela4.desenha();
                    break;
            }
        }while((opcao = teclado.nextInt()) > 0);
    }
}

