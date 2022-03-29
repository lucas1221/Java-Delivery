/*Essa janela está intimamente ligada com JanelaBuscarProduto.java, que, de acordo com
a especificação do trabalho possui dois botões:
REMOVER -Remove produto da lista de produtos e
ALTERAR - Altera dados de um certo produto, obtido a partir de uma busca pelo código
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

public class JanelaAtualizaProduto extends JFrame implements ActionListener
{
    private Container container;
    
    //campos de texto
    private JTextField tfCodigo;
    private JTextField tfDescricao;
    private JTextField tfUnidadeEstoque;
    
    //descrição dos campos de textp
    private JLabel lCodigo;
    private JLabel lDescricao;
    private JLabel lUnidadeEstoque;
    
    //botões
    private JButton btAtualizar;
    private JButton btRemover;
    private int i;  
    
    public JanelaAtualizaProduto(int i)
    {
        this.i = i;
        this.setLayout(new FlowLayout());
        this.pack();
        this.setResizable(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); //ver todas as opções do JFrame
        this.setVisible(true);
        this.setTitle("Alterar Produto");
        this.setSize(600,600);
        
        tfCodigo = new JTextField(15);
        lCodigo = new JLabel("Codigo: ");   
            
        tfDescricao = new JTextField(30);		
        lDescricao = new JLabel ("Descrição: ");
            
        tfUnidadeEstoque = new JTextField(15);		
        lUnidadeEstoque= new JLabel ("Unidades no estoque: ");
        
        //Com isso as informações antigas do Produto são mostradas        
        tfCodigo.setText(Integer.toString(SistemaEntrega.listaDeProdutos.get(i).getCodigo()));
        tfDescricao.setText(SistemaEntrega.listaDeProdutos.get(i).getDescricao());
        tfUnidadeEstoque.setText(Integer.toString(SistemaEntrega.listaDeProdutos.get(i).getUnidade_Estoque()));
                     
        btAtualizar = new JButton ("Atualizar");
        btAtualizar.addActionListener(this);
		
        btRemover = new JButton ("Remover");
        btRemover.addActionListener(this);
	
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
            atualiza_produto();         
        }      
    }
    
    //Essa função remove um produto da lista a partir de um índice previamente passado
    //pela janela de atualização
    private void remove_produto()
    {
        Produto elemento = SistemaEntrega.listaDeProdutos.remove(i); 
        JOptionPane.showMessageDialog(this, "Produto removido com sucesso!");
        limpar();
    }
    
    //Essa função atualiza um produto da lista a partir de um índice previamente passado
    //pela janela de atualização. Primeiro ele verifica se os campos não estão vazios, ou seja
    //se não foram atualizados. Caso contrário, ele verifica se os campos estão certos antes
    //de atualizar na lista de produtos.
    private void atualiza_produto()           
    {        
        if(!tfCodigo.getText().equals(""))
        {
            if(RoverNumber.ehInteiro(tfCodigo.getText()))
            {
                    SistemaEntrega.listaDeProdutos.get(i).setCodigo(Integer.valueOf(tfCodigo.getText()));
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
                SistemaEntrega.listaDeProdutos.get(i).setDescricao(tfDescricao.getText());
            
            else
            {
                JOptionPane.showMessageDialog(this, "Descrição inválido!");
                return;
            }
        }    
          
        if(!tfUnidadeEstoque.getText().equals(""))
        {
            if(RoverNumber.ehInteiro(tfUnidadeEstoque.getText()))
                      SistemaEntrega.listaDeProdutos.get(i).setUnidade_Estoque(Integer.valueOf(tfUnidadeEstoque.getText()));
            
            else
            {
                JOptionPane.showMessageDialog(this, "Número de Unidades de Estoque inválido!");
                return;
            }
        }
        
               
        JOptionPane.showMessageDialog(this, "Produto atualizado com sucesso!");
    }
    
    //Essa função limpa os campos de texto
    private void limpar()
    {
        tfCodigo.setText("");
        tfDescricao.setText("");
        tfUnidadeEstoque.setText("");
    }
    
    
}
