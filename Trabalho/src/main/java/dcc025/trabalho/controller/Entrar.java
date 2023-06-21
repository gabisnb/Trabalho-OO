/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.trabalho.controller;

import dcc025.trabalho.Usuario.Comprador;
import dcc025.trabalho.Usuario.Vendedor;
import dcc025.trabalho.persistence.CompradorPersistence;
import dcc025.trabalho.persistence.VendedorPersistence;
import dcc025.trabalho.view.TelaLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gabri
 */
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
            for(Comprador aux: compradores){
                if(aux.getNome().equals(info[0]) && aux.getEmail().equals(info[1]) && aux.getSenha().equals(info[2])){
                    comprador = new Comprador(info[0], info[1], info[2], aux.getSaldo());
                }
            }
            if(comprador==null){
                JOptionPane.showMessageDialog(null,"Login inválido!");
                return;
            }
            tela.entrarComprador(comprador);
        }
        else{
            VendedorPersistence persistence = new VendedorPersistence();
            List<Vendedor> vendedores = persistence.findAll();
            Vendedor vendedor = null;
            for(Vendedor aux: vendedores){
                if(aux.getNome().equals(info[0]) && aux.getEmail().equals(info[1]) && aux.getSenha().equals(info[2]))
                    vendedor = new Vendedor(info[0], info[1], info[2]);
            }
            if(vendedor==null){
                JOptionPane.showMessageDialog(null,"Login inválido!");
                return;
            }
            tela.entrarVendedor(vendedor);
        }
    }
    
}
