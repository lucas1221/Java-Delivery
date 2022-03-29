import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
   
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
   
//actionlistener trata do tratamento de eventos
public class JanelaPrincipal extends JFrame  implements ActionListener
{
        //barra de menus com aquelas quatro opções
        private JMenuBar barraMenus;
           
        //opções de menu
        private JMenu menuPedido;
        private JMenu menuCliente;
        private JMenu menuEntregador;
        private JMenu menuProduto;
           
        //criação de novos
        private JMenuItem itemNovoPedido;
        private JMenuItem itemNovoCliente;
        private JMenuItem itemNovoProduto;
        private JMenuItem itemNovoEntregador;
   
        private JMenuItem itemBuscaCliente;
        private JMenuItem itemBuscaProduto;
        private JMenuItem itemBuscaPedido;
        private JMenuItem itemBuscaEntregador;
   
        private JMenuItem itemListarCliente;
        private JMenuItem itemListarProduto;
        private JMenuItem itemListarPedido;
        private JMenuItem itemListarEntregador;
           
                
          
        private List<Pessoa> listaDePessoas;
        private List<Produto> listaDeProdutos;
        private List<Pedido> listaDePedidos;
                
        //construtor
        public JanelaPrincipal(List<Pessoa> listaDePessoas, List<Produto> listaDeProdutos, List<Pedido> listaDePedidos)
        {
            this.listaDePessoas = listaDePessoas;
            this.listaDeProdutos = listaDeProdutos;
            this.listaDePedidos = listaDePedidos;
               
            barraMenus = new JMenuBar ();
            menuPedido =  new JMenu ("Pedido");
            menuProduto =  new JMenu ("Produto");
            menuCliente =  new JMenu ("Cliente");
            menuEntregador =  new JMenu ("Entregador");
            itemNovoPedido =  new JMenuItem ("Novo");
            itemNovoProduto =  new JMenuItem ("Novo");
            itemNovoCliente =  new JMenuItem ("Novo");
            itemNovoEntregador =  new JMenuItem ("Novo");
              
            itemBuscaCliente =  new JMenuItem ("Buscar");
            itemBuscaProduto =  new JMenuItem ("Buscar");
            itemBuscaPedido =  new JMenuItem ("Buscar");
            itemBuscaEntregador =  new JMenuItem ("Buscar");
  
            itemListarCliente =  new JMenuItem ("Listar");
            itemListarProduto =  new JMenuItem ("Listar");
            itemListarPedido =  new JMenuItem ("Listar");
            itemListarEntregador =  new JMenuItem ("Listar");
  
              
            barraMenus.add(menuPedido);
            barraMenus.add(menuCliente);
            barraMenus.add(menuEntregador);
            barraMenus.add(menuProduto);
               
            menuPedido.add(itemNovoPedido);
            menuEntregador.add(itemNovoEntregador);
            menuProduto.add(itemNovoProduto);
            menuCliente.add(itemNovoCliente);
              
            menuCliente.add(itemBuscaCliente);
            menuPedido.add(itemBuscaPedido);
            menuProduto.add(itemBuscaProduto);
            menuEntregador.add(itemBuscaEntregador);
              
            menuCliente.add(itemListarCliente);
            menuPedido.add(itemListarPedido);
            menuProduto.add(itemListarProduto);
            menuEntregador.add(itemListarEntregador);
               
            itemNovoCliente.addActionListener(this);
            itemNovoEntregador.addActionListener(this);
            itemNovoPedido.addActionListener(this);
            itemNovoProduto.addActionListener(this);
              
            itemBuscaCliente.addActionListener(this);
            itemBuscaEntregador.addActionListener(this);
            itemBuscaPedido.addActionListener(this);
            itemBuscaProduto.addActionListener(this);
              
            itemListarCliente.addActionListener(this);
            itemListarEntregador.addActionListener(this);
            itemListarPedido.addActionListener(this);
            itemListarProduto.addActionListener(this);
               
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLayout(new FlowLayout());
            this.setJMenuBar(barraMenus); 
            this.pack();
            this.setResizable(false);
            this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
            this.setVisible(true);
            this.setTitle("Sabborozza Pizzaria");
            this.setSize(450,250);
           
             
        }
   
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == itemNovoCliente)
            {
                JanelaNovoCliente n = new JanelaNovoCliente(listaDePessoas); 
            }
               
            if(e.getSource() == itemNovoEntregador)
            {
                JanelaNovoEntregador n = new JanelaNovoEntregador(listaDePessoas); 
            }
               
            else if(e.getSource() == itemBuscaCliente)
            {
                JanelaBuscarCliente n = new JanelaBuscarCliente();
            }
              
            else if(e.getSource() == itemNovoProduto)
            {
                JanelaNovoProduto n = new JanelaNovoProduto(listaDeProdutos); 
            }
              
            else if(e.getSource() == itemNovoPedido)
            {
                JanelaNovoPedido n = new JanelaNovoPedido(listaDePedidos); 
            }
             
            else if(e.getSource() == itemBuscaPedido)
            {
                JanelaBuscarPedido n = new JanelaBuscarPedido();
            }
             
            else if(e.getSource() == itemBuscaProduto)
            {
                JanelaBuscarProduto n = new JanelaBuscarProduto();
            }
             
            else if(e.getSource() == itemBuscaEntregador)
            {
                JanelaBuscarEntregador n = new JanelaBuscarEntregador();
            }
              
            else if(e.getSource() == itemListarProduto)
            {
                JanelaListarProduto n = new JanelaListarProduto();
            }
            
             else if(e.getSource() == itemListarPedido)
            {
                JanelaListarPedido n = new JanelaListarPedido();
            }
            
             else if(e.getSource() == itemListarCliente)
            {
                JanelaListarCliente n = new JanelaListarCliente();
            }
            
             else if(e.getSource() == itemListarEntregador)
            {
                JanelaListarEntregador n = new JanelaListarEntregador();
            }
        }    
          
}