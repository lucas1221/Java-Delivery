/*Esse código é responsável por adicionar certo Produto à um Pedido
Por meio dele, é digitado o código de certo produto e possui dois botões:
ADICIONAR - que adiciona um produto à um pedido e
CADASTRAR - que, após ter produtos adicionados ao pedido, cadastra de fato esse 
pedido na lista
*/
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class JanelaAdicionarProduto extends JFrame implements ActionListener
{
        //campos de texto
        private JTextField tfcodigo_produto;
        private JLabel lcodigo_produto;
        
        //descrições de cada campo
        private JTextField tfquantidade_produto;
        private JLabel lquantidade_produto;

        //botões
        private Container container;
        private JButton btCadastrar;
        private JButton btAdicionar;
        private JButton btLimpar;
        private int i;
        
        public JanelaAdicionarProduto(int i)
        {   
                this.i = i;
               
                this.setLayout(new FlowLayout());
                this.pack();
                this.setResizable(true);
                this.setExtendedState(JFrame.MAXIMIZED_BOTH);
                this.setVisible(true);
                this.setTitle("Adicionar Produto");
                this.setSize(350,350);

                tfcodigo_produto = new JTextField(15);
                lcodigo_produto = new JLabel("Código do Produto: ");

                tfquantidade_produto = new JTextField(10);
                lquantidade_produto = new JLabel("Quantidade do Produto: ");

                btCadastrar = new JButton("Finalizar Pedido");
                btCadastrar.addActionListener(this);

                btAdicionar = new JButton("Adicionar Produto");
                btAdicionar.addActionListener(this);
                
                btLimpar = new JButton("Limpar");
                btLimpar.addActionListener(this);
 
                container = this.getContentPane(); 
                container.add(lcodigo_produto);
                container.add(tfcodigo_produto);
                container.add(lquantidade_produto);
                container.add(tfquantidade_produto);
                container.add(btCadastrar);
                container.add(btAdicionar);
                container.add(btLimpar);
          
        }        

                public void actionPerformed(ActionEvent e) {    
                        if(e.getSource() == btCadastrar)
                        {
                                validar();  
                        }
                        
                        else if(e.getSource() == btLimpar)
                        {
                                limpar();  
                        }
                        
                        else if(e.getSource() == btAdicionar)
                        {
                                adiciona_produto();  
                        }
                }
                
//essa função limpa os campos de texto    
private void limpar()
{        
    tfcodigo_produto.setText("");
    tfquantidade_produto.setText("");
}   


//Esta função aqui apenas valida o que adiciona_produto() faz em um pedido.
//Caso não se insira nenhum produto à um pedido, ele indicará erro, pedindo para adicionar
//ao menos, um produto ao pedido. Senão, ele termina de cadastrar o pedido
 private void validar()
 {
     if(SistemaEntrega.listaDePedidos.get(i).getListinha().size() == 0)                  
            JOptionPane.showMessageDialog(this, "Adicione Produto(s) ao pedido!");
     else
     {    
        JOptionPane.showMessageDialog(this, "Pedido cadastado com sucesso!");
        this.dispose();
     }   
 }

 //Essa função é a responsável por adicionar um produto à um pedido. Ela funciona da
 //seguinte forma: primeiro ela confere se os campos foram completados e os valida.
 //Caso tudo esteja certo, a partir do código do produto digitado, ela procura, na lista
 //de produtos, se esse produto realmente existe. Caso exista, subtrai a quantidade disponível
 //no estoque pela quantidade pedida por um cliente. Caso o valor seja menor que zero, ou seja,
 //se a quantidade de unidades que um cliente pediu for maior que a quantidade disponível, ele 
 //anunciará erro. Caso contrário, ela insere o produto na lista daquele pedido.
       private void adiciona_produto()
      {         
          if(tfcodigo_produto.getText().equals(""))
          {
              JOptionPane.showMessageDialog(this, "Por favor, digite um código!");
              return;
          }
          
          if(tfquantidade_produto.getText().equals(""))
          {
              JOptionPane.showMessageDialog(this, "Por favor, digite uma quantidade!");
              return;
          }
         
          else
          {              
              if(!RoverNumber.ehInteiro(tfcodigo_produto.getText()))
              {
                    JOptionPane.showMessageDialog(this, "Código Inválido!");
                    return;
              }
              
              if(!RoverNumber.ehInteiro(tfquantidade_produto.getText()))
              {
                    JOptionPane.showMessageDialog(this, "Quantidade Inválida!");
                    return;
              }
              
               
              else
              {
                    int busca = busca_produto(tfcodigo_produto.getText());
                    
                    if(busca != -1) 
                    {     
                             if(SistemaEntrega.listaDeProdutos.get(busca).getUnidade_Estoque() > 0)
                             {    
                                 int aux = Integer.valueOf(tfquantidade_produto.getText());
                                 if((SistemaEntrega.listaDeProdutos.get(busca).getUnidade_Estoque() - aux) >= 0)
                                 { 
                                      Produto n = new Produto(SistemaEntrega.listaDeProdutos.get(busca).getCodigo(), SistemaEntrega.listaDeProdutos.get(busca).getDescricao(), (SistemaEntrega.listaDeProdutos.get(busca).getUnidade_Estoque()-SistemaEntrega.listaDeProdutos.get(busca).getUnidade_Estoque())+aux);
                                      SistemaEntrega.listaDePedidos.get(i).getListinha().add(n);
                                      SistemaEntrega.listaDeProdutos.get(busca).setUnidade_Estoque(SistemaEntrega.listaDeProdutos.get(busca).getUnidade_Estoque()-aux);
                                      JOptionPane.showMessageDialog(this, "Produto adicionado com Sucesso!");
                                      limpar();
                                 }
                                 
                                 else
                                 {
                                      JOptionPane.showMessageDialog(this, "A quantidade pedida excede a quantidade disponível desse produto!");
                                      return;
                                 }
                            }      
                   
                            else
                            {
                                      JOptionPane.showMessageDialog(this, "Quantidade de Unidades desse Produto já está esgotada!");
                            }    
                    } 
          
                    else
                            JOptionPane.showMessageDialog(this, "Produto não Encontrado!");
              }               
          }          
    }
          
    //Essa função busca por um produto na lista de produtos, a partir de um código e confere se
    //tal produto existe, de fato, no sistema
      private int busca_produto(String codigo)
      {
          boolean encontrou = false;
          int codigo_inteiro = Integer.valueOf(codigo);
          int aux = -1;
          for(int i = 0; !encontrou && i < SistemaEntrega.listaDeProdutos.size(); i ++)
          {
                if(codigo_inteiro == SistemaEntrega.listaDeProdutos.get(i).getCodigo())
                {
                            encontrou = true;
                            aux = i;
                }
          }
          
               return aux; 
      }    
      
}      

    
      