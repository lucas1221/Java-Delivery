/*Essa janela busca um pedido a partir do CPF digitado e abre
outra janela para atualização ou remoção dos dados deste mesmo
pedido.
*/
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
 
 
public class JanelaBuscarPedido extends JFrame implements ActionListener
{
    private Container janelita;
    private JButton btBuscar;
    private JTextField tfPedido;
    private JLabel lPedido;
            
    public JanelaBuscarPedido()
    {  
        
        this.setLayout(new FlowLayout());
        this.pack();
        this.setResizable(false);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        this.setVisible(true);
        this.setTitle("Buscar Pedido");
        this.setSize(290,120);
             
                tfPedido = new JTextField(10);     
                lPedido = new JLabel ("Código do Pedido: ");
         
                btBuscar = new JButton ("Buscar");
                btBuscar.addActionListener(this);
         
         
                janelita = this.getContentPane();
                janelita.add(lPedido);
                janelita.add(tfPedido);
                janelita.add(btBuscar);                
            }
 
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == btBuscar)
        {           
           busque(tfPedido.getText());
        }
    }
    
    //Essa função busca um pedido a partir do código digitado e, caso retorne uma busca verdadeira
   //abre uma nova janela para atualização de dados
    public void busque (String codigo)
    {
        boolean encontrou = false;
        String Codigo;
        int aux = 0;
        for(int i = 0; !encontrou && i < SistemaEntrega.listaDePedidos.size(); i++) 
        {
            Codigo = Integer.toString(SistemaEntrega.listaDePedidos.get(i).getCodigo_pedido());
            if(Codigo.equals(codigo)) 
            {
                    encontrou = true;           
                    aux = i;
            }
        }
          
          
        if(!encontrou)
        {
            JOptionPane.showMessageDialog(this, "Pedido não Encontrado!");
            return;
        }
        
        else
        {
            JanelaAtualizarPedido n = new JanelaAtualizarPedido(aux);
        }
    }
}