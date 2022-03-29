/*Essa janela busca um produto a partir do CPF digitado e abre
outra janela para atualização ou remoção dos dados deste mesmo
produto.
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
  
  
public class JanelaBuscarProduto extends JFrame implements ActionListener
{
    private Container janelita;
    private JButton btBuscar;
    private JTextField tfcodigo;
    private JLabel lcodigo;
      
         
          
    public JanelaBuscarProduto()
    {
        this.setLayout(new FlowLayout());
        this.pack();
        this.setResizable(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        this.setVisible(true);
        this.setTitle("Buscar Produto");
        this.setSize(290,120);
              
              
                tfcodigo = new JTextField(10);     
                lcodigo = new JLabel ("Código do produto: ");
          
                btBuscar = new JButton ("Buscar");
                btBuscar.addActionListener(this);
          
          
                janelita = this.getContentPane(); 
                janelita.add(lcodigo);
                janelita.add(tfcodigo);
                janelita.add(btBuscar);                
            }
  
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == btBuscar)
        {          
           busque(tfcodigo.getText());
        }
    }
    
    //Essa função busca um produto a partir do código digitado e, caso retorne uma busca verdadeira
   //abre uma nova janela para atualização de dados
    public void busque (String codigo)
    {
        boolean encontrou = false;
        String Codigo;
        int aux = 0;
        for(int i = 0; !encontrou && i < SistemaEntrega.listaDeProdutos.size(); i++) 
        {
            Codigo = Integer.toString(SistemaEntrega.listaDeProdutos.get(i).getCodigo());
            if(Codigo.equals(codigo))
            {
                encontrou = true;           
                aux = i;
            }
        }
          
          
        if(!encontrou)
        {
            JOptionPane.showMessageDialog(this, "Produto não Encontrado!");
            return;
        }
        
        else
        {
            JanelaAtualizaProduto n = new JanelaAtualizaProduto(aux);
        }
    }
           
 }