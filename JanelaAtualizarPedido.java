/*Essa janela está intimamente ligada com JanelaBuscarPedido.java, que, de acordo com
a especificação do trabalho possui os dois botões:
REMOVER -Remove pedidos da lista de pedidos e
ALTERAR - Altera dados de um certo pedido, obtido a partir de uma busca pelo código

E mais alguns, necessários para atualização dos produtos daquele pedido
LISTAR_PRODUTO - Abre uma janela que lista os produtos daquele pedido
ATUALIZAR_PRODUTO - Abre uma janela que busca um produto pelo código e dá duas opções:
    *Atualizar: ou seja, procura aquele produto na lista de produtos desse pedido e dá
                a opção de alterar os dados e;
    *Adiconar: ou seja, procura aquele produto na lista de produtos e adiciona a lista de produtos
                desse pedido.
CANCELAR_PEDIDO - Remove pedido da lista de pedidos e todas as quantidades de certos produtos pedidos
são atualizados na lista de pedido
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

public class JanelaAtualizarPedido extends JFrame implements ActionListener
{
    private Container container;
    
    //campos de texto
    private JTextField tfValor;
    private JTextField tfTroco;
    private JTextField tfStatus;
    private JTextField tfCliente;
    private JTextField tfEntregador;
    private JTextField tfCodigo_Pedido;
    
    //descrições dos campos de texto
    private JLabel lValor;
    private JLabel lTroco;
    private JLabel lStatus;
    private JLabel lCliente;
    private JLabel lEntregador;
    private JLabel lCodigo_Pedido;
    
    //botões
    private JButton btListar_Produto;
    private JButton btAtualizar;
    private JButton btRemover;
    private JButton btCancelarPedido;
    private JButton btAtualizarProduto;
    private int i;
    
        public JanelaAtualizarPedido(int i)
        {
            this.i = i;
            this.setLayout(new FlowLayout());
            this.pack();
            this.setResizable(true);
            this.setExtendedState(JFrame.MAXIMIZED_BOTH);
            this.setVisible(true);
            this.setTitle("Alterar Pedido");
            this.setSize(600,600);
                
            tfValor = new JTextField(10);
            lValor = new JLabel("Valor: ");   
            
            tfTroco = new JTextField(10);		
            lTroco = new JLabel ("Troco: ");
            
            tfStatus = new JTextField(30);		
            lStatus = new JLabel ("Status: ");
            
            tfCliente = new JTextField(40);		
            lCliente = new JLabel ("Cliente: ");
            
            tfEntregador = new JTextField(40);		
            lEntregador = new JLabel ("Entregador: ");
         
            tfCodigo_Pedido = new JTextField(15);		
            lCodigo_Pedido = new JLabel ("Código do Pedido: ");
    
            btListar_Produto = new JButton ("Listar Produto");
            btListar_Produto.addActionListener(this);
	
            btAtualizar = new JButton ("Atualizar Pedido");
            btAtualizar.addActionListener(this);
            
            btAtualizarProduto = new JButton ("Atualizar Produto");
            btAtualizarProduto.addActionListener(this);
		
            btRemover = new JButton ("Remover");
            btRemover.addActionListener(this);
            
            btCancelarPedido = new JButton ("Cancelar Pedido");
            btCancelarPedido.addActionListener(this);
	
            //Mostra os valores antigos desse pedido
            tfValor.setText(Double.toString(SistemaEntrega.listaDePedidos.get(i).getValor()));
            tfTroco.setText(Double.toString(SistemaEntrega.listaDePedidos.get(i).getTroco()));
            tfStatus.setText(SistemaEntrega.listaDePedidos.get(i).getStatus());
            tfCliente.setText(SistemaEntrega.listaDePedidos.get(i).getCliente());
            tfEntregador.setText(SistemaEntrega.listaDePedidos.get(i).getEntregador());
            tfCodigo_Pedido.setText(Integer.toString(SistemaEntrega.listaDePedidos.get(i).getCodigo_pedido()));
            
            container = this.getContentPane();  
            container.add(lValor);
            container.add(tfValor);
            container.add(lTroco);
            container.add(tfTroco);
            container.add(lStatus);
            container.add(tfStatus);
            container.add(lCliente);
            container.add(tfCliente);
            container.add(lEntregador);
            container.add(tfEntregador);
            container.add(lCodigo_Pedido);
            container.add(tfCodigo_Pedido);            
            container.add(btAtualizar);
            container.add(btListar_Produto);
            container.add(btAtualizarProduto);
            container.add(btRemover); 
            container.add(btCancelarPedido); 
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btRemover)
        {
                remove_pedido();
        }       
      
     else if(e.getSource() == btAtualizar)
        {            
            atualiza_pedido();         
        }
        
    else if(e.getSource() == btListar_Produto)
        {            
            listar_produto(i);
        }
     
    else if(e.getSource() == btCancelarPedido)    
    {
        cancelar_pedido(i);
    }
        
         else if(e.getSource() == btAtualizarProduto)    
         {
             JanelaModificarProduto n = new JanelaModificarProduto(i);
         }
    }
    
    //Essa função remove um pedido da lista a partir de um índice previamente passado
    //pela janela de atualização
    private void remove_pedido()
    {
        Pedido elemento = SistemaEntrega.listaDePedidos.remove(i); //remove serve pra List, removeElementAt não
        JOptionPane.showMessageDialog(this, "Pedido removido com sucesso!");
        limpar();
    }
    
    //Essa função atualiza um pedido da lista a partir de um índice previamente passado
    //pela janela de atualização. Primeiro ele verifica se os campos não estão vazios, ou seja
    //se não foram atualizados. Caso contrário, ele verifica se os campos estão certos antes
    //de atualizar na lista de pedidos.
    private void atualiza_pedido()
    {             
            tfCodigo_Pedido.setText(Integer.toString(SistemaEntrega.listaDePedidos.get(i).getCodigo_pedido()));
            
        if(!tfValor.getText().equals(""))
        {
            if(RoverNumber.ehDouble(tfValor.getText()))
                SistemaEntrega.listaDePedidos.get(i).setValor(Double.valueOf(tfValor.getText()));
            
            else
            {
                JOptionPane.showMessageDialog(this, "Valor inválido!");
                return;
            }
        }    
        
        if(!tfTroco.getText().equals(""))
        {
            if(RoverNumber.ehDouble(tfTroco.getText()))
                 SistemaEntrega.listaDePedidos.get(i).setTroco(Double.valueOf(tfTroco.getText()));
            
            else
            {
                JOptionPane.showMessageDialog(this, "Troco inválido!");
                return;
            }
        }    
          
        if(!tfStatus.getText().equals(""))
            SistemaEntrega.listaDePedidos.get(i).setStatus(tfStatus.getText());
        
        if(!tfCliente.getText().equals(""))
            SistemaEntrega.listaDePedidos.get(i).setCliente(tfCliente.getText());
        
        if(!tfEntregador.getText().equals(""))
            SistemaEntrega.listaDePedidos.get(i).setCliente(tfCliente.getText());
        
         if(!tfCodigo_Pedido.getText().equals(""))
         {
              if(RoverNumber.ehInteiro(tfCodigo_Pedido.getText()))
              {               
                        SistemaEntrega.listaDePedidos.get(i).setCodigo_pedido(Integer.valueOf(tfCodigo_Pedido.getText()));
              }   
              
              else
              {
                  JOptionPane.showMessageDialog(this, "Código de Pedido inválido!");
                  return;
              }
         }  
        
        JOptionPane.showMessageDialog(this, "Pedido atualizado com sucesso!");
    }
    
    //Essa função limpa os campos de texto
    private void limpar()
    {
        tfValor.setText("");
        tfTroco.setText("");
        tfStatus.setText("");
        tfCliente.setText("");
        tfEntregador.setText("");
        tfCodigo_Pedido.setText("");
    }
    
    //Essa função abre uma janela que lista os produtos desse pedido
    private void listar_produto(int i)
    {             
        JanelaListarProdutoPedido n = new JanelaListarProdutoPedido(i);
    }
    
    //Essa função remove esse pedido da lista de pedidos e tudo que ela
    //alterou retorna ao seu valor original antes dela ter alterado
    private void cancelar_pedido(int i)
    {
        for(int j = 0; j < SistemaEntrega.listaDeProdutos.size(); j++)
        {    
            for(int k = 0; k < SistemaEntrega.listaDePedidos.get(i).getListinha().size(); k++)
            {
                if(SistemaEntrega.listaDePedidos.get(i).getListinha().get(k).getDescricao().equals(SistemaEntrega.listaDeProdutos.get(j).getDescricao()))
                    SistemaEntrega.listaDeProdutos.get(j).setUnidade_Estoque(SistemaEntrega.listaDeProdutos.get(j).getUnidade_Estoque()+SistemaEntrega.listaDePedidos.get(i).getListinha().get(k).getUnidade_Estoque());
            }    
        }
        remove_pedido();
    }    
}