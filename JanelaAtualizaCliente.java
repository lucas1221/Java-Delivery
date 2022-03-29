/*Essa janela está intimamente ligada com JanelaBuscarCliente.java, que, de acordo com
a especificação do trabalho possui dois botões:
REMOVER -Remove cliente da lista de clientes e
ATUALIZAR - Altera dados de um certo cliente, obtido a partir de uma busca pelo CPF
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

public class JanelaAtualizaCliente extends JFrame implements ActionListener
{
    private Container container;
    //campos de texto
    private JTextField tfNome;
    private JTextField tfCPF;
    private JTextField tfEndereco;
    
    //descrições dos campos de texto
    private JLabel lNome;
    private JLabel lCPF;
    private JLabel lEndereco;
    
    //botões
    private JButton btAtualizar;
    private JButton btRemover;
    private int i;
    
        public JanelaAtualizaCliente(int i)
        {
            this.i = i;
            this.setLayout(new FlowLayout());
            this.pack();
            this.setResizable(true);
            this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
            this.setVisible(true);
            this.setTitle("Alterar Cliente");
            this.setSize(600,600);
            
            tfNome = new JTextField(40);
            lNome = new JLabel("Nome: ");   
            
            tfCPF = new JTextField(15);		
            lCPF = new JLabel ("Cpf: ");
            
            tfEndereco = new JTextField(60);		
            lEndereco = new JLabel ("Endereco: ");
            
            //Com isso os dados antigos do cliente são mostrados
            tfNome.setText(SistemaEntrega.listaDePessoas.get(i).getNome());
            tfCPF.setText(SistemaEntrega.listaDePessoas.get(i).getCpf());
            tfEndereco.setText(SistemaEntrega.listaDePessoas.get(i).getEndereco());            
            
            btAtualizar = new JButton ("Atualizar");
            btAtualizar.addActionListener(this);
		
            btRemover = new JButton ("Remover");
            btRemover.addActionListener(this);
	
            container = this.getContentPane();  
            container.add(lNome);
            container.add(tfNome);
            container.add(lCPF);
            container.add(tfCPF);
            container.add(lEndereco);
            container.add(tfEndereco);
            container.add(btAtualizar);
            container.add(btRemover);                   
        }
            
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btRemover)
        {          
                remove_cliente();         
        }
        
        else if(e.getSource() == btAtualizar)
        {            
            atualiza_cliente();         
        }
    }
   
    //Essa função remove um cliente da lista a partir de um índice previamente passado
    //pela janela de atualização
    private void remove_cliente()
    {
        Pessoa elemento = SistemaEntrega.listaDePessoas.remove(i); //remove serve pra List, removeElementAt não
        JOptionPane.showMessageDialog(this, "Cliente removido com sucesso!");
        limpar();
    }
    
    //Essa função atualiza um cliente da lista a partir de um índice previamente passado
    //pela janela de atualização. Primeiro ele verifica se os campos não estão vazios, ou seja
    //se não foram atualizados. Caso contrário, ele verifica se os campos estão certos antes
    //de atualizar na lista de clientes.    
    private void atualiza_cliente()
    {
        if(!tfNome.getText().equals(""))
            SistemaEntrega.listaDePessoas.get(i).setNome(tfNome.getText());
        
        if(!tfCPF.getText().equals(""))
        {
            if(RoverNumber.isCPF(tfCPF.getText()))
            {    
               SistemaEntrega.listaDePessoas.get(i).setCpf(tfCPF.getText());              
            }
            
            else
            {    
                JOptionPane.showMessageDialog(this, "CPF inválido!");
                return;
            }    
        }    
          
        if(!tfEndereco.getText().equals(""))
            SistemaEntrega.listaDePessoas.get(i).setEndereco(tfEndereco.getText());
        
        JOptionPane.showMessageDialog(this, "Cliente atualizado com sucesso!");
    }
    
    //Essa função limpa os campos de texto
    private void limpar()
    {
        tfNome.setText("");
        tfCPF.setText("");
        tfEndereco.setText("");
    }
}
