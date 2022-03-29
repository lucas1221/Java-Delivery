/*Essa janela está intimamente ligada com JanelaAtualizarProdutoPedido.java, na 
qual se procura um certo produto por um código e tem m campo de quantidade junto
e apresenta, também, duas opções:
Caso se deseje adicionar um novo produto ao pedido, deve-se passar o código do produto,
a quantidade, e clicar em ADICIONAR
Senão, caso se deseje atualizar um produto de um pedido, só é necessário passar o código.
A quantidade não é necessária, mas caso passe, a nova janela a ser aberta mostrará essa 
quantidade nova que foi digitada.
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

public class JanelaModificarProduto extends JFrame implements ActionListener
{
    private Container container;
    
    //campos de texto
    private JTextField tfCodigo;
    private JTextField tfQuantidade;
    
    //descrição dos campos de texto
    private JLabel lCodigo;
    private JLabel lQuantidade;
    
    //botões
    private JButton btAtualizar;
    private JButton btAdicionar;
    private int i;  
   
    
    public JanelaModificarProduto(int i)
    {
        this.i = i;
        this.setLayout(new FlowLayout());
        this.pack();
        this.setResizable(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
        this.setTitle("Alterar/Adicionar Produto");
        this.setSize(600,600);
        
        tfCodigo = new JTextField(15);
        lCodigo = new JLabel("Código do Produto: ");   
            
        tfQuantidade = new JTextField(15);
        lQuantidade = new JLabel("Quantidade do Produto: ");   
                     
        btAtualizar = new JButton ("Atualizar Produto");
        btAtualizar.addActionListener(this);
		
        btAdicionar = new JButton ("Adicionar Produto");
        btAdicionar.addActionListener(this);
	
       
	
        container = this.getContentPane();  
        container.add(lCodigo);
        container.add(tfCodigo);
        container.add(lQuantidade);
        container.add(tfQuantidade);        
        container.add(btAtualizar);
        container.add(btAdicionar);                      
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
       if(e.getSource() == btAtualizar)
        {            
            atualiza_produto(tfQuantidade.getText());         
        }      
         
         else if(e.getSource() == btAdicionar)
        {            
            adiciona_produto(i, tfCodigo.getText(), tfQuantidade.getText());         
        }        
    }
    
   
    //Essa função atualiza os dados de certo produto nesse certo pedido, após todas
    //as verificações e validações serem feitas.
    private void atualiza_produto(String Quantidade)           
    {        
        if(Quantidade.equals(""))
        {   }    
        
        else
        {
            if(!RoverNumber.ehInteiro(Quantidade))
            {    
                JOptionPane.showMessageDialog(this, "Quantidade inválida!");
                return;
            }    
        }    
        if(!tfCodigo.getText().equals(""))
        {
            if(RoverNumber.ehInteiro(tfCodigo.getText()))
            {    
                boolean encontrou = false;
                for(int j = 0; !encontrou && j < SistemaEntrega.listaDePedidos.get(i).getListinha().size(); j++)
                {
                    if(Integer.toString(SistemaEntrega.listaDePedidos.get(i).getListinha().get(j).getCodigo()).equals(tfCodigo.getText()))
                    {
                        encontrou = true;                        
                        JanelaAtualizaProdutoPedido n = new JanelaAtualizaProdutoPedido(i,j, Quantidade, tfCodigo.getText());
                    }        
                }
                
                if(!encontrou)
                    JOptionPane.showMessageDialog(this, "Produto não encontrado na lista deste Pedido!");
            }
            
            else
            {
                JOptionPane.showMessageDialog(this, "Número de código inválido!");
                return;
            }
        }
        
        else
        {
            JOptionPane.showMessageDialog(this, "Por favor, insira um código!");
                return;
        }    
    }
    
    //Essa função adiciona certo produto nesse certo pedido, após todas
    //as verificações e validações serem feitas.
    private void adiciona_produto(int i, String Codigo, String Quantidade)
    {   
        boolean encontrou = false;
        String Aux;
        int aux = 0;
        for(int j = 0; !encontrou && j < SistemaEntrega.listaDeProdutos.size(); j++) 
        {
            Aux = Integer.toString(SistemaEntrega.listaDeProdutos.get(j).getCodigo());
            if(Aux.equals(Codigo)) 
            {
                encontrou = true;           
                aux = j;
            }
        }
        
        if(encontrou)
        {
            if(RoverNumber.ehInteiro(Quantidade))
            {    
                if(SistemaEntrega.listaDeProdutos.get(aux).getUnidade_Estoque()-(Integer.valueOf(Quantidade)) >= 0)
                {
                        SistemaEntrega.listaDePedidos.get(i).getListinha().add(SistemaEntrega.listaDeProdutos.get(aux));
                        SistemaEntrega.listaDeProdutos.get(aux).setUnidade_Estoque(SistemaEntrega.listaDeProdutos.get(aux).getUnidade_Estoque()-(Integer.valueOf(Quantidade)));
                        JOptionPane.showMessageDialog(this, "Produto adicionado com suceso!");
                }
                
                else
                         JOptionPane.showMessageDialog(this, "A quantidade pedida excede a quantidade disponível desse produto!");
            }
            
            else
            {
                JOptionPane.showMessageDialog(this, "Quantidade Inválida!");
                return;
            }    
            
        }
        
        else
            JOptionPane.showMessageDialog(this, "Produto não encontrado!");
    }
    
    
    
    
    
    
    private void limpar()
    {
        tfCodigo.setText("");
        tfQuantidade.setText("");        
    }
    
    
}

  