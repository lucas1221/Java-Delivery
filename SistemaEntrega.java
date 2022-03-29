import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaEntrega {
  
    static JanelaPrincipal janelaPrincipal;
    static LerClientes lerClientes;
    static LerEntregadores lerEntregadores;
    static LerProdutos lerProdutos;
    /**
     * @param args
     */
    static public List<Pessoa> listaDePessoas; 
    static public List<Produto> listaDeProdutos; 
    static public List<Pedido> listaDePedidos; 
      
    public static void main(String[] args) 
    {
        listaDePessoas = new ArrayList(); 
        listaDeProdutos = new ArrayList(); 
        listaDePedidos = new ArrayList(); 
        
        lerClientes = new LerClientes();
        lerProdutos = new LerProdutos();
        lerEntregadores = new LerEntregadores();
         
        janelaPrincipal = new JanelaPrincipal(listaDePessoas, listaDeProdutos, listaDePedidos);         
            
    }  
      
  
}