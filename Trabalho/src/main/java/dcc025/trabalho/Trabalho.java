package dcc025.trabalho;

import dcc025.trabalho.Usuario.CarrinhoCompras;
import dcc025.trabalho.Usuario.Vendedor;
import dcc025.trabalho.Usuario.Comprador;
import dcc025.trabalho.view.*;
import java.util.Scanner;

public class Trabalho {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcao;
        
        do{
            System.out.println("TESTE TELAS");
            System.out.println("[1] Login");
            System.out.println("[2] Comprador");
            System.out.println("[3] Vendedor");
            System.out.println("[4] Carrinho");
            System.out.println("[5] Add Produto");
            opcao = teclado.nextInt();
            
            switch(opcao){
                case 1 -> {
                    TelaLogin tela1 = new TelaLogin();
                    tela1.desenha();
                }
                case 2 -> {
                    TelaComprador tela2 = new TelaComprador(
                            new Comprador("testeComprador", "comprador@teste.br", "senha"));
                    tela2.desenha();
                }
                case 3 -> {
                    TelaVendedor tela3 = new TelaVendedor(
                            new Vendedor("testeVendedor", "vendedor@teste.br", "senha"));
                    tela3.desenha();
                }
                case 4 -> {
                    TelaCarrinho tela4 = new TelaCarrinho(
                            new Comprador("teste", "comprador@teste.br", "senha"),
                            new CarrinhoCompras());
                    tela4.desenha();
                }
                
                case 5 -> {
                    AddProduto tela5 = new AddProduto();
                    tela5.desenha();
                }
            }
        }while(opcao > 0);
    }
}

