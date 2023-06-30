package dcc025.trabalho.controller;

import dcc025.trabalho.Usuario.Comprador;
import dcc025.trabalho.Usuario.Pessoa;
import dcc025.trabalho.Usuario.Vendedor;
import dcc025.trabalho.exceptions.InvalidLoginException;
import dcc025.trabalho.persistence.CompradorPersistence;
import dcc025.trabalho.persistence.VendedorPersistence;
import dcc025.trabalho.view.TelaLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

public class Entrar  implements ActionListener{
    
    private final TelaLogin tela;
    
    public Entrar(TelaLogin tela){
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String [] info = tela.getInfo();
        int index = tela.getSelectedUsuario();
        
        if(index==0){
            CompradorPersistence persistence = new CompradorPersistence();
            List<Comprador> compradores = persistence.findAll();
            Comprador comprador = null;
            try
            {
                for(Comprador aux: compradores){
                    if(aux.getNome().equals(info[0]) && aux.getEmail().equals(info[1]) && aux.getSenha().equals(info[2])){
                        comprador = aux;
                    }
                }
                checkPessoa(comprador);
            }catch (InvalidLoginException ex){
                JOptionPane.showMessageDialog(null,"Login inválido!");
                return;
            }

            tela.entrarComprador(comprador);
        }
        else{
            VendedorPersistence persistence = new VendedorPersistence();
            List<Vendedor> vendedores = persistence.findAll();
            Vendedor vendedor = null;

            try
            {
                for(Vendedor aux: vendedores){
                    if(aux.getNome().equals(info[0]) && aux.getEmail().equals(info[1]) && aux.getSenha().equals(info[2])) {
                        vendedor = aux;
                    }
                }
                checkPessoa(vendedor);
            }catch (InvalidLoginException ex){
                JOptionPane.showMessageDialog(null,"Login inválido!");
                return;
            }

            tela.entrarVendedor(vendedor);
        }
    }
    public void checkPessoa(Pessoa login) throws InvalidLoginException {
        if (login == null) throw new InvalidLoginException();
    }
}
