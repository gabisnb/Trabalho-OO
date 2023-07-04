package dcc025.trabalho;
import dcc025.trabalho.view.*;
import dcc025.trabalho.Usuario.*;
import dcc025.trabalho.persistence.CompradorPersistence;
import dcc025.trabalho.persistence.VendedorPersistence;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        
        VendedorPersistence persistence =  new VendedorPersistence();
        if(persistence.findAll()==null){
            List<Vendedor> list = new ArrayList();
            list.add(new Vendedor("t", "t", "t"));
            list.add(new Vendedor("a", "a", "a"));
            persistence.save(list);
        }
        
        CompradorPersistence cpersistence =  new CompradorPersistence();
        if(cpersistence.findAll()==null){
            List<Comprador> clist = new ArrayList();
            clist.add(new Comprador("t", "t", "t", 100.00));
            clist.add(new Comprador("a", "a", "a", 1000.00));
            cpersistence.save(clist);
        }
        
        TelaLogin login = new TelaLogin();
        login.desenha();
    }       
}


