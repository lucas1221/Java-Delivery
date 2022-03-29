/*Essa janela está intimamente ligada com JanelaModificarProduto.java, que, de acordo com
a especificação do trabalho possui dois botões:
REMOVER -Remove produto da lista de produtos do pedido e
ALTERAR - Altera dados de um certo produto de certo pedido, obtido a partir de uma busca pelo código
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

public class JanelaAtualizaProdutoPedido extends JFrame implements ActionListener
{
    private Container container;
    
    //campos de texto
    private JTextField tfCodigo;
    private JTextField tfDescricao;
    private JTextField tfUnidadeEstoque;
    
    //descrição dos campos de texto
    private JLabel lCodigo;
    private JLabel lDescricao;
    private JLabel lUnidadeEstoque;
    
    //botões
    private JButton btAtualizar;
    private JButton btRemover;
    
    //informações especiais a serem chamadas para atualização
    private int i;
    private int j;
    private String Quantidade;
    private String Codigo;
    
    public JanelaAtualizaProdutoPedido(int i, int j, String Quantidade, String Codigo)
    {
        this.Quantidade = Quantidade;
        this.Codigo = Codigo;
        this.i = i;
        this.j = j;
        this.setLayout(new FlowLayout());
        this.pack();
        this.setResizable(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        this.setVisible(true);
        this.setTitle("Alterar Produto");
        this.setSize(600,600);
               
        tfCodigo = new JTextField(15);
        lCodigo = new JLabel("Codigo: ");   
            
        tfDescricao = new JTextField(30);		
        lDescricao = new JLabel ("Descrição: ");
            
        tfUnidadeEstoque = new JTextField(15);		
        lUnidadeEstoque= new JLabel ("Unidades no estoque: ");      
        
        //com isso as informações antigas de certo produto de um certo pedido são mostradas
        tfCodigo.setText(Integer.toString(SistemaEntrega.listaDePedidos.get(i).getListinha().get(j).getCodigo()));
        tfDescricao.setText(SistemaEntrega.listaDePedidos.get(i).getListinha().get(j).getDescricao());
        if(Quantidade.equals(""))            
            tfUnidadeEstoque.setText(Integer.toString(SistemaEntrega.listaDePedidos.get(i).getListinha().get(j).getUnidade_Estoque()));
        
        else
        {   
            SistemaEntrega.listaDePedidos.get(i).getListinha().get(j).setUnidade_Estoque(Integer.valueOf(Quantidade));
            tfUnidadeEstoque.setText(Quantidade);
        }    
        
        btRemover = new JButton ("Remover Produto");
        btRemover.addActionListener(this);
        
        btAtualizar = new JButton("Alterar Produto"); 
        btAtualizar.addActionListener(this);
                
        container = this.getContentPane();  
        container.add(lCodigo);
        container.add(tfCodigo);     
        container.add(lDescricao);
        container.add(tfDescricao);
        container.add(lUnidadeEstoque);
        container.add(tfUnidadeEstoque);
        container.add(btAtualizar);
        container.add(btRemover);            
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btRemover)
        {
            remove_produto();          
        }
        
        else if(e.getSource() == btAtualizar)
        {             
            atualizar_produto();
        }
    }
    
    //Essa função atualiza as informações de certo produto de certo pedido, após verificar e validar
    //os campos de texto.
    private void atualizar_produto()
    {        
        if(!tfCodigo.getText().equals(""))
        {
            if(RoverNumber.ehInteiro(tfCodigo.getText()))
            {
                SistemaEntrega.listaDePedidos.get(i).getListinha().get(j).setCodigo(Integer.valueOf(tfCodigo.getText()));
            } 
            
            else
            {
                JOptionPane.showMessageDialog(this, "Número de código inválido!");
                return;
            }
        }
            
        
        if(!tfDescricao.getText().equals(""))
        {
            if(RoverNumber.ehString(tfDescricao.getText()))
                SistemaEntrega.listaDePedidos.get(i).getListinha().get(j).setDescricao(tfDescricao.getText());
            
            else
            {
                JOptionPane.showMessageDialog(this, "Descrição inválido!");
                return;
            }
        }    
          
        if(!tfUnidadeEstoque.getText().equals(""))
        {
            if(RoverNumber.ehInteiro(tfUnidadeEstoque.getText()))
            {
                int aux = busca_produto(Codigo);
                if(SistemaEntrega.listaDeProdutos.get(aux).getUnidade_Estoque() - (Integer.valueOf(tfUnidadeEstoque.getText())) >= 0)
                     SistemaEntrega.listaDePedidos.get(i).getListinha().get(j).setUnidade_Estoque(Integer.valueOf(tfUnidadeEstoque.getText()));
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Número de Unidades de Estoque inválido!");
                return;
            }
        }
               
        JOptionPane.showMessageDialog(this, "Produto atualizado com sucesso!");
    }
        
    //Essa função é responsável por remover certo produto de certa lista de produtos de certo pedido, 
    //a partir da busca de um índice previamente passado pela janela de atualização
    private void remove_produto()
    {
        Produto elemento = SistemaEntrega.listaDePedidos.get(i).getListinha().remove(j); //remove serve pra List, removeElementAt não
        JOptionPane.showMessageDialog(this, "Produto removido com sucesso!");
        limpar();
    }

   //limpa os campos de texto 
    private void limpar()
    {
        tfCodigo.setText("");
        tfDescricao.setText("");
        tfUnidadeEstoque.setText(""); 
    }
    
    //Essa função está intimamente ligada com o atualizar_produto(), no qual ele busca certo
    //produto da lista de produtos com um código passado e repassa o índice. Isso é necessário
    //para atualizar a quantidade disponível daquele produto para um futuro pedido.
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



