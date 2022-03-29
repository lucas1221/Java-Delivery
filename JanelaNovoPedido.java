/*Essa Janela adiciona um novo Pedido a lista de Pedidos*/
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
  
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
  
public class JanelaNovoPedido extends JFrame implements ActionListener
{
    private JTextField tfcodigo_pedido;
    private JLabel lcodigo_pedido;
    
    private JTextField tfvalor;
    private JLabel lvalor;
      
    private JTextField tftroco;
    private JLabel ltroco;
      
    private JTextField tfstatus;
    private JLabel lstatus;  
    
    private JTextField tfcliente;
    private JLabel lcliente;  
    
     private JTextField tfentregador;
     private JLabel lentregador;
      
    private JButton btLimpar;
    private JButton btAdicionar;
          
    private Container container;
      
    private List<Pedido> listaDePedidos;
    
    private List<Produto> list = new ArrayList<Produto>();
   
  
    public JanelaNovoPedido(List<Pedido> listaDePedidos)
    {
        this.listaDePedidos = listaDePedidos;
  
        this.setLayout(new FlowLayout());
        this.pack();
        this.setResizable(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        this.setVisible(true);
        this.setTitle("Novo Pedido");
        this.setSize(500,500);
          
        tfvalor = new JTextField(10);
        tftroco = new JTextField(15);
        tfstatus = new JTextField(35);
        tfcliente = new JTextField(35);
        tfentregador = new JTextField(35);
        tfcodigo_pedido = new JTextField(30);

        lvalor = new JLabel("Valor do Pedido: ");
        ltroco = new JLabel("Troco: ");
        lstatus = new JLabel("Status: ");
        lcliente = new JLabel("Cliente: ");
        lentregador = new JLabel("Entregador: ");
        lcodigo_pedido = new JLabel("Código do Pedido: ");
          
        btLimpar = new JButton("Limpar");
        btLimpar.addActionListener(this);
  
        btAdicionar = new JButton("Adicionar Produto");
        btAdicionar.addActionListener(this);
             
        container = this.getContentPane();
        container.add(lcodigo_pedido);
        container.add(tfcodigo_pedido);
        container.add(lvalor);
        container.add(tfvalor);
        container.add(ltroco);
        container.add(tftroco);
        container.add(lstatus);
        container.add(tfstatus);
        container.add(lcliente);
        container.add(tfcliente);
        container.add(lentregador);
        container.add(tfentregador);
        container.add(btLimpar);
        container.add(btAdicionar);
           
          
    }
 
     
  
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btAdicionar)
        {
        	validar();
  
        } 
        
            
        else if (e.getSource() == btLimpar)
                limpar();
    }
      
      //limpa campos de texto
      private void limpar()
        {
            tfvalor.setText("");
            tftroco.setText("");
            tfstatus.setText("");
            tfcliente.setText("");
            tfentregador.setText("");
            tfcodigo_pedido.setText("");          
             
        }
      
         //Essa função é a responsável por adicionar um novo pedido à uma lista de
         //pedidos. Ela valida código e os demais campos.    
         private void validar()
         {
        	 String t1 = tfstatus.getText();
        	 String t2 = tfcliente.getText();
                 String t3 = tfentregador.getText();
        	 String valor = tfvalor.getText();
        	 String troco = tftroco.getText(); 
                 String codigo = tfcodigo_pedido.getText();                  
        	 
        	  if(t1.equals("") || t2.equals("") || t3.equals("") || valor.equals("") || troco.equals(""))
        	  {
        		  JOptionPane.showMessageDialog(this, "Dados Incompletos!");
        	  }
        		   
        	  
        	  else
        	  {
                    //verifico valores
                      if(!RoverNumber.ehDouble(valor) || !RoverNumber.ehDouble(troco))
                      {
                            JOptionPane.showMessageDialog(this, "Valor e/ou Troco Inválido(s)!");
                            return;
                      }     
                      
                      if(!RoverNumber.ehInteiro(codigo))
                      {
                            JOptionPane.showMessageDialog(this, "Código Inválido!");
                            return;
                      }
                                            
                      //verifico também cliente e entregador
                      if(!RoverNumber.ehString(t2) || !RoverNumber.ehString(t3))
                      {
          			JOptionPane.showMessageDialog(this, "Entregador e/ou Cliente possui(em) nome(s) inválido(s)!");
                                return;
                      }         

                      else
                      {    
                        //agora verifico se cliente é válido
                         if(!RoverNumber.existeCliente(t2))
                         {
                              JOptionPane.showMessageDialog(this, "Cliente não encontrado no sistema!");
                              return;
                         }                             
                             
                         if(!RoverNumber.existeEntregador(t3))
                         {
                              JOptionPane.showMessageDialog(this, "Entregador não encontrado no sistema!");
                              return;
                         }
                         
                         else
                         {   
                             if(!RoverNumber.verificaCodPedidolista(Integer.valueOf(tfcodigo_pedido.getText())))
                                    JOptionPane.showMessageDialog(this, "Esse Código já Existe!");
                             else
                             {    
                                    double value = Double.valueOf(tfvalor.getText());
                                    double troquis = Double.valueOf(tftroco.getText());
                                    int codigo_pedido = Integer.valueOf(tfcodigo_pedido.getText());
                                    List<Produto> list = new ArrayList<Produto> ();
                                    Pedido novo = new Pedido(value, troquis, t1, t2, t3, list , codigo_pedido); 
                                                                                            
                                    SistemaEntrega.listaDePedidos.add(novo);
                                                        
                                    JanelaAdicionarProduto n = new JanelaAdicionarProduto(SistemaEntrega.listaDePedidos.size()-1);                                  
                                                           
                                    limpar();
                             }        
                         }
                      }
        	  }
        	 
         } 
}         