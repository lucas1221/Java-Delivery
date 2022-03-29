/*Essa janela está intimamente ligada com JanelaBuscarEntregador.java, que, de acordo com
a especificação do trabalho possui dois botões:
REMOVER -Remove entregador da lista de entregadores e
ATUALIZAR - Altera dados de um certo entregador, obtido a partir de uma busca pelo CPF
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

public class JanelaAtualizaEntregador extends JFrame implements ActionListener
{
    private Container container;
    //campos de texto
    private JTextField tfNome;
    private JTextField tfCPF;
    private JTextField tfEndereco;
    private JTextField tfCarteiraDeTrabalho;
    
    //descrições dos campos de texto
    private JLabel lNome;
    private JLabel lCPF;
    private JLabel lEndereco;
    private JLabel lCarteiraDeTrabalho;
    
    //botões
    private JButton btAtualizar;
    private JButton btRemover;
    private int i;
    
        public JanelaAtualizaEntregador(int i)
        {
            this.i = i;
            this.setLayout(new FlowLayout());
            this.pack();
            this.setResizable(true);
            this.setExtendedState(JFrame.MAXIMIZED_BOTH);
            this.setVisible(true);
            this.setTitle("Alterar Entregador");
            this.setSize(600,600);
            
            tfNome = new JTextField(40);
            lNome = new JLabel("Nome: ");   
            
            tfCPF = new JTextField(15);		
            lCPF = new JLabel ("Cpf: ");
            
            tfEndereco = new JTextField(60);		
            lEndereco = new JLabel ("Endereco: ");
            
            tfCarteiraDeTrabalho = new JTextField(15);		
            lCarteiraDeTrabalho = new JLabel ("Carteira De Trabalho: ");
         
            //com isso, as informçaões antigas do entregador são mostradas
            tfNome.setText(SistemaEntrega.listaDePessoas.get(i).getNome());
            tfCPF.setText(SistemaEntrega.listaDePessoas.get(i).getCpf());
            tfEndereco.setText(SistemaEntrega.listaDePessoas.get(i).getEndereco());
            tfCarteiraDeTrabalho.setText(((Entregador)SistemaEntrega.listaDePessoas.get(i)).getCarteiraDeTrabalho());
            
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
            container.add(lCarteiraDeTrabalho);
            container.add(tfCarteiraDeTrabalho);
            container.add(btAtualizar);
            container.add(btRemover); 
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btRemover)
        {
                remove_entregador();          
        }       
      
     else if(e.getSource() == btAtualizar)
        {            
            atualiza_entregador();         
        }
    }
    
    //Essa função remove um entregador da lista a partir de um índice previamente passado
    //pela janela de atualização
     private void remove_entregador()
    {
        Pessoa elemento = SistemaEntrega.listaDePessoas.remove(i); //remove serve pra List, removeElementAt não
        JOptionPane.showMessageDialog(this, "Entregador removido com sucesso!");
        limpar();
    }
    
    //Essa função atualiza um entregador da lista a partir de um índice previamente passado
    //pela janela de atualização. Primeiro ele verifica se os campos não estão vazios, ou seja
    //se não foram atualizados. Caso contrário, ele verifica se os campos estão certos antes
    //de atualizar na lista de entregadores. 
    private void atualiza_entregador()
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
        
        if(!tfEndereco.getText().equals(""))
            SistemaEntrega.listaDePessoas.get(i).setEndereco(tfEndereco.getText());
        
         if(!tfCarteiraDeTrabalho.getText().equals(""))
         {
              if(RoverNumber.ehInteiro(tfCarteiraDeTrabalho.getText()))
              {
                    ((Entregador)SistemaEntrega.listaDePessoas.get(i)).setCarteiraDeTrabalho(tfCarteiraDeTrabalho.getText());
              }
              
              else
              {
                  JOptionPane.showMessageDialog(this, "Número de Cateira de Trabalho inválido!");
                  return;
              }
         }  
        
        JOptionPane.showMessageDialog(this, "Entregador atualizado com sucesso!");
    }
   
    //Essa função limpa os campos de texto
    private void limpar()
    {
        tfNome.setText("");
        tfCPF.setText("");
        tfEndereco.setText("");
        tfCarteiraDeTrabalho.setText("");
    }
}        